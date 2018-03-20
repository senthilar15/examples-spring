package com.examples.beans.xmls.methodinjection;

import org.springframework.beans.factory.annotation.Lookup;

public abstract class CommandManager<T extends Command> {
	
	public void callCommand(String command) {
		
		System.out.println(command +"on CommandManager >>>"+this.hashCode());
		Command c = createCommand();
		c.execute(command);
		
		
	}
	
	//@Lookup("createCommand")
	public abstract Command createCommand();
	

}
