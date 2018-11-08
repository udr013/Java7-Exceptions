class CustomCheckedException extends Exception {

	public CustomCheckedException() {
	}

	public CustomCheckedException(String message) {
		super(message);
	}

	public CustomCheckedException(String message, Throwable cause) {
		super(message, cause);
	}

	public CustomCheckedException(Throwable cause) {
		super(cause);
	}

	public CustomCheckedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}

class CustomUnCheckedException extends RuntimeException {

	CustomUnCheckedException() {
		super();
	}

	public CustomUnCheckedException(String message) {
		super(message);
	}

	// etc
}

//though possible those shouldn't be thrown programmatically
class CustomError extends Error {

	CustomError() {
		super();
	}

	// etc
}
