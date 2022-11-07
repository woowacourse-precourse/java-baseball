package baseball.controller;

import baseball.model.Game;
import baseball.service.GameService;
import camp.nextstep.edu.missionutils.Console;

public class GameController {

    private final int RESTART_GAME = 1;
    private final int QUIT_GAME = 2;
    private GameService gameService = new GameService();

    public void startGame() {
        int choose = 0;

        System.out.println("숫자 야구 게임을 시작합니다.");

        do {
            proceed();

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            choose = Integer.parseInt(Console.readLine());

        } while(choose == RESTART_GAME);
    }

    public void proceed() {
        Game answer = new Game();

        answer = gameService.initAnswer(answer);

        Game userInput = new Game();

        boolean result = false;
        while(!result) {
            System.out.print("숫자를 입력해주세요 : ");
            String inputStr = Console.readLine();

            userInput = gameService.initInput(userInput, inputStr);
            gameService.validate(userInput);

            result = gameService.compareAnswer(answer, userInput);
        }

        if(result){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }
}
