package baseball;

public class RoutineForOneInput {
    private int random_number;
    private InputNumber input_number;
    private int strike = 0;
    private int ball = 0;

    public RoutineForOneInput(int random_number) {
        this.random_number = random_number;
        this.input_number = new InputNumber();
    }

    public boolean routine() {
        int none = 0;
        for (int i = 0; i < 3; i++) {
            if (isStrike(i + 1)) {
                strike++;
            } else if (isBall(i + 1)) {
                ball++;
            } else {
                none++;
            }
        }
        printResult(none);
        if (strike == 3 && ball == 0) {
            return true;
        } else {
            return false;
        }
    }

    private void printResult(int none) {
        if (none == 3) {
            System.out.println("낫싱");
        } else if (ball > 0 && strike <= 0) {
            System.out.println(ball + "볼");
        } else if (ball <= 0 && strike > 0) {
            System.out.println(strike + "스트라이크");
        } else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
    }

    private int findDigitNumber(int number, int where) {
        int digit = (int) Math.pow(10, where);
        int digit_under = (int) Math.pow(10, where - 1);

        int digit_number = (number % digit) / digit_under;

        return digit_number;
    }

    private boolean isStrike(int where) {
        int random_digit_number = findDigitNumber(random_number, where);
        int input_digit_number = findDigitNumber(input_number.getInputNumber(), where);
        if (random_digit_number == input_digit_number)
            return true;
        else
            return false;
    }

    private boolean isBall(int where) {
        for (int i = 0; i < 3; i++) {
            if (findDigitNumber(random_number, i + 1) == findDigitNumber(input_number.getInputNumber(), where))
                return true;
        }
        return false;
    }
}

