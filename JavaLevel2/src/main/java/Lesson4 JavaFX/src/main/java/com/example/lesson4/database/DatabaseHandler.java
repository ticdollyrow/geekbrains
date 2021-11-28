package com.example.lesson4.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseHandler {
	private Connection connection;
	private Statement statement;
	public void connect() throws SQLException {
			connection = DriverManager.getConnection("jdbc:sqlite:chat.db");
			statement = connection.createStatement();
	}

	public void disconnect() {
		if(connection != null){
			try {
				connection.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}

	public void signUpUser(){

	}

	public void createAuthTable() throws SQLException {
		statement.executeUpdate(DatabaseCommands.CREATE_TABLE.getCommand() + "Auth("
				 + "id integer primary key autoincrement,"+
				"login text unique, " +
				"password text, " +
				"nick text" +
				")" +
				"");
	}
}
