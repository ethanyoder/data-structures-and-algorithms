//Ethan Yoder
//August 29, 2016
//This class creates producers, consumers, and threads and records packet information

import java.io.IOException;

public class PacketHandlingDriver {
	
	//creates static members
	private static SinglyLinkedList<Packet> packets = new SinglyLinkedList<Packet>();
	
	public static void main(String[] args) throws IOException {
		
		//creates members
		Producer producer1 = new Producer(20);
		Producer producer2 = new Producer(75);
		Producer producer3 = new Producer(90);
		Consumer consumer = new Consumer();
		
		//creates threads
		Thread threadProducer1 = new Thread() {
			public void run() {			
				producer1.sendPacket(packets);
			}
		};
		
		Thread threadProducer2 = new Thread() {
			public void run() {
				producer2.sendPacket(packets);
			}
		};
		
		Thread threadProducer3 = new Thread() {
			public void run() {
				producer3.sendPacket(packets);
			}
		};
		
		Thread threadConsumer = new Thread() {
			public void run() {
				consumer.processPacket(packets);
			}
		};	
		
		//starts threads
		threadProducer1.start();
		threadProducer2.start();
		threadProducer3.start();
		threadConsumer.start();

	}

}
