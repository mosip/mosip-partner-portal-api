package io.mosip.pmp.partner.exception;

/**
 * {@link Exception} to be thrown when a class name is not found
 * @author sanjeev.shrivastava
 *
 */
public class ClassNameNotFoundException extends BaseUncheckedException {

	/**
	 * Unique id for serialization
	 */
	private static final long serialVersionUID = 105555532L;

	/**
	 * @param errorCode    unique exception code
	 * @param errorMessage exception message
	 */
	public ClassNameNotFoundException(String errorCode, String errorMessage) {
		super(errorCode, errorMessage);
	}

}
