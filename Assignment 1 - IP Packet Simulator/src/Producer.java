//Ethan Yoder
//August 29, 2016
//This class represents someone who creates messages for the consumer

import java.text.*;
import java.util.*;

public class Producer {

	//declares members
	private int ipAddress;
	private Random rand = new Random();
	private String[] messages = {"Good morning!", "Are you free today?", "Could you help me with something?",
			   "Will you be at the meeting?", "Call me when you get the chance", "When are we meeting today?"};
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date;

	
	//creates overloaded constructor
	public Producer(int ipAddress) {
		this.ipAddress = ipAddress;
	}

	//creates getter and setter methods
	/**
	 * @return the ipAddress
	 */
	public int getIpAddress() {
		return ipAddress;
	}

	/**
	 * @param ipAddress the ipAddress to set
	 */
	public void setIpAddress(int ipAddress) {
		this.ipAddress = ipAddress;
	}
	
	//this method creates a message to send to a consumer
	public void sendPacket(SinglyLinkedList<Packet> packets) {
		//creates time variable
		long startTime = System.currentTimeMillis();
		int timeInterval = 10000;
		while (System.currentTimeMillis() - startTime < timeInterval) {
			//a packet will be generated at random time intervals between 0 and 5 seconds
			if (System.currentTimeMillis() % (rand.nextInt(5000) + 1) == 0) {
				//chooses random message
				String message = messages[rand.nextInt(messages.length)];
				//instantiate date class
				date = new Date();	
				//creates packet
				Packet newPacket = new Packet(message, dateFormat.format(date), ipAddress,rand.nextInt(256), message.length());
				packets.addLast(newPacket);
			}
		}
	}
	
	
}
