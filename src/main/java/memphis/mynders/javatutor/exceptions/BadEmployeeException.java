package memphis.mynders.javatutor.exceptions;

public class BadEmployeeException extends RuntimeException {
    public BadEmployeeException(final String mesg){
        super(mesg);
    }
}
