package DAO;

import java.util.Date;
import java.util.List;

import entities.Coupon;
import enums.CouponType;
import exceptions.CompanyNotExistsException;
import exceptions.CouponExistsException;
import exceptions.CouponNotExistsException;

public interface CouponDAO{
	
	void createCoupon(Coupon coupon)throws CouponExistsException;
	
	void updateCoupon(Date endDate, double price, long coupId, long compId)throws CouponNotExistsException;

	void removeCoupon(long coupId, long compId)throws CouponNotExistsException, CompanyNotExistsException;
	
	List<Coupon> getAllCoupons();
	
	List<Coupon> getCouponsByType(CouponType type);
	
	
	
}
