package DBDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import DAO.CouponDAO;
import entities.Coupon;
import enums.CouponType;
import exceptions.CompanyNotExistsException;
import exceptions.CouponExistsException;
import exceptions.CouponNotExistsException;
import pool.ConnectionPool;

public class CouponDBDAO implements CouponDAO {

	private ConnectionPool pool = ConnectionPool.getInstance();
	private String sql;

	@Override
	public void createCoupon(Coupon coupon) throws CouponExistsException {
		
		sql = "INSERT INTO COUPON (TITLE, START_DATE, END_DATE, AMOUNT, TYPE, MESSAGE, PRICE, IMAGE) VALUES " +
				"(?, ?, ?, ?, ?, ?, ?, ?)";
		
		Connection connection = pool.getConnection();
		
		try(PreparedStatement pstmt = connection.prepareStatement(sql)){

			pstmt.setString(1, coupon.getTitle());
			pstmt.setDate(2, coupon.getStartDate());
			pstmt.setDate(3, coupon.getEndDate());
			pstmt.setInt(4, coupon.getAmount());
			pstmt.setString(5, coupon.getType().name());
			pstmt.setString(6, coupon.getMessage());
			pstmt.setDouble(7, coupon.getPrice());
			pstmt.setString(8, coupon.getImage());
			
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pool.returnConnection(connection);
		}

	}
	
	/*****
	 * NEW ONE!!!!
	 */
	public void insertCompanyCoupon(long compId, long coupId) {
		
		sql = "INSERT INTO COMPANY_COUPON VALUES (? , ?)";
		
		Connection connection = pool.getConnection();
		
		try(PreparedStatement pstmt = connection.prepareStatement(sql)){

			pstmt.setLong(1, compId);
			pstmt.setLong(2, coupId);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			pool.returnConnection(connection);
		}
	}

	@Override
	public void updateCoupon(Date endDate, double price, long coupId, long compId) throws CouponNotExistsException {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeCoupon(long coupId, long compId) throws CouponNotExistsException, CompanyNotExistsException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Coupon> getAllCoupons() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Coupon> getCouponsByType(CouponType type) {
		// TODO Auto-generated method stub
		return null;
	}

}
