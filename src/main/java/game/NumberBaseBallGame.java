package game;

import camp.nextstep.edu.missionutils.Randoms;
import constant.GuideMessage;
import validator.Validator;
import view.Input;
import view.Output;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class NumberBaseBallGame {

    public static void run() {
        while (true) {
            String input = "";
            try {
                playNumberBaseballGame();
                input = Input.scanStartOrEndNumber();
                Validator.checkStartOrEndInput(input);
            } catch (IllegalArgumentException e) {
                Output.printErrorMessage(e);
                break;
            }
            if (input.equals(GuideMessage.TWO)) {
                Output.printExitProgramMessage();
                break;
            }
        }
    }

    private static void playNumberBaseballGame() throws IllegalArgumentException {
        Output.printStartGuideMessage();
        List<Integer> answerNumber = getAnswerNumber();

        // todo 지우기 정답 확인 테스트
        System.out.println(answerNumber);

        while (true) {
            int[] strikeAndBallCount = new int[2]; // strike와 ball 갯수를 파악할 수 있는 공간이 2인 배열 생성
            List<Integer> inputNumber = getInputNumber();
            countStrikeAndBall(strikeAndBallCount, answerNumber, inputNumber);
            int strikeCount = strikeAndBallCount[0];
            int ballCount = strikeAndBallCount[1];
            Output.printStrikeAndBallCount(ballCount, strikeCount);
            if (strikeCount == 3) {
                Output.printThreeStrike();
                break;
            }
        }
    }

    private static void countStrikeAndBall(int[] strikeAndBallCount, List<Integer> answerNumber, List<Integer> inputNumber) {
        int strikeCount = 0;
        int ballCount = 0;
        HashSet<Integer> leftNumSet = new HashSet<>(answerNumber);
        for (int i=0; i<3 ; i++) {
            int answerDigit = answerNumber.get(i);
            int inputDigit = inputNumber.get(i);
            if (answerDigit == inputDigit) {
                strikeCount++;
                leftNumSet.remove(answerDigit);
                continue;
            }
            if (leftNumSet.contains(inputNumber.get(i))) {
                ballCount++;
            }
        }
        strikeAndBallCount[0] = strikeCount;
        strikeAndBallCount[1] = ballCount;
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
        while (answerList.size() < 3) {
            int number = Randoms.pickNumberInRange(1, 9);
            if (!answerList.contains(number)) {
                answerList.add(number);
            }
        }
        return answerList;
    }
}
