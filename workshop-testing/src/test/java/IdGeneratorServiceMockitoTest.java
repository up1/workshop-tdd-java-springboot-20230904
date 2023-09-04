import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class IdGeneratorServiceMockitoTest {

    @Test
    @DisplayName("ต้องการ generate id = START-5")
    public void case01() {
        // Arrange
        // Stub
        MyRandom random = null;
        IdGeneratorService service = new IdGeneratorService();
        // Act
        String result = service.process(random);
        // Assert
        assertEquals("START-5", result);
    }

}