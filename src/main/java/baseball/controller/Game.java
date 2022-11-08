package baseball.controller;

import baseball.domain.Baseball;
import baseball.view.Printer;

import java.util.List;

import static baseball.controller.Computer.createRandomNums;
import static baseball.controller.Number.*;
import static baseball.exception.BaseballException.*;
import static baseball.view.Printer.*;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Game {
    private static int newGameCode = 1;
    private static int shutDownCode = 2;
    public static int getNewGameCode() {
        return newGameCode;
    }
    public static int getShutDownCode() {
        return shutDownCode;
    }

    /** 게임 시작 */
    public static void startGame() {
        showMessageStartGame();
        List<Integer> answer = createRandomNums();
        startRound(answer);
        if (getShutDownCheck()) {
            startGame();
        } else {
            showGameEnd();
        }
    }

    /** 게임 라운드 시작 */
    private static void startRound(List<Integer> answer){
        int input = getInputNums();
        List<Integer> numList = getNumsArr(input);
        // 체크
        Baseball result = checkAnswer(numList, answer);
        // 결과 출력
        System.out.println(printRoundResult(result));
        // 종료 체크
        if (clear(result)) {
            Printer.showClear();
            return;
        } else {
            startRound(answer);
        }
    }

    public static boolean getShutDownCheck() {
        int input = 0;
        Printer.showShutDownCheck();
        try {
            input = Integer.parseInt(readLine());
            vaildShutDownInput(input);
        } catch (NumberFormatException e) {
        }
        vaildShutDownInput(input);
        return input==1;
    }
}
