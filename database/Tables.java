package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import pool.ConnectionPool;

public class Tables {
	
	// Connection Pool
	private ConnectionPool pool = ConnectionPool.getInstance();


	/***
	 * Create Coupon
	 */
	public void createCoupon() {

		String sql = "CREATE table Coupon ("
				+ "ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
				+ "TITLE VARCHAR(70)," + "START_DATE DATE," + "END_DATE DATE," + "AMOUNT INTEGER," + "TYPE VARCHAR(50),"
				+ "MESSAGE VARCHAR(255)," + "PRICE DOUBLE," + "IMAGE VARCHAR(255))";
		Connection connection = pool.getConnection();

		try (PreparedStatement pstmt = connection.prepareStatement(sql)) {

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pool.returnConnection(connection);
		}
	}
	

	/***
	 * Create Company
	 */
	public void createCompany() {
		String sql = "CREATE table Company ("
				+ "ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
				+ "NAME VARCHAR(70)," + "EMAIL VARCHAR(20)," + "PASSWORD VARCHAR(20))";
		Connection connection = pool.getConnection();

		try (PreparedStatement pstmt = connection.prepareStatement(sql)) {

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pool.returnConnection(connection);
		}
	}

	
	/***
	 * Create Company Coupon
	 */
	public void createCompanyCoupon() {
		String sql = "CREATE TABLE COMPANY_COUPON (COMPANY_ID INTEGER, COUPON_ID INTEGER, PRIMARY KEY(COMPANY_ID, COUPON_ID))";

		Connection connection = pool.getConnection();

		try (PreparedStatement pstmt = connection.prepareStatement(sql)) {

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pool.returnConnection(connection);
		}
	}
}
