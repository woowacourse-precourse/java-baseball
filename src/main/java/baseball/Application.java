package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;

public class Application {
    public static void main(String[] args) {
        play();
    }

    private static void play() throws IllegalArgumentException{
        String continueFlag = "1";

        do {
            if (continueFlag.equals("2")) {
                break;
            } else if (!continueFlag.equals("1")) {
                throw new IllegalArgumentException();
            }

            System.out.println("숫자 야구 게임을 시작합니다.");
            String answer = randomNum();
            guess(answer);
            continueFlag = replay();
        } while (true);
    }

    static String randomNum() {
        String randomNumber = "";

        while (randomNumber.length() < 3) {
            int randomNumberOneDigit = Randoms.pickNumberInRange(1, 9);

            if (!randomNumber.contains(randomNumberOneDigit + "")) {
                randomNumber = randomNumber.concat(randomNumberOneDigit + "");
            }
        }
        return randomNumber;
    }

    private static void guess(String answer) throws IllegalArgumentException {
        Boolean correct;

        do {
            System.out.print("숫자를 입력해주세요 : ");
            String playerGuess = Console.readLine();
            if(playerGuess.length() != 3 || !isNum(playerGuess)) {
                throw new IllegalArgumentException();
            }
            correct = correctOrHint(playerGuess, answer);

            if (correct) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        } while (true);
    }

    static Boolean isNum(String playerGuess) {
        Boolean numericOrNot = true;

        for (int letterIdx = 0; letterIdx < playerGuess.length(); letterIdx++) {
            if (!Character.isDigit(playerGuess.charAt(letterIdx))) {
                numericOrNot = false;
            }
        }
        return numericOrNot;
    }

    static Boolean correctOrHint(String playerGuess, String answer) {
        boolean correct = false;
        List<Integer> strikeBallCnt = cntStrikeBall(playerGuess, answer);
        int strike = strikeBallCnt.get(0);
        int ball = strikeBallCnt.get(1);

        if (strike == 3) {
            System.out.println(strike + "스트라이크");
            correct = true;
        } else if (ball + strike == 0) {
            System.out.println("낫싱");
        } else if (ball == 0 && strike > 0) {
            System.out.println(strike + "스트라이크");
        } else if (strike == 0 && ball > 0) {
            System.out.println(ball + "볼");
        } else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
        return correct;
    }

    static List<Integer> cntStrikeBall(String playerGuess, String answer) {
        List<Integer> strikeBallCnt = new ArrayList<>(Collections.nCopies(2, 0));

        for (int answerIdx = 0; answerIdx < answer.length(); answerIdx++) {
            if (answer.charAt(answerIdx) == playerGuess.charAt(answerIdx)) {
                strikeBallCnt.set(0, strikeBallCnt.get(0) + 1);
            } else if (answer.contains(playerGuess.charAt(answerIdx) + "")) {
                strikeBallCnt.set(1, strikeBallCnt.get(1) + 1);
            }
        }
        return strikeBallCnt;
    }
}