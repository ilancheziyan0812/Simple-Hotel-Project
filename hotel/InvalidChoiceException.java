package hotel;

public class InvalidChoiceException extends RuntimeException {
	String message;
	
	InvalidChoiceException(String message)
	{
		this.message = message;
	}
	public String getMessage()
	{
		return message;
	}

}
