package memphis.mynders.javatutor.utils;

import memphis.mynders.javatutor.exceptions.BadEmployeeException;
import memphis.mynders.javatutor.model.Employee;
import memphis.mynders.javatutor.model.PhoneType;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class EmployeeUtils {
    private static final int SSN_LENGTH = 9;
    private static final int MIN_LENGTH = 2;

    //1. ssn rule -> length 9 and all should be digit
    //2. lastname rule -> at least two characters long
    //3. firstName rule -> starts with capital letter and should be at least two characters long
    //4. phonetype rule -> should not be null

    public static void assertValidEmployee(final Employee employee) {
        Map<String, String> fieldMesgPair = new HashMap<String,String>();

        if (!isValidSsn(employee.getSsn())) {
            fieldMesgPair.put("ssn:", "ssn lenght should be at least 9 and shuld be all numeric\n");
        }

        if (!isValidLastName(employee.getLastName())) {
            fieldMesgPair.put("lastName:", "last name should be at least 2 chars\n");
        }
        if (!isValidFirstName(employee.getFirstName())) {
            fieldMesgPair.put("firstName:", "first name should be at least 2 chars\n");
        }

        if (!isValidPhoneType(employee.getPhoneType())) {
            fieldMesgPair.put("phoneType:", "Phone Type should not be null\n");
        }

        if (!fieldMesgPair.isEmpty()) {
            String m = "";
            for (final String msg : fieldMesgPair.keySet()) {
                m += msg + " " + fieldMesgPair.get(msg);
            }
            throw new BadEmployeeException(m);
        }
    }

    public static boolean isValidSsn(final String ssn) {
        return isValidLength(ssn, SSN_LENGTH) && StringUtils.isNumeric(ssn);
    }

    public static boolean isValidLastName(final String lastName) {
        return isValidLength(lastName, MIN_LENGTH);
    }

    public static boolean isValidFirstName(final String firstName) {
        return isValidLength(firstName, MIN_LENGTH);
    }

    public static boolean isValidPhoneType(final PhoneType phoneType) {
        return phoneType != null;
    }

    /**
     * checks if string str is at least of length size long.
     * null and empty strings are always considered as invalid.
     *
     * @param str    is a string argument
     * @param length is integer length
     * @return true or false
     */
    public static boolean isValidLength(final String str, final int length) {
        if (length <= 0) {
            throw new RuntimeException("length cannot be less than zero");
        }
        return StringUtils.isNotEmpty(str) && str.length() >= length;
    }


}
