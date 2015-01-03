package buffer;

import java.nio.ByteBuffer;

public class BasicBuffer {
	public static void main(String[] args) {
		ByteBuffer bb = ByteBuffer.allocate(48);
		/*向ByteBuffer中put数据的时候，一下四种形式都可以
		 * put(byte b)	
		 * put(byte[] src) 
		 * put(byte[] src, int offset, int length)
		 * put(ByteBuffer src)
		 * 四种形式都会移动position指针
		 */
		bb.put(new byte[]{1,2,4,2,-13});
		bb.flip();
		while(bb.hasRemaining()) {
			System.out.println(bb.get());
		}
	}
}
