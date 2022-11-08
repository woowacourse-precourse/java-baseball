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
    int result = 0;

    public Game() {
        while (result != 3) {
            user = new UserGenerate().user;
            System.out.println(computer);
            Hint hint = new Hint(computer, user);
            hint.ResultHint();
            result = hint.strike;
        }
        OutputView.EndGameOutput();
        restartInput();
    }


}
