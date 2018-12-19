package exceptions;

public class CompanyExistsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CompanyExistsException() {
	}

	public CompanyExistsException(String message) {
		super(message);
	}

	public CompanyExistsException(Throwable cause) {
		super(cause);
	}

	public CompanyExistsException(String message, Throwable cause) {
		super(message, cause);
	}

	public CompanyExistsException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
