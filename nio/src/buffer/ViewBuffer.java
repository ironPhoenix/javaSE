package buffer;

import java.nio.ByteBuffer;

public class ViewBuffer {
	public static void main(String[] args) {
		ByteBuffer bb = ByteBuffer.allocate(1024);
		//将ByteBuffer转化为CharBuffer视图后，再调用put，ByteBuffer中的position指针不会移动
		bb.asCharBuffer().put("Hello World");
		//为了能正确的输出，这里改变了limit指针的位置，使之变到了字符数组的末尾
		bb.limit("Hello World".length()*Character.BYTES);//字符数组长度*每个字符占的字节数
		while(bb.hasRemaining()) {
			System.out.print(bb.getChar());
		}
		/*也可用如下的方法输出
		 * while((c=bb.getChar())!=0) {
		 *    System.out.print(c);
		 * }
		 * */
	}
}
