package entities;

import java.sql.Date;

import enums.CouponType;

public class Coupon {

	private long id;
	private String title;
	private Date startDate;
	private Date endDate;
	private CouponType type;
	private int amount;
	private String message;
	private double price;
	private String image;
	

	public Coupon(String title, Date startDate, Date endDate, int amount,CouponType type, String message, double price,
			String image) {
		this.title = title;
		this.startDate = startDate;
		this.endDate = endDate;
		this.type = type;
		this.amount = amount;
		this.message = message;
		this.price = price;
		this.image = image;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public CouponType getType() {
		return type;
	}

	public void setType(CouponType type) {
		this.type = type;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Coupon [id=" + id + ", title=" + title + ", startDate=" + startDate + ", endDate=" + endDate + ", type="
				+ type + ", message=" + message + ", price=" + price + ", image=" + image + "]";
	}

}
