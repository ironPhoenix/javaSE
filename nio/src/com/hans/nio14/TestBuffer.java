package com.hans.nio14;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;

public class TestBuffer {
	public static void main(String[] args) throws Exception {
		RandomAccessFile aFile = new RandomAccessFile("src/a.txt", "rw");//�ɶ���д ȡ�ļ�   �ļ�û�ҵ�ʱ���ᱨ��
		FileChannel inChannel = aFile.getChannel();//�õ�һ���ļ�ͨ��

		// create buffer with capacity of 48 bytes
		ByteBuffer buf = ByteBuffer.allocate(180);

		//int bytesRead = ; // read into buffer.
		//System.out.println(bytesRead);
		
		while (inChannel.read(buf) != -1) {
			System.out.println("#aa#");
			buf.flip(); // make buffer ready for read
			
			CharBuffer cb = buf.asCharBuffer();
			char[] c = new char[18];
			cb.get(c);

			System.out.println(c);
			/*while (cb.hasRemaining()) {
				
				System.out.println(cb.get()); // read 1 byte at a time
			}*/
			
			buf.clear(); // make buffer ready for writing
			//bytesRead = inChannel.read(buf);
		}
		aFile.close();
	}
}
