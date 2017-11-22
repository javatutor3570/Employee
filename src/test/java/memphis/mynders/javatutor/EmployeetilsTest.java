package memphis.mynders.javatutor;

import memphis.mynders.javatutor.exceptions.BadEmployeeException;
import memphis.mynders.javatutor.model.Employee;
import memphis.mynders.javatutor.model.PhoneType;
import memphis.mynders.javatutor.utils.EmployeeUtils;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EmployeetilsTest {

    @Test
    public void testValidStringLengthOfSizeTwo() {
        assertTrue(EmployeeUtils.isValidLength("ab", 2));
    }

    @Test
    public void testValidStringLengthOfSizeThreeandLenghtTwo() {
        assertTrue(EmployeeUtils.isValidLength("abc", 2));
    }

    @Test
    public void testInValidStringLengthOfSizeThreeandLenghtFour() {
        assertFalse(EmployeeUtils.isValidLength("abc", 4));
    }

    @Test
    public void testInValidNullString() {
        assertFalse(EmployeeUtils.isValidLength(null, 4));
    }

    @Test
    public void testInValidEmptyString() {
        assertFalse(EmployeeUtils.isValidLength("", 4));
    }

    @Test(expected = RuntimeException.class)
    public void testZeroLengthParam() {
        EmployeeUtils.isValidLength("", 0);
    }

    @Test(expected = RuntimeException.class)
    public void testNegativeLengthParam() {
        EmployeeUtils.isValidLength("", -1);
    }

    @Test()
    public void testValidEmployee() {
        final Employee e = new Employee("Muku", "Aryal", PhoneType.BUSINESS, "123457890", 2000.0);
        EmployeeUtils.assertValidEmployee(e);
    }

    @Test(expected = BadEmployeeException.class)
    public void testInValidEmployee() {
        final Employee e = new Employee();
        EmployeeUtils.assertValidEmployee(e);
    }


}
