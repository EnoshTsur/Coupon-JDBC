package exceptions;

public class CompanyNotExistsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CompanyNotExistsException() {
	}

	public CompanyNotExistsException(String message) {
		super(message);
	}

	public CompanyNotExistsException(Throwable cause) {
		super(cause);
	}

	public CompanyNotExistsException(String message, Throwable cause) {
		super(message, cause);
	}

	public CompanyNotExistsException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
