package com.hans.tcp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class TcpClient {
	public static void main(String[] args) throws IOException {
		try(Socket socket = new Socket("127.0.0.1", 23456); 
				OutputStream os = socket.getOutputStream();
				BufferedOutputStream bos = new BufferedOutputStream(os);
				FileInputStream fis = new FileInputStream("src/a.txt");
				BufferedInputStream bis = new BufferedInputStream(fis);) {
			int i;
			while((i=bis.read())!=-1) {
				bos.write(i);
				bos.flush();
			}
		}
		
	}
}
