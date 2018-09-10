package dao;

import java.util.List;

import exception.MobileException;
import bean.Mobile;

public interface IMobileDAO {
	public Mobile addMobileDetails(Mobile mob) throws MobileException;
	public void deleteMobileDetails(String mobileId) throws MobileException;
	public List<Mobile> retriveAllDetails() throws MobileException;
	public List<Mobile> searchRange(Double lprice,Double hprice) throws MobileException;
	public void updateMobileQuantity(String mobileId) throws MobileException;
}
