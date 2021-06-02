package alfa.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static alfa.util.Validation.*;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class ValidationTest {

    /*POSITIVE*/

    @Parameterized.Parameter
    public String valueS;

    @Parameterized.Parameter(1)
    public String valueI;

    @Parameterized.Parameter(2)
    public String valueD;

    @Parameterized.Parameter(3)
    public String valueNull;


    @Parameterized.Parameters
    public static Collection<Object[]> getData() {
        return Arrays.asList(new Object[][]{
                {"string", "123", "500.5", ""}
        });
    }
//    @Parameterized.Parameters
//    public static String[] gwtArrayString(){
//        return new String[]{"string", "123", "500.5", ""};
//    }


    @Test
    public void testValidationNameBook() {
        String validateNameBook = validateNameBook(valueS);

        assertEquals(valueS, validateNameBook);
        assertNotNull(validateNameBook);
    }

    @Test
    public void testValidateAuthorBook() {
        String validateAuthorBook = validateAuthorBook(valueS);

        assertEquals(valueS, validateAuthorBook);
        assertNotNull(validateAuthorBook);
    }

    @Test
    public void testValidatePublishBook() {
        String validatePublishBook = validatePublishBook(valueS);

        assertEquals(valueS, validatePublishBook);
        assertNotNull(validatePublishBook);
    }

    @Test
    public void testValidateYearBook() {
        Integer validateYearBook = validateYearBook(valueI);
        Integer parseInteger = Integer.parseInt(valueI);

        assertEquals(parseInteger, validateYearBook);
        assertNotNull(validateYearBook);
    }

    @Test
    public void testValidateCountPagesBook() {
        Integer validateCountBook = validateCountPagesBook(valueI);
        Integer parseInteger = Integer.parseInt(valueI);

        assertEquals(parseInteger, validateCountBook);
        assertNotNull(validateCountBook);
    }


    @Test
    public void testValidateCostPagesBook() {
        Double validateCostBook = validateCostBook(valueD);
        Double parseDouble = Double.parseDouble(valueD);

        assertEquals(parseDouble, validateCostBook);
        assertNotNull(validateCostBook);
    }

    /*NEGATIVE*/

    @Test
    public void testValidationExceptionNameBook() {
        boolean thrown = false;
        try {
            validateNameBook(valueNull);
        } catch (RuntimeException e) {
            thrown = true;
        }
        assertTrue(thrown);
    }

    @Test
    public void testValidateExceptionAuthorBook() {
        boolean thrown = false;
        try {
            validateAuthorBook(valueNull);
        } catch (RuntimeException e) {
            thrown = true;
        }
        assertTrue(thrown);
    }

    @Test
    public void testValidateExceptionPublishBook() {
        boolean thrown = false;
        try {
            validatePublishBook(valueNull);
        } catch (RuntimeException e) {
            thrown = true;
        }
        assertTrue(thrown);
    }

    @Test
    public void testValidateExceptionYearBook() {
        boolean thrown = false;
        try {
            validateYearBook(valueS);
        } catch (RuntimeException e) {
            thrown = true;
        }
        assertTrue(thrown);
    }

    @Test
    public void testValidateExceptionCountPagesBook() {
        boolean thrown = false;
        try {
            validateCountPagesBook(valueS);
        } catch (RuntimeException e) {
            thrown = true;
        }
        assertTrue(thrown);
    }

    @Test
    public void testValidateExceptionCostPagesBook() {
        boolean thrown = false;
        try {
            validateCostBook(valueS);
        } catch (RuntimeException e) {
            thrown = true;
        }
        assertTrue(thrown);
    }
}