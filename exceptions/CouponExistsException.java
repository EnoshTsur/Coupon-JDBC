package exceptions;

public class CouponExistsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CouponExistsException() {
	}

	public CouponExistsException(String message) {
		super(message);
	}

	public CouponExistsException(Throwable cause) {
		super(cause);
	}

	public CouponExistsException(String message, Throwable cause) {
		super(message, cause);
	}

	public CouponExistsException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
