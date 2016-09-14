//Ethan Yoder
//August 29, 2016
//This class represents a Packet data structure

public class Packet {

	//declares members
	private String data;
	private String time;
	private int from;
	private int to;
	private int size;
	
	//creates overloaded constructor
	public Packet(String data, String time, int from, int to, int size) {
		this.data = data;
		this.time = time;
		this.from = from;
		this.to = to;
		this.size = size;
	}
	
	//creates getter and setter methods
	/**
	 * @return the data
	 */
	public String getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(String data) {
		this.data = data;
	}

	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}

	/**
	 * @return the from
	 */
	public int getFrom() {
		return from;
	}

	/**
	 * @param from the from to set
	 */
	public void setFrom(int from) {
		this.from = from;
	}

	/**
	 * @return the to
	 */
	public int getTo() {
		return to;
	}

	/**
	 * @param to the to to set
	 */
	public void setTo(int to) {
		this.to = to;
	}

	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}
	
}
