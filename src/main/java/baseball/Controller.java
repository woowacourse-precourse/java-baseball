package baseball;

import net.bytebuddy.matcher.StringMatcher;

public class Controller {
    private Model computer;
    private Model user;

    public Controller(Model computer, Model user) {
        this.computer = computer;
        this.user = user;
    }

    public void setNumber(Model model, String number) {
        model.setNumber(number);
    }

    public String getNumber(Model model) {
        return model.getNumber();
    }

    public String[] splitNumber(String number) {
        String[] numbers = number.split("");
        return numbers;
    }

    public int[] compareNumber(String computerNumber, String userNumber) {
        int ball = 0;
        int strike = 0;
        String[] numbers = splitNumber(userNumber);

        for (int i = 0; i < computerNumber.length(); i++) {
            if (computerNumber.indexOf(numbers[i]) == i) {
                strike++;
            } else if (computerNumber.contains(numbers[i])) {
                ball++;
            }
        }
        return new int[]{ball,strike};
    }
}
