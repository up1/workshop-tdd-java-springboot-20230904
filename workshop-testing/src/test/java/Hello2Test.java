import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Hello2Test {

    @Test
    @DisplayName("input ชื่อ somkiat จะต้องแสดงค่า Hello, somkiat")
    public void case01() {
        // Arrange
        Hello hello = new Hello();
        // Act
        String actualResult = hello.sayHi("somkiat");
        // Assert
        assertEquals("Hello, somkiat", actualResult);
    }

}