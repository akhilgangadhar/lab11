package dao;

import bean.PurchaseDetails;
import exception.MobileException;

public interface IPurchaseDAO {
	public void addPurchaseDetails(PurchaseDetails pd) throws MobileException;
}
