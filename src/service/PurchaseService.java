package service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import bean.PurchaseDetails;
import exception.PurchaseException;

public class PurchaseService implements IPurchaseService{
	
	IPurchaseService ser = null;
	@Override
	public void addPurchaseDetails(PurchaseDetails pur) throws PurchaseException {
		// TODO Auto-generated method stub
		ser = new PurchaseService();
		
	}
	@Override
	public void validateDetails(PurchaseDetails pd) throws PurchaseException{
		// TODO Auto-generated method stub
		List<String> errors = new ArrayList<String>();
		if(!validatePhoneNumber(pd.getPhno())){
			errors.add("\n Phone Number Should be in 10 digit \n");
		}
		if(!validateCname(pd.getCname())){
			errors.add("\n Customer Name Should Be In Alphabets and minimum 1 characters long ! \n");
		}
		if(!validateMail(pd.getMailId())){
			errors.add("\n Mail Id should be in proper format \n");
		}
		if(!validateMobileId(pd.getMobileid())){
			errors.add("\n Mobile id should be in proper format \n");
		}
		if(!errors.isEmpty())
			throw new PurchaseException(errors +"");
	}
	
	
	boolean validateCname(String Cname){
		Pattern namePattern=Pattern.compile("^[A-Z]{1}[A-Za-z]{0,19}$");
		Matcher nameMatcher=namePattern.matcher(Cname);
		return nameMatcher.matches();
	}
	
	boolean validateMail(String mail){
		Pattern mailPattern=Pattern.compile("^[A-Za-z]+@gmail.com$");
		Matcher mailMatcher=mailPattern.matcher(mail);
		return mailMatcher.matches();
	}
	
	boolean validatePhoneNumber(String phoneNumber){
		Pattern phonePattern=Pattern.compile("^[1-9]{1}[0-9]{9}$");
		Matcher phoneMatcher=phonePattern.matcher(phoneNumber);
		return phoneMatcher.matches();
	}
	
	boolean validateMobileId(int mobileId){
		Pattern idPattern=Pattern.compile("^[0-9]{4}$");
		Matcher idMatcher=idPattern.matcher(Integer.toString(mobileId));
		return idMatcher.matches();
	}

}
