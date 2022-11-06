package baseball.controller;

import baseball.facade.GameFacade;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class GameController {
    GameFacade gameFacade = new GameFacade();

    public void programStart(Integer numberSize) {
        gameInit(numberSize);
        gameRestart(numberSize);
    }

    private void gameInit(Integer numberSize) {
        List<Integer> gameNumber = gameFacade.makeGameNumber(numberSize);
        gameFacade.gameStart(numberSize, gameNumber);
    }

    public void gameRestart(Integer NumberSize) {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        if (input.equals("1")) {
            programStart(NumberSize);
            return;
        }
        if (input.equals("2")) {
            return;
        }
        throw new IllegalArgumentException("1과 2만 입력이 가능합니다.");
    }
}
