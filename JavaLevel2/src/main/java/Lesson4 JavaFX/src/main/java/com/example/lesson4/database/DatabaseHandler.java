package com.example.lesson4.database;

import java.sql.*;

public class DatabaseHandler {
	private Connection connection;
	private Statement statement;
	public void connect() throws SQLException {
			connection = DriverManager.getConnection("jdbc:sqlite:chat.db");
			statement = connection.createStatement();
	}

	public void disconnect() {
		try {
			if (statement != null) {
				statement.close();
			}
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void signUpUser(String login, String password, String nick) throws SQLException {
		try (final PreparedStatement preparedStatement = connection.prepareStatement(DatabaseCommands.INSERT.getCommand() +
		 DatabaseCommands.AUTH_TABLE.getCommand() + "(login, password, nick) VALUES (?, ?, ?)" + "")) {
			preparedStatement.setString(1, login);
			preparedStatement.setString(2, password);
			preparedStatement.setString(3, nick);
			preparedStatement.executeUpdate();
		}
	}

	public String getUserData(String login, String pass) throws SQLException {
		String nick = "";
		try (final PreparedStatement preparedStatement = connection.prepareStatement("SELECT nick FROM Auth WHERE login = ? AND password = ?")) {
			preparedStatement.setString(1, login);
			preparedStatement.setString(2, pass);
			final ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				nick = resultSet.getString(1);
			}
		}
		return nick;
	}

	public void createAuthTable() throws SQLException {
		try {
		 statement.executeUpdate(DatabaseCommands.CREATE_TABLE.getCommand() + DatabaseCommands.AUTH_TABLE.getCommand()
				+ "("
				+ "id integer primary key autoincrement,"+
				"login text unique, " +
				"password text, " +
				"nick text" +
				")" +
				"");
		} catch (SQLException throwables) {
			throwables.printStackTrace();
			connection.rollback();
		}
	}
}
