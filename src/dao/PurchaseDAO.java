package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import util.DBConnection;
import bean.PurchaseDetails;
import exception.MobileException;

public class PurchaseDAO implements IPurchaseDAO{
	Logger logger = Logger.getRootLogger();
	public PurchaseDAO(){
		PropertyConfigurator.configure("resources/log4j.properties");
	}

	@Override
	public void addPurchaseDetails(PurchaseDetails pd) throws MobileException {
		// TODO Auto-generated method stub
		Connection conn = DBConnection.getInstance().getConnection();
		PreparedStatement preparedStatement = null;
		int queryResult;
		try{
			preparedStatement = conn.prepareStatement(QueryMapper.INSERT_INTO_QUERY);
			preparedStatement.setString(1,pd.getCname());
			preparedStatement.setString(2,pd.getMailId());
			preparedStatement.setString(3,pd.getPhno());
			preparedStatement.setDate(4,Date.valueOf(pd.getPurchaseDate()));
			preparedStatement.setInt(5,pd.getMobileid());
			
			queryResult = preparedStatement.executeUpdate();
			if(queryResult == 0){
				logger.error("Insertion failed");
				throw new MobileException("Inserting purchase details failed");
			}else{
				logger.info("Purchase Details added successfully");
			}
		}catch(SQLException sqlException){
			sqlException.printStackTrace();
			logger.error(sqlException.getMessage());
			throw new MobileException("Technical problem occured refer log");
		}
		finally{
			try{
				preparedStatement.close();
				conn.close();
			}catch(SQLException sqlException){
				sqlException.printStackTrace();
				logger.error(sqlException.getMessage());
				throw new MobileException("Error in closing db connection");
			}
		}
	}

}
