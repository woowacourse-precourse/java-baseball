package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class InGame {
    private final BaseballUtil baseballUtil;
    private final int answer;

    public InGame() {
        this.baseballUtil = new BaseballUtil();
        this.answer = this.createRandomInt();
    }

    public InGame(BaseballUtil baseballUtil) {
        this.baseballUtil = baseballUtil;
        this.answer = this.createRandomInt();
    }

    public InGame(BaseballUtil baseballUtil, int number) {
        this.baseballUtil = baseballUtil;
        this.answer = number;
    }

    public boolean playGame() {
        List<Integer> compare_result;
        do {
            this.announceUserToInputNumber();
            compare_result = this.compareUserInput(this.getUserInput());
            this.announceInputResult(compare_result.get(0), compare_result.get(1));
        }
        while(compare_result.get(1) != 3);

        return true;
    }

    private int createRandomInt() {
        int random_int = 0;

        List<Integer> random_pick = Randoms.pickUniqueNumbersInRange(0, 9, 3);

        for(int i = 0; i < 3; i++) {
            random_int *= 10;
            random_int += random_pick.get(i);
        }

        return random_int;
    }

    private void announceUserToInputNumber() {
        this.baseballUtil.printLine("숫자를 입력해주세요 : ");
    }

    private void announceInputResult(int ball, int strike) {
        if (ball == 0 && strike == 0) {
            this.baseballUtil.printlnLine("낫싱");
        }
        else {
            String announce = "";
            if (ball > 0) {
                announce += Integer.toString(ball) + "볼 ";
            }
            if (strike > 0) {
                announce += Integer.toString(strike) + "스트라이크 ";
            }
            this.baseballUtil.printlnLine(announce);
        }
    }

    private int getUserInput() {
        return this.userInputValidation(this.baseballUtil.readLineInt());
    }

    private int userInputValidation(int user_input) {
        if (
                // length
                !(10 <= user_input && user_input <= 999) ||
                        // unique
                        !this.isUniqueInt(user_input)
        ){
            throw new IllegalArgumentException();
        }

        return user_input;
    }

    private boolean isUniqueInt(int input) {
        int hundred = input / 100;
        int tens = input % 100 / 10;
        int ones = input % 10;
        if (
                (hundred == tens) ||
                        (tens == ones) ||
                        (hundred == ones)
        ) {
            return false;
        }
        return true;
    }

    private List<Integer> compareUserInput(int input) {
        String input_string = this.intToString(input);
        String answer_string = this.intToString(this.answer);
        int ball = 0;
        int strike = 0;

        for (int i = 0; i < 9; i++) {
            int j = i / 3;
            if((answer_string.charAt(j) == input_string.charAt(i % 3)) &&
                    ((int)(i % 3) == j)
            ){
                strike += 1;
            }
            if((answer_string.charAt(j) == input_string.charAt(i % 3)) &&
                    ((int)(i % 3) != j)
            ){
                ball += 1;
            }
        }

        List<Integer> return_list = new ArrayList<>();
        return_list.add(ball);
        return_list.add(strike);

        return return_list;
    }

    private String intToString(int input) {
        String convert = Integer.toString(input);
        if (input < 100) {
            convert = "0" + convert;
        }

        return convert;
    }
}
