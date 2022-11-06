package baseball.controller;

import baseball.model.Balls;
import baseball.model.Result;
import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class BaseballGame {
    public static void play() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        int regame;
        do {
            playAGame();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            regame = Integer.parseInt(Console.readLine());
        } while (regame == 1);
    }

    private static void playAGame() {
        List<Integer> uniqueNumbersInRange = Randoms.pickUniqueNumbersInRange(1, 9, 3);
        Balls computer = asBalls(uniqueNumbersInRange);
        Result result;
        Balls user;
        do {
            user = InputView.input();
            result = computer.getResult(user);
            OutputView.print(result);
        } while (!result.isGameEnd());
    }

    private static Balls asBalls(List<Integer> uniqueNumbersInRange) {
        return null;
    }
}
