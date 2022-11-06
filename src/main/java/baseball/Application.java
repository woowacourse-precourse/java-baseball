package baseball;

import java.util.List;

public class Application {

    static GameController gameController = new GameController();
    static RandomNumber randomNumber = new RandomNumber();
    static NumBerVO numberVO = new NumBerVO();
    public static void main(String[] args) {



        ShowMessage.showGameStart(); // 게임 시작 메세지 출력
        List<Integer> randomNumberList = randomNumber.createRandomNumber(); // 난수 생성
        System.out.println("난수:" + randomNumberList + ":");
        numberVO.setRandomNumber(randomNumberList);

        keepGame();

    }

    public static int gameResult(){

        List<Integer> userNumberList = numberVO.getUserNumber();
        List<Integer> randomNumberList = numberVO.getRandomNumber();

        int ballCount = gameController.checkIntersection(userNumberList, randomNumberList);
        System.out.println("교집합:" + ballCount + ":");
        return gameController.checkNotMatch(userNumberList, randomNumberList, ballCount); // 결과 계산;
    }

    public static boolean gameCheck(){

        int gameFlag = gameResult();

        if(gameFlag == 0){
            System.out.println(gameFlag+"반복");
        } else if (gameFlag == 1) {
            System.out.println(gameFlag+"새로 시작");
        } else if (gameFlag == 2) {
            System.out.println(gameFlag+"종료");
        }

        return false;
    }

    public static void keepGame(){
        ShowMessage.showInputNumber(); // 숫자 입력 메세지 출력
        List<Integer> userNumberList = gameController.inputUserNumber(); // 사용자 입력
        System.out.println("입력값:" + userNumberList + ":");
        numberVO.setUserNumber(userNumberList);
        gameCheck(); // 게임 결과 체크
    }
}
