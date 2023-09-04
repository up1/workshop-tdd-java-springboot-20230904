import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(MockitoExtension.class)
class IdGeneratorServiceMockitoTest {

    @Mock
    private MyRandom random;

    @Test
    @DisplayName("ต้องการ generate id = START-5")
    public void case01() {
        // Arrange
        // Stub
        IdGeneratorService service = new IdGeneratorService();
        // Act
        String result = service.process(random);
        // Assert
        assertEquals("START-5", result);
    }

}