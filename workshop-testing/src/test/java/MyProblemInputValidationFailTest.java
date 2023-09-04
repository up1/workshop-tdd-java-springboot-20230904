import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyProblemInputValidationFailTest {

    @Test
    @DisplayName("input ไม่ถูกต้อง คือ 1,5] => throw InputInvalidException")
    public void case10() {
        // Arrange
        MyProblem myProblem = new MyProblem("1,5]");
        // Act
        try {
            myProblem.process();
            fail("InputInvalidException not found !!");
        } catch (InputInvalidException e) {
            assertEquals("Error case01", e.getMessage());
        }

    }

    @Test
    @DisplayName("Junit 5 => input ไม่ถูกต้อง คือ 1,5] => throw InputInvalidException")
    public void case11() {
        // Arrange
        MyProblem myProblem = new MyProblem("1,5]");
        // Act and Assert
        Exception e = assertThrows(InputInvalidException.class, myProblem::process);
        assertEquals("Error case01", e.getMessage());
    }

}