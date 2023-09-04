import java.util.Random;

public class IdGeneratorService {

    // Method injection
    public String process(MyRandom r) {
        String id = "START-";
        int number = r.nextInt(10);
        return id + number;
    }

}

interface MyRandom {
    int nextInt(int bound);
}
