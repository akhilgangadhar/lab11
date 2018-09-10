package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import exception.MobileException;
import util.DBConnection;
import bean.Mobile;

public class MobileDAO implements IMobileDAO{
	
	Logger logger = Logger.getRootLogger();
	public MobileDAO(){
		PropertyConfigurator.configure("resources/log4j.properties");
	}

	@Override
	public Mobile addMobileDetails(Mobile mob) throws MobileException {
		// TODO Auto-generated method stub
		Connection conn = DBConnection.getInstance().getConnection();
		PreparedStatement preparedStatement = null;
		int queryResult;
		try{
			preparedStatement = conn.prepareStatement(QueryMapper.INSERT_INTO_QUERY);
			preparedStatement.setString(1,mob.getName());
			preparedStatement.setDouble(2,mob.getPrice());
			preparedStatement.setInt(3,mob.getQuantity());
			
			queryResult = preparedStatement.executeUpdate();
			if(queryResult == 0){
				logger.error("Insertion failed");
				throw new MobileException("Inserting mobile details failed");
			}else{
				logger.info("Mobile Details added successfully");
				return mob;
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

	@Override
	public void deleteMobileDetails(String id) throws MobileException {
		// TODO Auto-generated method stub
		Connection conn = DBConnection.getInstance().getConnection();
		PreparedStatement preparedStatement = null;
		int queryResult;
		try{
			preparedStatement = conn.prepareStatement(QueryMapper.DELETE_QUERY);
			preparedStatement.setInt(1,Integer.parseInt(id));
			
			queryResult = preparedStatement.executeUpdate();
			if(queryResult == 0){
				logger.error("Deletion failed");
				throw new MobileException("Deleting mobile details failed");
			}else{
				logger.info("Mobile Details deleted successfully");
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

	@Override
	public List<Mobile> retriveAllDetails() throws MobileException {
		// TODO Auto-generated method stub
		Connection conn = DBConnection.getInstance().getConnection();
		PreparedStatement ps = null;
		ResultSet resultset = null;
		
		List<Mobile> mobileList = new ArrayList<Mobile>();
		try{
			ps = conn.prepareStatement(QueryMapper.RETRIVE_ALL);
			resultset = ps.executeQuery();
			while(resultset.next()){
				Mobile mob = new Mobile();
				mob.setId(resultset.getInt(1));
				mob.setName(resultset.getString(2));
				mob.setPrice(resultset.getDouble(3));
				mob.setQuantity(resultset.getInt(4));
				mobileList.add(mob);
			}
		}catch(SQLException sqlException){
			logger.error(sqlException.getMessage());
			throw new MobileException("Technical problem occured. Refer log");
		}
		finally{
			try{
				resultset.close();
				ps.close();
				conn.close();
			}catch(SQLException e){
				logger.error(e.getMessage());
				throw new MobileException("Error in closing db connection");
			}
		}
		return mobileList;
	}

	@Override
	public void updateMobileQuantity(String mobileId) throws MobileException{
		// TODO Auto-generated method stub
		Connection conn = DBConnection.getInstance().getConnection();
		PreparedStatement preparedStatement = null;
		int queryResult;
		try{
			preparedStatement = conn.prepareStatement(QueryMapper.UPDATE_QUERY);
			preparedStatement.setInt(1,Integer.parseInt(mobileId));
			
			queryResult = preparedStatement.executeUpdate();
			if(queryResult == 0){
				logger.error("Update failed");
				throw new MobileException("Updating mobile details failed");
			}else{
				logger.info("Mobile Details updated successfully");
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

	@Override
	public List<Mobile> searchRange(Double price1,Double price2) throws MobileException {
		// TODO Auto-generated method stub
		Connection conn = DBConnection.getInstance().getConnection();
		PreparedStatement ps = null;
		ResultSet resultset = null;
		
		List<Mobile> mobileList = new ArrayList<Mobile>();
		try{
			ps = conn.prepareStatement(QueryMapper.RANGE_QUERY);
			ps.setDouble(1,price1);
			ps.setDouble(2,price2);
			resultset = ps.executeQuery();
			while(resultset.next()){
				Mobile mob = new Mobile();
				mob.setId(resultset.getInt(1));
				mob.setName(resultset.getString(2));
				mob.setPrice(resultset.getDouble(3));
				mob.setQuantity(resultset.getInt(4));
				mobileList.add(mob);
			}
		}catch(SQLException sqlException){
			logger.error(sqlException.getMessage());
			throw new MobileException("Technical problem occured. Refer log");
		}
		finally{
			try{
				resultset.close();
				ps.close();
				conn.close();
			}catch(SQLException e){
				logger.error(e.getMessage());
				throw new MobileException("Error in closing db connection");
			}
		}
		return mobileList;
	}

}
