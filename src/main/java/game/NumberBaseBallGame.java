package game;

import camp.nextstep.edu.missionutils.Randoms;
import validator.Validator;
import view.Input;
import view.Output;

import java.util.ArrayList;
import java.util.List;

public class NumberBaseBallGame {

    public static void run() {
        while (true) {
            try {
                playNumberBaseballGame();
                String input = Input.scanStartOrEndNumber();
                Validator.checkStartOrEndInput(input);
            } catch (IllegalArgumentException e) {
                Output.printErrorMessage(e);
                break;
            }
        }
    }

    private static void playNumberBaseballGame() throws IllegalArgumentException {
        Output.printStartGuideMessage();
        List<Integer> answerNumber = getAnswerNumber();
        while (true) {
            List<Integer> inputNumber = getInputNumber();
        }
    }

    private static List<Integer> getInputNumber() throws IllegalArgumentException {
        List<Integer> inputList = new ArrayList<>();
        String number = Input.scanInputNumber();
        Validator.checkInputNumber(number);
        for (int i=0; i<number.length(); i++) {
            inputList.add(number.charAt(i) - '0');
        }
        return inputList;
    }

    private static List<Integer> getAnswerNumber() {
        List<Integer> answerList = new ArrayList<>();
        while (answerList.size() <= 3) {
            int number = Randoms.pickNumberInRange(1, 9);
            if (!answerList.contains(number)) {
                answerList.add(number);
            }
        }
        return answerList;
    }
}
