package com.hans.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
	public static void main(String[] args) throws IOException {
		while (true) {
			try (ServerSocket ss = new ServerSocket(23456);
					Socket socket = ss.accept();
					InputStreamReader isr = new InputStreamReader(
							socket.getInputStream());
					BufferedReader br = new BufferedReader(isr);) {
				String s = null;
				while ((s = br.readLine()) != null) {
					System.out.println(s);
				}

			}
		}
	}
}
