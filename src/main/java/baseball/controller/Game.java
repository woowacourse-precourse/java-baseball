package baseball.controller;

import baseball.model.ComputerGenerate;
import baseball.model.UserGenerate;
import baseball.view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static baseball.view.InputView.restartInput;

public class Game {
    List<Integer> computer = new ComputerGenerate().computer;
    List<Integer> user = new ArrayList<>();
    String result = "";

    public Game() {
        while (!result.equals("3스트라이크")) {
            user = new UserGenerate().user;
            Hint hint = new Hint(computer,user);
            OutputView.HintOutput(hint.strike,hint.ball);
            System.out.println(result);
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        restartInput();
    }


}
