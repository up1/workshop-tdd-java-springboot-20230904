public class MyProblem {

    private final String input;

    public MyProblem(String input) {
        this.input = input;
    }

    public boolean isStartWithInclude(){
        return this.input.startsWith("[");
    }

}
