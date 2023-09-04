public class MyProblem {

    private final String input;

    public MyProblem(String input) {
        this.input = input;
    }

    public int getStartNumber(){
        int result = Integer.parseInt(
                String.valueOf(input.charAt(1)));
        if(isStartWithInclude()) {
            return result;
        }
        return result + 1;
    }

    public boolean isStartWithInclude(){
        return this.input.startsWith("[");
    }

    public boolean isEndWithInclude() {
        return this.input.endsWith("]");
    }

    public int getEndNumber() {
        int result = Integer.parseInt(
                String.valueOf(input.charAt(3)));
        if(isEndWithInclude()) {
            return result;
        }
        return result - 1;
    }
}
