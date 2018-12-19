package DAO;

import java.util.List;

import entities.Company;
import entities.Coupon;
import exceptions.CompanyExistsException;
import exceptions.CompanyNotExistsException;

public interface CompanyDAO {

	void createCompany(Company company)throws CompanyExistsException;
	
	void updateCompany(String email, String password, long id)throws CompanyNotExistsException;
	
	void removeCompany(long id)throws CompanyNotExistsException;
	
	Company getCompany(long id)throws CompanyNotExistsException;
	
	List<Company> getAllCompanies();
	
	List<Coupon> getCompanyCoupons(long companyID)throws CompanyNotExistsException;
	
	boolean login(String name, String password);
}
