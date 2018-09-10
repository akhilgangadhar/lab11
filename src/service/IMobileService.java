package service;

import java.util.List;

import bean.Mobile;
import exception.MobileException;

public interface IMobileService {
	public Mobile addMobileDetails(Mobile mob) throws MobileException;
	public void deleteMobileDetails(String mobileId) throws MobileException;
	public List<Mobile> retriveAllDetails() throws MobileException;
	public List<Mobile> searchRange(Double lprice,Double hprice) throws MobileException;
	public void updateMobileQuantity(String mobileId) throws MobileException;
}

