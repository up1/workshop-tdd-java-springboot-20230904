import java.util.Random;

public class IdGeneratorService {

    // Method injection
    public String process(Random r) {
        String id = "START-";
        int number = r.nextInt(10);
        return id + number;
    }

}
