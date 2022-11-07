package baseball;

import java.util.List;
import java.util.stream.Collectors;

public class GameController {

    InputController inputController = new InputController();
    RandomNumber randomNumber = new RandomNumber();
    ShowMessage showMessage = new ShowMessage();
    ExceptionController exceptionController = new ExceptionController();

    List<Integer> userNumberList;
    List<Integer> randomNumberList;
    int gameFlagNumber = 0;


    public void newGame() {

        boolean gameFlag = true;
        gameFlagNumber = 0;
        while (gameFlag) {
            randomNumberList = randomNumber.gameRandomNumber(); // 난수 생성
            gameFlagNumber = keepGame();
            if (gameFlagNumber == 2) {
                gameFlag = false;
            }
        }
    }

    public List<Integer> inputConvertToList(String userNumber) {
        ShowMessage.showInputNumber();
        userNumber = inputController.getInput(); // 입력받기
        exceptionController.inputNumberException(userNumber);
        userNumberList = inputController.userNumberConvertToList(userNumber);
        return userNumberList;
    }

    public int keepGame() {

        boolean gameFlag = true;
        String userNumber = "";
        gameFlagNumber = 0;

        while (gameFlag) {
            userNumberList = inputConvertToList(userNumber);
            gameFlagNumber = gameResult(); // 게임 결과 체크
            if (gameFlagNumber == 1 || gameFlagNumber == 2) {
                return gameFlagNumber;
            }
        }
        return gameFlagNumber;
    }

    public int gameResult() {
        int ballCount = checkIntersection();
        return checkNotMatch(ballCount); // 결과 계산;
    }

    // userNumberList와 randomNumberList의 교집합 검사
    public int checkIntersection() {
        return randomNumberList.stream().filter(userNumberList::contains).collect(Collectors.toList()).size();
    }

    public int checkNotMatch(int ballCount) {

        if (ballCount == 0) {
            ShowMessage.showNotMatchWord(); // 낫싱
            return 0;
        } else {
            return calculateGameCount(ballCount);
        }
    }

    public int calculateGameCount(int ballCount) {


        int answerCount = showMessage.getAnswerCount();
        int strikeCount = 0;

        for (int i = 0; i < answerCount; i++) {
            if (userNumberList.get(i) == randomNumberList.get(i)) {
                strikeCount++;
            }
        }
        ballCount -= strikeCount;

        showMessage.showGameScore(ballCount, strikeCount);

        return checkNewGame(strikeCount, answerCount);
    }

    public int checkNewGame(int strikeCount, int answerCount) {

        String userNumber = "";
        int number = 0;

        if (strikeCount == answerCount) {
            ShowMessage.showEndGameNewGameCheck();
            userNumber = inputController.getInput();
            exceptionController.checkNewGameException(userNumber);
            number = Integer.parseInt(userNumber);
            return number;
        }
        return 0;
    }

}
