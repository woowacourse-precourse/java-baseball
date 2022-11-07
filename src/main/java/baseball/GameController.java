package baseball;

import java.util.List;
import java.util.stream.Collectors;

public class GameController {

    static InputController inputController = new InputController();
    static RandomNumber randomNumber = new RandomNumber();
    static ShowMessage showMessage = new ShowMessage();

    static List<Integer> userNumberList;
    static List<Integer> randomNumberList;
    int gameFlagNumber = 0;


    public void newGame() {

        boolean gameFlag = true;
        gameFlagNumber = 0;
        while (gameFlag) {
            randomNumberList = randomNumber.gameRandomNumber(); // 난수 생성
            gameFlagNumber = keepGame();
            if(gameFlagNumber == 2){
                gameFlag = false;
            }
        }
    }

    public int keepGame() {

        boolean gameFlag = true;
        gameFlagNumber = 0;

        while (gameFlag) {
            userNumberList = inputController.gameUserInput(); // 입력받기
            gameFlagNumber = gameResult(); // 게임 결과 체크

            if (gameFlagNumber == 1 || gameFlagNumber == 2) {
                System.out.println("종료:" + gameFlagNumber + ":");
                return gameFlagNumber;
            }
        }
        return gameFlagNumber;
    }

    public int gameResult() {
        int ballCount = checkIntersection(userNumberList, randomNumberList);
        System.out.println("교집합:" + ballCount + ":");
        return checkNotMatch(ballCount); // 결과 계산;
    }

    // userNumberList와 randomNumberList의 교집합 검사
    public int checkIntersection(List<Integer> userNumberList, List<Integer> randomNumberList) {
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

        return checkGame(strikeCount, answerCount);
    }

    public int checkGame(int strikeCount, int answerCount){

        String userNumber = "";
        int number = 0;

        if(strikeCount == answerCount){
            ShowMessage.showNewGameCheck();
//            userNumber = inputException(userNumber);
            number = Integer.parseInt(userNumber);
            return number;
        }
        return 0;
    }

}
