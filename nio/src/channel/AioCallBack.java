package channel;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class AioCallBack {
	public static void main(String[] args) throws IOException {
		try (AsynchronousFileChannel inChannel = AsynchronousFileChannel.open(
				Paths.get("src/a.txt"), StandardOpenOption.READ);) {
			ByteBuffer buffer = ByteBuffer.allocate(1024);
			/*
			 * asynchronousFileChannel.read(ByteBuffer dst,long position,A
			 * attachment, CompletionHandler<Integer,? super A> handler)
			 * 该函数是回调式中的核心函数 1.首先讲最后一个参数，它的第二个泛型类型和第三个参数类型一致为A
			 * 该接口有两个待实现的方法，completed(...)和failed(...) 分别代指完成时和失败时如何操作
			 * completed(Integer result, A attachment)的第一个参数是完成了多少个字节
			 * failed(Throwable exc, A attachment)的第一个参数是引起失败的异常类型 2.A
			 * 可以理解为在CompletionHandler的实现外部，要给实现内部什么信息
			 * 在下面的代码中，我传的A为buffer，以便实现的内部打印buffer信息,也可以传递String类型等
			 * 3.前两个参数分别为与通道交互的byteBuffer和起始位置
			 */
			inChannel.read(buffer, 0, buffer,
					new CompletionHandler<Integer, ByteBuffer>() {
						public void completed(Integer result,
								ByteBuffer attachment) {
							System.out.println(result);
							attachment.flip();
							while (attachment.hasRemaining()) {
								System.out.print((char) attachment.get());
							}
						}

						public void failed(Throwable exception,
								ByteBuffer attachment) {
							System.out.println("failed"
									+ exception.getMessage());
						}
					});
			
			// 做点别的
		}
	}
}
