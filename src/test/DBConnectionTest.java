package test;

import java.sql.Connection;

import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import util.DBConnection;
import exception.MobileException;

public class DBConnectionTest {
	static Connection dbCon;
	
	@BeforeClass
	public static void initialise(){
		dbCon = null;
	}
	
	@Before
	public void beforeEachTest(){
		System.out.println("----Starting DBConnection Test Case----\n");
	}
	
	@Test
	public void test() throws MobileException{
		Connection dbCon = DBConnection.getInstance().getConnection();
		Assert.assertNotNull(dbCon);
	}
	
	@After
	public void afterEachTest(){
		System.out.println("----End of DBConnection Test Case----\n");
	}
	
	@AfterClass
	public static void destroy(){
		System.out.println("\t----End of Tests----");
		dbCon = null;
	}
}
