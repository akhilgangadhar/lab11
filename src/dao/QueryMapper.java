package dao;

public interface QueryMapper {	
	public static final String UPDATE_QUERY = "UPDATE mobiles set quantity=quantity-1 WHERE mobileid=?";
	public static final String INSERT_INTO_QUERY = "INSERT INTO mobiles values(mobileId_sequence.NEXTVAL,?,?,?)";
	public static final String RETRIVE_ALL = "SELECT mobileid,name,price,quantity FROM mobiles";
	public static final String DELETE_QUERY = "DELETE * FROM mobiles where mobileid=?";
	public static final String MOBILEID_QUERY_SEQUENCE = "SELECT mobileId_sequence.CURRVAL FROM DUAL";
	public static final String RANGE_QUERY = "SELECT mobileid,name,price,quantity FROM mobiles WHERE price>? and price<?";
	public static final String INSERT_PURCHASE = "INSERT INTO purchasedetails values(purchaseDetailsId_sequence.NEXTVAL,?,?,?,?,?)";
}
