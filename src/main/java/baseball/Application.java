package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        printStartMessage();
        boolean gameFlag = true;
        while (gameFlag) {
            List<Integer> randomNumber = getRandomNumber();

            printEndMessage();
        }


    }

    public static List<Integer> getRandomNumber() {
        List<Integer> baseballNumber = new ArrayList<>();
        while (baseballNumber.size() <= 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!baseballNumber.contains(randomNumber)) {
                baseballNumber.add(randomNumber);
            }
        }
        return baseballNumber;
    }

    public static void printStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printEndMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public static void printGameResult(int ballCount, int strikeCount) {
        StringBuilder resultMessage = new StringBuilder();
        if (ballCount != 0) {
            resultMessage.append(ballCount + "볼");
        }

        if (strikeCount != 0) {
            if (resultMessage.length() != 0) {
                resultMessage.append(" ");
            }
            resultMessage.append(strikeCount + "스트라이크");
        }

        if (resultMessage.length() == 0) {
            resultMessage.append("낫싱");
        }
    }

    
}
