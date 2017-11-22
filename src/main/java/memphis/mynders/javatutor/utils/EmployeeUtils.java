package memphis.mynders.javatutor.utils;

import memphis.mynders.javatutor.exceptions.BadEmployeeException;
import memphis.mynders.javatutor.model.Employee;
import memphis.mynders.javatutor.model.PhoneType;
import org.apache.commons.lang3.StringUtils;

public class EmployeeUtils {
    private static final int SSN_LENGTH = 9;
    private static final int MIN_LENGTH = 2;

    //1. ssn rule -> length 9 and all should be digit
    //2. lastname rule -> at least two characters long
    //3. firstName rule -> starts with capital letter and should be at least two characters long
    //4. phonetype rule -> should not be null

    public static void assertValidEmployee(final Employee employee){
        validateSsn(employee.getSsn());
        validateLastName(employee.getLastName());
        validateFirstName(employee.getFirstName());
        validatePhoneType(employee.getPhoneType());
    }

    public static void validateSsn(final String ssn){
        if(isValidLength(ssn,SSN_LENGTH) || !StringUtils.isNumeric(ssn)){
            throw new BadEmployeeException("ssn lenght should be at least 9 and shuld be all numeric");
        }
    }

    public static void validateLastName(final String lastName){
        if(isValidLength(lastName,MIN_LENGTH)){
            throw new BadEmployeeException("last name should be at least 2 chars");
        }
    }

    public static void validateFirstName(final String firstName){
        if(isValidLength(firstName,MIN_LENGTH)){
            throw new BadEmployeeException("first name should be at least 2 chars");
        }
    }

    public static void validatePhoneType(final PhoneType phoneType){
        if(phoneType == null){
            throw new BadEmployeeException("Phone Type should not be null");
        }
    }

    /**
     * checks if string str is at least of length size long.
     * null and empty strings are always considered as invalid.
     *
     * @param str is a string argument
     * @param length is integer length
     * @return true or false
     */
    public static boolean isValidLength(final String str, final int length){
        if(length <= 0){
            throw new RuntimeException("length cannot be less than zero");
        }
        return StringUtils.isNotEmpty(str) && str.length() >= length;
    }


}
