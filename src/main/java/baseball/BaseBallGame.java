package baseball;

import java.util.List;
import java.util.Objects;

public class BaseBallGame {

    Computer computer = new Computer();
    User user = new User();

    public void printStartGameMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printUserInputMessage() {
        System.out.print("숫자를 입력해주세요  :  ");
    }

    public void printUserWinMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void printRestartOrStopMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public void playGame() {
        // 컴퓨터 랜덤 넘버
        List<Integer> computerNumbers = computer.makeComputerNumbers();

        while (true) {

            String userInputNumber = user.userInput();
            List<Integer> userInputToList = user.userInputToList(userInputNumber);

            int countBall = countBall(userInputToList, computerNumbers);
            int countStrike = countStrike(userInputToList, computerNumbers);

            makeHintAndPrint(countBall, countStrike);

            if (countStrike == 3) {
                printUserWinMessage();
                break;
            }
        }
    }


    public int restartOrStop(String userInput) {

        int validRestartOrEndInput = user.validRestartOrEndInput(userInput);

        if (validRestartOrEndInput == 1) {
            System.out.println("새로운 게임을 시작합니다.");
            return 1;
        }

        if (validRestartOrEndInput == 2) {
            System.out.println("게임이 종료 되었습니다.");
            return 2;
        }

        return 2;
    }


    public int countBall(List<Integer> userInputArr, List<Integer> computerNumbers) {

        int ball = 0;

        for (int i = 0; i < computerNumbers.size(); i++) {
            if (!userInputArr.get(i).equals(computerNumbers.get(i)) && computerNumbers.contains(userInputArr.get(i))) {
                ball++;
            }
        }

        return ball;
    }

    public int countStrike(List<Integer> userInputArr, List<Integer> computerNumbers) {
        int strike = 0;

        for (int i = 0; i < computerNumbers.size(); i++) {
            if (Objects.equals(userInputArr.get(i), computerNumbers.get(i))) {
                strike++;
            }
        }

        return strike;
    }

    public void makeHintAndPrint(int ballCount, int strikeCount) {

        if (ballCount > 0 && strikeCount > 0) {
            System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
        }
        if (ballCount > 0 && strikeCount == 0) {
            System.out.println(ballCount + "볼");
        }
        if (strikeCount > 0 && ballCount == 0) {
            System.out.println(strikeCount + "스트라이크");
        }
        if (strikeCount == 0 && ballCount == 0) {
            System.out.println("낫싱");
        }
    }

}
