package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;


public class Application {

    public static final int length = 3;
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        startGame();
    }

    public static void startGame() {
        // Computer creates random number
        List computerRandom = Computer.getComputerNum();
        // System.out.println(computerList);

        getUserInput(computerRandom);
    }

    public static void getUserInput(List computerRandom) {
        System.out.print("숫자를 입력해주세요 : ");

        // Get and validate user input
        List userRandom = User.getUserNum();
        // System.out.println(userList);
        Checker.getResult(computerRandom, userRandom);
    }
}
