package baseball;

public class Ball {

    private final Integer number;

    public Ball(int number) {

        this.number = number;

    }

    public Ball(char ch) {
        this(Integer.parseInt(String.valueOf(ch)));
    }



}
