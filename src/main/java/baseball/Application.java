package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GetUserNumber userInput = new GetUserNumber();
        String userRandNumber = userInput.inputUserNumber();

        GenerateRandNumber generateNumber = new GenerateRandNumber();
        List<Integer> correctRandNumber = generateNumber.arrayNum();

        // count STRIKE
        int countStrike = 0;
        for(int i=0; i<correctRandNumber.size(); i++) {
            int eachUserNumber = userRandNumber.charAt(i) - '0';
            if (eachUserNumber == correctRandNumber.get(i)) {
                countStrike ++;
            }
        }

        //count BALL
        int countBall = 0;
        for(int i=0; i<correctRandNumber.size(); i++) {
            int eachUserNumber = userRandNumber.charAt(i) - '0';
            if (eachUserNumber == correctRandNumber.get(i)) {
                countBall = countBall;
            } else if (correctRandNumber.contains(eachUserNumber)) {
                countBall ++;
            }
        }

        //결과 출력
        System.out.println(countBall + "볼 " + countStrike + "스트라이크");

        //게임 진행 판단
        int gameStatus = 1;
        if (countStrike == 3) {
            System.out.println("3개의 숫자를 모두 맞히였습니다! 게임 종료");
            gameStatus = 0;
        }
    }
}