package test;


import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import dao.MobileDAO;
import service.MobileService;
import bean.Mobile;
import exception.MobileException;


public class MobileDAOTest {
	static MobileService mbs;
	static MobileDAO mao;
	static Mobile mob;
	
	@BeforeClass
	public static void initialize() {
		System.out.println("in before class");
		mao = new MobileDAO();
		mob = new Mobile();
		mob.setName("Nokia");
		mob.setPrice(1000);
		mob.setQuantity(40);
	}
	
	@Test
	public void addMobileDetails() throws MobileException {

		assertNotNull(mbs.addMobileDetails(mob));

	}
	
}
