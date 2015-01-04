package channel;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.Future;

public class AioFuture {
	public static void main(String[] args) throws IOException {
		try (AsynchronousFileChannel inChannel = AsynchronousFileChannel.open(
				Paths.get("src/a.txt"), StandardOpenOption.READ);) {
			ByteBuffer buffer = ByteBuffer.allocate(1024);
			//read的第二个参数指定了channel的起始位置
			Future<Integer> result = inChannel.read(buffer, 0);
			//一直轮询I/O操作是否完成
			while (!result.isDone()) {
				// 做点别的
			}
			buffer.flip();
			while (buffer.hasRemaining()) {
				System.out.print((char) buffer.get());
			}
		}
	}
}
