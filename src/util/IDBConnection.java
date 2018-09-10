package util;

import java.io.IOException;
import java.sql.*;
import java.util.*;

import exception.MobileException;
import oracle.jdbc.pool.OracleDataSource;

public interface IDBConnection {
	Connection getConnection() throws MobileException;
	Properties loadProperties() throws IOException;
	OracleDataSource prepareDataSource() throws SQLException;
}
