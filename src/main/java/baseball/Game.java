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

    private int findDigitNumber(int number, int where) {
        int digit = (int) Math.pow(10, where);
        int digit_under = (int) Math.pow(10, where - 1);

        int digit_number = (number % digit) / digit_under;

        return digit_number;
    }

    private boolean isStrike(int where) {
        int random_digit_number = findDigitNumber(random_number, where);
        int input_digit_number = findDigitNumber(input_number, where);
        if (random_digit_number == input_digit_number)
            return true;
        else
            return false;
    }

    private boolean isBall(int where) {
        for (int i = 0; i < 3; i++) {
            if (findDigitNumber(random_number, i) == findDigitNumber(input_number, where))
                return true;
        }
        return false;
    }
}

///245   200 % 1000 -> 200
