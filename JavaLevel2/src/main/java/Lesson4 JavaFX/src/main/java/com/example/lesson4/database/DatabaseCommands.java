package com.example.lesson4.database;

public enum DatabaseCommands {

	CREATE_TABLE("CREATE TABLE IF NOT EXISTS "),
	AUTH_TABLE("Auth"),
	INSERT("INSERT INTO ");
	private String command;

	DatabaseCommands(String command){
		this.command = command;
	}

	public String getCommand() {
		return command;
	}

}
