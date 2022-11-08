package baseball.controller;

import baseball.model.ComputerGenerate;
import baseball.model.UserGenerate;
import baseball.view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static baseball.model.Constant.QUIT;
import static baseball.model.Constant.RESTART;
import static baseball.view.InputView.restartInput;

public class Game {
    List<Integer> computer = new ArrayList<>();
    List<Integer> user = new ArrayList<>();

    public Game() {
        do {
            RunGame(0);
        } while (ReGame());
    }

    private void RunGame(int result) {
        computer = new ComputerGenerate().computer;
        while (result != 3) {
            user = new UserGenerate().user;
            System.out.println(computer);
            Hint hint = new Hint(computer, user);
            hint.ResultHint();
            result = hint.strike;
        }
    }


    private boolean ReGame() {
        OutputView.EndGameOutput();
        if (restartInput() == RESTART) {
            return true;
        }
        if (restartInput() == QUIT) {
            return false;
        }
        throw new IllegalArgumentException("잘못된 입력");
    }

}
