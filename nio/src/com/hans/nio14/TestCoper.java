package com.hans.nio14;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class TestCoper {
	public static void main(String[] args) throws Exception {
		RandomAccessFile aFile = new RandomAccessFile("src/a.txt", "rw");
		RandomAccessFile bFile = new RandomAccessFile("src/b.txt", "rw");
		FileChannel fc = aFile.getChannel();
		FileChannel fcb = bFile.getChannel();
		ByteBuffer bbuf = ByteBuffer.allocate(100);
		ByteBuffer buf = ByteBuffer.allocate(100);
		while(fc.read(bbuf)!=-1) {
			bbuf.flip();
			System.out.println("");
			while(bbuf.hasRemaining()) {
				byte b = bbuf.get();
				buf.put(b);
			}
			buf.flip();
			fcb.write(buf);
			bbuf.clear();
			buf.clear();
		}
	}
}
