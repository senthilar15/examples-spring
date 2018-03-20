package com.examples.beans.xmls.methodinjection;

public class Command {
	
	public void execute(String str) {
		System.out.println(str + this.hashCode());
	}

}
