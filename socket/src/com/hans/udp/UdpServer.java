package com.hans.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpServer {
	public static void main(String[] args) throws IOException {
		byte[] buf = new byte[1024];
		DatagramPacket dp = new DatagramPacket(buf, buf.length);
		try (DatagramSocket ds = new DatagramSocket(12345);) {
			
				ds.receive(dp);
				String s = new String(dp.getData());
				System.out.println(s);
			
		} 

	}
}
