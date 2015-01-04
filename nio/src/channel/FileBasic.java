package channel;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileBasic {
	public static void main(String[] args) throws IOException {
		/* 
		 * 1.Channel是需要关闭的，所以这里用TWR方式确保Channel正确关闭
		 * 2.鼓励大家用这种方法打开通道FileChannel.open(Path path, OpenOption... options)
		 */
		try (FileChannel inChannel = FileChannel.open(Paths.get("src/a.txt"),StandardOpenOption.READ);
				FileChannel outChannel = FileChannel.open(Paths.get("src/b.txt"),StandardOpenOption.WRITE);) {

			ByteBuffer buf = ByteBuffer.allocate(48);
			/*
			 * 1.channel.write()和read()方法是需要移动position和limit指针的
			 * 		所以需要用buffer.flip()等方法，来保证读写正确
			 * 2.channel.read()方法是从通道读取到缓冲区中，读取的字节数量是n (n是buffer中当前剩余的容量)，
			 * 		但是读取的数量是取决于通道的当前状态。例如：要读到文件末尾，不够buffer的容量也就是 通道剩余<=n,
			 * 		或者说ServerSocketChannel 当前只能读取准备好的，这很可能<n,所以说加循环，
			 * 		另外read的方法返回当前读取的数量，一个int 可以根据他来设定while
			 * 		如果返回-1，表示到了文件末尾
			 */
			int bytesRead = inChannel.read(buf);
			while (bytesRead != -1) {

				buf.flip();
				/*
				 *注意fileChannel.write()是在while循环中调用的。
				 *因为无法保证write()方法一次能向FileChannel写入多少字节，
				 *因此需要重复调用write()方法，直到Buffer中已经没有尚未写入通道的字节。
				 */
				while (buf.hasRemaining()) {
					outChannel.write(buf);
				}

				buf.clear();
				bytesRead = inChannel.read(buf);
			}
		}
	}
}
