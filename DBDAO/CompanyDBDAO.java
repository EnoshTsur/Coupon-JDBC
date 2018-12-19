package DBDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.CompanyDAO;
import entities.Company;
import entities.Coupon;
import enums.CouponType;
import exceptions.CompanyExistsException;
import exceptions.CompanyNotExistsException;
import pool.ConnectionPool;

public class CompanyDBDAO implements CompanyDAO {

	private ConnectionPool pool = ConnectionPool.getInstance();
	private String sql;
	
	/***
	 * Create company
	 */
	@Override
	public void createCompany(Company company) throws CompanyExistsException {
		sql = "INSERT INTO COMPANY (NAME, EMAIL, PASSWORD) VALUES(?, ?, ?)";
		
		Connection connection = pool.getConnection();
		
		try(PreparedStatement pstmt = connection.prepareStatement(sql)){

			pstmt.setString(1, company.getName());
			pstmt.setString(2, company.getEmail());
			pstmt.setString(3, company.getPassword());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			pool.returnConnection(connection);
		}

	}

	@Override
	public void updateCompany(String email, String password, long id) throws CompanyNotExistsException {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeCompany(long id) throws CompanyNotExistsException {
		// TODO Auto-generated method stub

	}

	@Override
	public Company getCompany(long id) throws CompanyNotExistsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Company> getAllCompanies() {
		// TODO Auto-generated method stub
		return null;
	}

	/***
	 * Get All Company's Coupons
	 */
	@Override
	public List<Coupon> getCompanyCoupons(long companyID) throws CompanyNotExistsException {
		
		List<Coupon> allCompanyCoupons = new ArrayList<>();
		
		sql = "SELECT * FROM COUPON WHERE ID IN (SELECT COUPON_ID FROM COMPANY_COUPON WHERE COMPANY_ID = ?)";
		
		Connection connection = pool.getConnection();
		
		try(PreparedStatement pstmt = connection.prepareStatement(sql)){

			pstmt.setLong(1, companyID);
			
			try(ResultSet resultSet = pstmt.executeQuery()){
				
				while(resultSet.next()) {
					Coupon coupon = new Coupon(
							resultSet.getString(2),
							resultSet.getDate(3), 
							resultSet.getDate(4), 
							resultSet.getInt(5), 
							CouponType.valueOf(resultSet.getString(6)), 
							resultSet.getString(7), 
							resultSet.getDouble(8), 
							resultSet.getString(9));
					
					coupon.setId(resultSet.getLong(1));
					
					allCompanyCoupons.add(coupon);
				}
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pool.returnConnection(connection);
		}
		
		return allCompanyCoupons;
	}

	@Override
	public boolean login(String name, String password) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
