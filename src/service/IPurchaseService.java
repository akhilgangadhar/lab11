package service;

import java.util.List;

import bean.PurchaseDetails;
import exception.PurchaseException;

public interface IPurchaseService {
	public void addPurchaseDetails(PurchaseDetails pd) throws PurchaseException;

	public void validateDetails(PurchaseDetails pd) throws PurchaseException;

}
