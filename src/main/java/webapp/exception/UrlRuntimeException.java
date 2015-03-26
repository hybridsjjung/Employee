package webapp.exception;

public class UrlRuntimeException extends RuntimeException {

	public UrlRuntimeException() {
		super();
	}
	
	public UrlRuntimeException(String message) {
		super(message);
	}
	
	public UrlRuntimeException(String message,Throwable e) {
		super(message, e);
	}
	
}
