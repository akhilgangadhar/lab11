package service;

import java.util.List;

import dao.IMobileDAO;
import dao.MobileDAO;
import bean.Mobile;
import exception.MobileException;

public class MobileService implements IMobileService{
	IMobileDAO mobiledao;
	
	@Override
	public Mobile addMobileDetails(Mobile mob) throws MobileException {
		// TODO Auto-generated method stub
		mobiledao = new MobileDAO();
		Mobile ret = mobiledao.addMobileDetails(mob);
		return ret;
	}

	@Override
	public void deleteMobileDetails(String mobileId) throws MobileException {
		// TODO Auto-generated method stub
		mobiledao = new MobileDAO();
		mobiledao.deleteMobileDetails(mobileId);
	}

	@Override
	public List<Mobile> retriveAllDetails() throws MobileException {
		// TODO Auto-generated method stub
		mobiledao = new MobileDAO();
		List<Mobile> list;
		list = mobiledao.retriveAllDetails();
		return list;
	}

	@Override
	public void updateMobileQuantity(String mobileId) throws MobileException {
		// TODO Auto-generated method stub
		mobiledao = new MobileDAO();
		mobiledao.updateMobileQuantity(mobileId);
	}

	@Override
	public List<Mobile> searchRange(Double lprice,Double hprice) throws MobileException {
		// TODO Auto-generated method stub
		mobiledao = new MobileDAO();
		List<Mobile> list;
		list = mobiledao.searchRange(lprice, hprice);
		return list;
	}

}
