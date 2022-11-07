package baseball.controller;

import baseball.model.Game;
import baseball.service.GameService;
import camp.nextstep.edu.missionutils.Console;

public class GameController {

    private final int RESTART_GAME = 1;
    private final int QUIT_GAME = 2;
    private GameService gameService = new GameService();

    public void startGame(){

        Game answer = new Game();

        answer = gameService.initAnswer(answer);

        System.out.println("숫자 야구 게임을 시작합니다.");
        System.out.print("숫자를 입력해주세요 : ");

        Game userInput = new Game();
        String inputStr = Console.readLine();

        // TODO: input을 한글자씩 분리해서 List에 넣어보자.
        userInput = gameService.initInput(userInput, inputStr);
        gameService.validate(userInput);

    }
}
