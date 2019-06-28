package com.hm.pagination.dao;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class BaseDao  {

    //提交事务
	public static void commit(Connection conn)
	{
		if(null!=conn)
		{
			try {
				conn.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}


	}

  //回滚事务
	public static void rollback(Connection conn)
	{
		if(null!=conn)
		{
			try {
				conn.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	//开始事务
	public static void begin(Connection conn)
	{
		if(null!=conn)
		{
			try {
				conn.setAutoCommit(false);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}


	/**
	 * @return Connection
	 * @throws Exception
	 */
	public static Connection getConnection() throws Exception
	{
		Properties properties=new Properties();
		//
		//new fileinputStream();
		InputStream is=BaseDao.class.getClassLoader().getResourceAsStream("dbconfig.properties");
		//jdbc
		properties.load(is);
		String driver=properties.getProperty("jdbc.driver");
		String username=properties.getProperty("jdbc.username");
		String password=properties.getProperty("jdbc.password");
		String url=properties.getProperty("jdbc.url");
		/*System.out.println(driver+"password"+password);*/
		Class.forName(driver);

		return DriverManager.getConnection(url, username, password);

	}
	/**
	 *
	 * @param conn
	 * @param statement
	 * @param resultSet
	 */
	public static void closeResources(Connection conn,Statement statement,ResultSet resultSet)
	{
		if(null!=conn)
		{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(null!=statement)
		{
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if(null!=resultSet)
		{
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}


	}




}
