package webapp.exception;

public class JDOMRuntimeException extends RuntimeException {

	public JDOMRuntimeException() {
		super();
	}
	
	public JDOMRuntimeException(String message) {
		super(message);
	}
	
	public JDOMRuntimeException(String message,Throwable e) {
		super(message, e);
	}
	
}
