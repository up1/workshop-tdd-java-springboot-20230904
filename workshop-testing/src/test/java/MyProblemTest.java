import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyProblemTest {

    @Test
    @DisplayName("เริ่มด้วย [")
    public void case01() {
        // Arrange
        MyProblem myProblem = new MyProblem("[1,5]");
        // Act
        boolean result = myProblem.isStartWithInclude();
        // Assert
        assertTrue(result);
    }

    @Test
    @DisplayName("เริ่มด้วย (")
    public void case02() {
        // Arrange
        MyProblem myProblem = new MyProblem("(1,5]");
        // Act
        boolean result = myProblem.isStartWithInclude();
        // Assert
        assertFalse(result);
    }

    @Test
    @DisplayName("ปิดด้วย ] ?")
    public void case03() {
        // Arrange
        MyProblem myProblem = new MyProblem("[1,5]");
        // Act
        boolean result = myProblem.isEndWithInclude();
        // Assert
        assertTrue(result);
    }

    @Test
    @DisplayName("ปิดด้วย ) ?")
    public void case04() {
        // Arrange
        MyProblem myProblem = new MyProblem("[1,5)");
        // Act
        boolean result = myProblem.isEndWithInclude();
        // Assert
        assertFalse(result);
    }

    @Test
    @DisplayName("เริ่มด้วย [1,5] => 1")
    public void case05() {
        // Arrange
        MyProblem myProblem = new MyProblem("[1,5)");
        // Act
        int result = myProblem.getStartNumber();
        // Assert
        assertEquals(1, result);
    }

    @Test
    @DisplayName("เริ่มด้วย (1,5] => 2")
    public void case06() {
        // Arrange
        MyProblem myProblem = new MyProblem("(1,5)");
        // Act
        int result = myProblem.getStartNumber();
        // Assert
        assertEquals(2, result);
    }

}