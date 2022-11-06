package baseball;

import java.util.List;

public class Application {

    static GameController gameController = new GameController();
    static RandomNumber randomNumber = new RandomNumber();
    static NumBerVO numberVO = new NumBerVO();

    public static void main(String[] args) {
        ShowMessage.showGameStart(); // 게임 시작 메세지 출력
        newGame();
    }

    public static int gameResult() {

        List<Integer> userNumberList = numberVO.getUserNumber();
        List<Integer> randomNumberList = numberVO.getRandomNumber();

        int ballCount = gameController.checkIntersection(userNumberList, randomNumberList);
        System.out.println("교집합:" + ballCount + ":");
        return gameController.checkNotMatch(userNumberList, randomNumberList, ballCount); // 결과 계산;
    }

    public static int keepGame() {

        boolean gameFlag = true;
        int gameFlagNubmer = 0;

        while (gameFlag) {
            gameUserInput();
            gameFlagNubmer = gameResult(); // 게임 결과 체크

            if (gameFlagNubmer == 1 || gameFlagNubmer == 2) {
                System.out.println("종료:" + gameFlagNubmer + ":");
                return gameFlagNubmer;
            }
        }
        return gameFlagNubmer;
    }

    public static void gameUserInput(){
        ShowMessage.showInputNumber(); // 숫자 입력 메세지 출력
        List<Integer> userNumberList = gameController.inputUserNumber(); // 사용자 입력
        System.out.println("입력값:" + userNumberList + ":");
        numberVO.setUserNumber(userNumberList);
    }


    public static void newGame() {

        boolean gameFlag = true;
        int gameFlagNumber = 0;

        while (gameFlag) {
            gameRandomNumber();
            gameFlagNumber = keepGame();
            if(gameFlagNumber == 2){
                break;
            }
        }
    }

    public static void gameRandomNumber(){
        List<Integer> randomNumberList = randomNumber.createRandomNumber(); // 난수 생성
        System.out.println("난수:" + randomNumberList + ":");
        numberVO.setRandomNumber(randomNumberList);
    }

}
