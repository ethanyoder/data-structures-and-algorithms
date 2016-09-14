//Ethan Yoder
//August 29, 2016
//This class represents a consumer who gets new messages from producers and processes them

import java.io.*;

public class Consumer {

	//declares members
	private FileWriter fw;
	private PrintWriter pw;
	
	//creates no-arg constructor to handle IO exceptions
	public Consumer() throws IOException {
		fw = new FileWriter("activity.log", false);
		pw = new PrintWriter(fw);
	}
	
	//processes packet - checks list and then calls the print and log methods
	public void processPacket(SinglyLinkedList<Packet> packets) {
		Packet firstPacket;
		long beginTime = System.currentTimeMillis();
		int timeInterval = 10000;
		while (System.currentTimeMillis() - beginTime < timeInterval) {
			//the consumer will check for packets every 10 milliseconds
			if (System.currentTimeMillis() % 10 == 0) {
				if (!packets.isEmpty()) {	
					firstPacket = packets.first();
					if (firstPacket.getTo() < 100) {
						logPacket(firstPacket);
						printPacket(firstPacket);
					}
					packets.removeFirst();
				}
			}
		}
		System.out.println("Done");
		pw.close();
		System.exit(0);
	}
	
	//logs packet information
	public void logPacket(Packet packet) {
		pw.println("From: " + packet.getFrom() + ",To: " + packet.getTo() + ",Time: " + packet.getTime());
	}
	
	//writes packet information to the console
	public void printPacket(Packet packet) {
		System.out.println("From: " + packet.getFrom() + "\tTo: " + packet.getTo() + "\t\tTime: " + packet.getTime() +
						   "\t\tSize: " + packet.getSize() + "\tMessage: " + packet.getData());
	}
	
}
