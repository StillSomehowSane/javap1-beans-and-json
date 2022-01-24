package com.asint.javap1_beans;

public class TypicalPOJOPerson {

	public String name;
	
	private Integer id;

	public TypicalPOJOPerson(String name, Integer id) {
		super();
		this.name = name;
		this.id = id;
	}

	public String name() {
		return name;
	}
	
	public Integer getIdentity() {
		return id;
	}
}
