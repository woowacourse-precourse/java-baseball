package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        GameController gameController = new GameController();
        RandomNumber randomNumber = new RandomNumber();
        NumberVO numberVO = new NumberVO();

        ShowMessage.showGameStart(); // 게임 시작 메세지 출력
        List<Integer> randomNumberList = randomNumber.createRandomNumber(); // 난수 생성
        System.out.println("난수:" + randomNumberList + ":");
        ShowMessage.showInputNumber(); // 숫자 입력 메세지 출력
        List<Integer> userNumberList = gameController.inputUserNumber(); // 사용자 입력
        System.out.println("입력값:" + userNumberList + ":");
        // 교집합
        int ballCount = gameController.checkIntersection(userNumberList, randomNumberList);
        System.out.println("교집합:" + ballCount + ":");
        gameController.checkGameResult(userNumberList, randomNumberList, ballCount); // 결과 계산


    }

}
