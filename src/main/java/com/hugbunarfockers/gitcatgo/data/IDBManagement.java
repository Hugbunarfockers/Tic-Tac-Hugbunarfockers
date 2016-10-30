package com.hugbunarfockers.gitcatgo.data;

import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface IDBManagement
{
	public boolean isClosed();

	public void close();

	public PreparedStatement prepareStatement(String sql);

	public void printSQLException(SQLException ex);
}
