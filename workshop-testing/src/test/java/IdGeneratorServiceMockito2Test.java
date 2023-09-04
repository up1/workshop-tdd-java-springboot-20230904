import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class IdGeneratorServiceMockito2Test {

    @InjectMocks
    private IdGeneratorService service;

    @Mock
    private MyRandom random;

    @Test
    @DisplayName("ต้องการ generate id = START-5")
    public void case01() {
        // Arrange
        when(random.nextInt(10)).thenReturn(5);
        // Act
        String result = service.process(random);
        // Assert
        assertEquals("START-5", result);
    }

}