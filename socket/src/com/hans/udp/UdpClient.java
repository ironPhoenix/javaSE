package com.hans.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class UdpClient {
	public static void main(String[] args) throws IOException {
		String s = "hello world";
		byte[] buf = s.getBytes();
	
		DatagramPacket dp = new DatagramPacket(buf, buf.length);
		try (DatagramSocket ds = new DatagramSocket(54321);) {
			dp.setSocketAddress(new InetSocketAddress("127.0.0.1", 12345));
			ds.send(dp);
		}

	}
}
