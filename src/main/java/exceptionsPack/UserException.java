package exceptionsPack;

public class UserException extends Exception
{
    private String message;
    public UserException(String message)
    {
        super(message);
    }
}
