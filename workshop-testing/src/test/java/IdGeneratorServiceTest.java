import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class MockRandomWith5 extends Random {
    @Override
    public int nextInt(int bound) {
        return 5;
    }
}

class IdGeneratorServiceTest {

    @Test
    @DisplayName("ต้องการ generate id = START-5")
    public void case01() {
        // Arrange
        Random random = new Random(){
            @Override
            public int nextInt(int bound) {
                return 5;
            }
        };

        random = new MockRandomWith5();
        IdGeneratorService service = new IdGeneratorService();
        // Act
        String result = service.process(random);
        // Assert
        assertEquals("START-5", result);
    }

}