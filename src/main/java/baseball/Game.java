package baseball;

public class Game {
    private int random_number;
    private int input_number;
    private int strike;
    private int ball;

    public Game() {


    }



    public void routine() {

    }

    private boolean isStrike(int where) {
        int digit = (int) Math.pow(10, where);
        int digit_under = (int) Math.pow(10, where - 1);

        int random_digit_number = (random_number % digit) / digit_under;
        int input_digit_number = (random_number % digit) / digit_under;
        if (random_digit_number == input_digit_number)
            return true;
        else
            return false;
    }
}

///245   200 % 1000 -> 200
