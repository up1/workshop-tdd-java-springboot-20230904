import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IdGeneratorServiceTest {

    @Test
    @DisplayName("ต้องการ generate id = START-5")
    public void case01() {
        // Arrange
        IdGeneratorService service = new IdGeneratorService();
        // Act
        String result = service.process();
        // Assert
        assertEquals("START-5", result);
    }

}