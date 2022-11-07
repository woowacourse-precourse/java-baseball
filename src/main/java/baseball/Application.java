package baseball;

import java.util.*;

import baseball.model.ComputerGenerate;
import baseball.model.UserGenerate;
import baseball.controller.Hint;

import static baseball.view.InputView.restartInput;

public class Application {
    public static void main(String[] args) {
        GameStart();
    }

    private static void GameStart() {
        List<Integer> computer = new ComputerGenerate().computer;
        List<Integer> user = new UserGenerate().user;
        String result = "";

        while (!result.equals("3스트라이크")) {
            user = new UserGenerate().user;
            result = new Hint(computer,user).hintResult;
            System.out.println(result);
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        restartInput();
    }
}
