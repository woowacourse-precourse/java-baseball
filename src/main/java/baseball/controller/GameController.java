package baseball.controller;

import baseball.model.Game;
import baseball.service.GameService;
import baseball.service.Validator;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class GameController {

    private final int RESTART_GAME = 1;
    private final int QUIT_GAME = 2;

    private final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private final String GAME_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private final String USER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private final String GAME_OVER_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private final String USER_INPUT_ERROR = "1(재시작) 또는 2(종료)만 입력할 수 있습니다.";

    private GameService gameService = new GameService();
    private Validator validator = new Validator();

    public void startGame() {
        int selection = 0;

        System.out.println(GAME_START_MESSAGE);

        do {
            proceed();

            System.out.println(GAME_RESTART_MESSAGE);
            selection = checkUserSelection();
        } while (selection == RESTART_GAME);
    }

    public void proceed() {
        List<Integer> initList = gameService.initAnswer();
        Game answer = new Game(initList);

        boolean result = false;
        while (!result) {
            System.out.print(USER_INPUT_MESSAGE);
            String inputStr = Console.readLine();

            List<Integer> inputList = gameService.initInput(inputStr);
            validator.validate(inputList);
            Game userInput = new Game(inputList);

            result = answer.compare(userInput);
        }

        if (result) {
            System.out.println(GAME_OVER_MESSAGE);
        }
    }

    public int checkUserSelection() {
        int selection = 0;

        boolean isValid = false;
        while (!isValid) {
            try {
                String input = Console.readLine();
                selection = Integer.parseInt(input);
            } catch (NumberFormatException ne) {
                throw new IllegalArgumentException(USER_INPUT_ERROR);
            }

            if (selection != RESTART_GAME && selection != QUIT_GAME) {
                System.out.println(USER_INPUT_ERROR + "다시 입력하십시오.");
            }

            if (selection == RESTART_GAME || selection == QUIT_GAME) {
                isValid = true;
            }
        }

        return selection;
    }
}