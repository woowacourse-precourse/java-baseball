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
}