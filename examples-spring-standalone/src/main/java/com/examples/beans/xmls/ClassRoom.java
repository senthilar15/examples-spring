package com.examples.beans.xmls;

public class ClassRoom {
	
	private int roomNo;
	private String name;
	private Department dept;
	
	public ClassRoom(String name, int roomNo) {
		this.name = name;
		this.roomNo = roomNo;
	}

	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}
	
	
	

}
