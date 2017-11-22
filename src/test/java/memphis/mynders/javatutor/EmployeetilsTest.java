package memphis.mynders.javatutor;

import memphis.mynders.javatutor.exceptions.BadEmployeeException;
import memphis.mynders.javatutor.model.PhoneType;
import memphis.mynders.javatutor.utils.EmployeeUtils;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EmployeetilsTest {

    @Test
    public void testValidStringLengthOfSizeTwo(){
        assertTrue(EmployeeUtils.isValidLength("ab",2));
    }

    @Test
    public void testValidStringLengthOfSizeThreeandLenghtTwo(){
        assertTrue(EmployeeUtils.isValidLength("abc",2));
    }

    @Test
    public void testInValidStringLengthOfSizeThreeandLenghtFour(){
        assertFalse(EmployeeUtils.isValidLength("abc",4));
    }

    @Test
    public void testInValidNullString(){
        assertFalse(EmployeeUtils.isValidLength(null,4));
    }

    @Test
    public void testInValidEmptyString(){
        assertFalse(EmployeeUtils.isValidLength("",4));
    }

    @Test(expected = RuntimeException.class)
    public void testZeroLengthParam(){
        EmployeeUtils.isValidLength("",0);
    }

    @Test(expected = RuntimeException.class)
    public void testNegativeLengthParam(){
        EmployeeUtils.isValidLength("",-1);
    }

    @Test
    public void testValidPhoneType(){
        EmployeeUtils.validatePhoneType(PhoneType.BUSINESS);
    }

    @Test(expected = BadEmployeeException.class)
    public void testInValidNullPhoneType(){
        EmployeeUtils.validatePhoneType(null);
    }


}
