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

}