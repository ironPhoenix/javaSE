package mbuffer;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class TestMapA {
	public static void main(String[] args) throws IOException {
		int length = 0x8FFFFFF;//一个byte占1B，所以共向文件中存128M的数据
		try (FileChannel channel = FileChannel.open(Paths.get("src/c.txt"),
				StandardOpenOption.READ, StandardOpenOption.WRITE);) {
			MappedByteBuffer mapBuffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, length);
			for(int i=0;i<length;i++) {
				mapBuffer.put((byte)0);
			}
			for(int i = length/2;i<length/2+4;i++) {
				//像数组一样访问
				System.out.println(mapBuffer.get(i));
			}
		}
	}
}
