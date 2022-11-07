package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private final GamePlayer gamePlayer;
    private List<Integer> threeNumberByComputer;
    boolean rightAnswer;

    public Computer() {
        this.gamePlayer = new GamePlayer();
        this.rightAnswer = false;
    }

    public void gameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        do {
            threeNumberByComputer = getThreeRandomNumbers();
            playGame();
        } while (!finishTheGame());
    }

    private List<Integer> getThreeRandomNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();

        while (randomNumbers.size() < 3) {
            int number = Randoms.pickNumberInRange(1, 9);
            if (!randomNumbers.contains(number)) {
                randomNumbers.add(number);
            }
        }

        return randomNumbers;
    }

    private void playGame() {
        do {
            List<Integer> threeNumbers = askForThreeNumbers();
            rightAnswer = isRightAnswer(threeNumbers);
        } while (!rightAnswer);
    }

    private List<Integer> askForThreeNumbers() {
        System.out.print("숫자를 입력해 주세요 : ");
        return gamePlayer.getThreeNumber();
    }

    private boolean isRightAnswer(List<Integer> threeNumbers) {
        List<Integer> strikeAndBall = countTheNumberOfStrikeAndBall(threeNumbers);
        int strikeCount = strikeAndBall.get(0);
        int ballCount = strikeAndBall.get(1);

        if (strikeCount == 3) {
            System.out.println(strikeCount + "스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }

        if ((strikeCount == 0) && (ballCount == 0)) {
            System.out.println("낫싱");
        } else if(strikeCount == 0) {
            System.out.println(ballCount + "볼");
        } else if(ballCount == 0) {
            System.out.println(strikeCount + "스트라이크");
        } else {
            System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
        }
        return false;
    }

    private List<Integer> countTheNumberOfStrikeAndBall(List<Integer> threeNumbers) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            int currentPlayerNumber = threeNumbers.get(i);
            int currentComputerNumber = threeNumberByComputer.get(i);

            int resultCode = isStrkieOrBall(currentPlayerNumber, currentComputerNumber);
            if (resultCode == 1) {
                strike += 1;
            } else if (resultCode == 2) {
                ball += 1;
            }
        }

        return List.of(strike, ball);
    }

    private int isStrkieOrBall(int playerNumber, int computerNumber) {
        if (playerNumber == computerNumber) {
            return 1;
        } else if (threeNumberByComputer.contains(playerNumber)) {
            return 2;
        }
        return -1;
    }

    private boolean finishTheGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int responseNumber = gamePlayer.respondToFinishRequest();
        if (responseNumber == 1) {
            rightAnswer = false;
            return false;
        } else {
            return true;
        }
    }
}
