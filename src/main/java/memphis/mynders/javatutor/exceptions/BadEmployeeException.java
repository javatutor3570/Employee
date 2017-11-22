package memphis.mynders.javatutor.exceptions;

import java.util.Map;

public class BadEmployeeException extends RuntimeException {
    public BadEmployeeException(final String mesg){
        super(mesg);
    }
}
