package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        GenerateRandNumber generateNumber = new GenerateRandNumber();
        List<Integer> correctRandNumber = generateNumber.arrayNum();

        boolean gameStatus = true;
        while (gameStatus) {

            GetUserNumber userInput = new GetUserNumber();
            String userRandNumber = userInput.inputUserNumber();

            CalcCount countResult = new CalcCount();
            List<Integer> countStrBallList= countResult.CountStrike(userRandNumber, correctRandNumber);

            //결과 출력
            System.out.println(countStrBallList.get(0) + "볼 " + countStrBallList.get(1) + "스트라이크");

            //게임 진행 판단
            if (countStrBallList.get(1) == 3) {
                System.out.println("3개의 숫자를 모두 맞히였습니다! 게임 종료");
                gameStatus = false;
            }
        }
    }
}