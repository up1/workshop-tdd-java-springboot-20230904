import java.util.Random;

public class IdGeneratorService {

    public String process() {
        String id = "START-";
        int number = new Random().nextInt(10);
        return id + number;
    }

}
