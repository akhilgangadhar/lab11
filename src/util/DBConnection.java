package util;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.*;

import exception.MobileException;
import oracle.jdbc.pool.OracleDataSource;

public class DBConnection implements IDBConnection{
	private static Connection conn = null;
	private static Properties props = null;
	private static OracleDataSource dataSource = null;
	private static DBConnection instance = null;
	
	public DBConnection() throws MobileException{
		try{
			props = loadProperties();
			dataSource = prepareDataSource();
		}catch(IOException e){
			throw new MobileException("couldnt read the database details from properties file");
		}catch(SQLException e){
			throw new MobileException(e.getMessage());
		}
	}
	
	public static DBConnection getInstance() throws MobileException{
		synchronized (DBConnection.class){
			if(instance == null){
				instance = new DBConnection();
			}
		}
		return instance;
	}

	@Override
	public Connection getConnection() throws MobileException {
		// TODO Auto-generated method stub
		try{
			conn = dataSource.getConnection();
		}catch(SQLException e){
			throw new MobileException(e.getMessage());
		}
		return conn;
	}

	@Override
	public Properties loadProperties() throws IOException{
		// TODO Auto-generated method stub\
		if(props == null){
			Properties newProps = new Properties();
			String filename = "resources/jdbc.properties";
			InputStream inputStream  = new FileInputStream(filename);
			newProps.load(inputStream);
			inputStream.close();
			return newProps;
		}
		return props;
	}

	@Override
	public OracleDataSource prepareDataSource() throws SQLException {
		// TODO Auto-generated method stub
		if(dataSource == null){
			if(props != null){
				String connectionUrl = props.getProperty("url");
				String username = props.getProperty("username");
				String password = props.getProperty("password");
				
				dataSource = new OracleDataSource();
				dataSource.setURL(connectionUrl);
				dataSource.setUser(username);
				dataSource.setPassword(password);
			}
		}
		return dataSource;
	}
	
}
