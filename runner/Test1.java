package runner;

import java.util.List;

import DBDAO.CompanyDBDAO;
import DBDAO.CouponDBDAO;
import entities.Company;
import entities.Coupon;
import enums.CouponType;
import exceptions.CompanyExistsException;
import exceptions.CompanyNotExistsException;
import exceptions.CouponExistsException;
import utils.DateUtils;

public class Test1 {

	public static void main(String[] args) {

		/***
		 * Create Company
		 */
		CompanyDBDAO compDb = new CompanyDBDAO();

		Company company = new Company("Aroma", "1234", "aroma@Gmail.com");

		try {
			compDb.createCompany(company);
		} catch (CompanyExistsException e) {
			e.printStackTrace();
		}

		
		
		
		
		
		/***
		 * Create Coupon
		 */
		CouponDBDAO coupDb = new CouponDBDAO();

		Coupon coupon = new Coupon("title", DateUtils.fixDate("2018-01-01"), DateUtils.fixDate("2019-01-01"),
				 3 , CouponType.FOOD, "hi there", 24, "image");

		try {
			coupDb.createCoupon(coupon);
		} catch (CouponExistsException e) {
			e.printStackTrace();
		}

		coupDb.insertCompanyCoupon(1, 2);

		
		
		
		
		
		/***
		 * Get all Company's Coupons
		 */
		try {
			List<Coupon> allCoupons = compDb.getCompanyCoupons(1);
			System.out.println(allCoupons);
		} catch (CompanyNotExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
