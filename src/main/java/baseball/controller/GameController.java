package baseball.controller;

import baseball.service.GameService;
import baseball.utils.Validation;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static baseball.Constant.*;

public class GameController {
    private GameService gameService = new GameService();
    private Validation validate = new Validation();

    public void start() {

    }

    public void proceed() {
        List<Integer> computerList = gameService.makeComputerNumber();

        boolean result = false;
        while (!result) {
            System.out.print(USER_INPUT_MESSAGE);
            String inputStr = Console.readLine();

            List<Integer> userInputList = gameService.makeUserNumber(inputStr);
            validate.validateInput(userInputList);

            result = gameService.compareAnswer(computerList, userInputList);
        }

        if (result) {
            System.out.println(GAME_OVER_MESSAGE);
        }
    }

    public int checkRestartorExit() {
        int selection = 0;

        boolean isValid = false;
        while (!isValid) {
            try {
                String input = Console.readLine();
                selection = Integer.parseInt(input);
            } catch (NumberFormatException ne) {
                throw new IllegalArgumentException(USER_SELECT_ERROR);
            }

            if (selection != RESTART_GAME && selection != QUIT_GAME) {
                System.out.println(USER_SELECT_ERROR + " 다시 입력하십시오.");
            }

            if (selection == RESTART_GAME || selection == QUIT_GAME) {
                isValid = true;
            }
        }

        return selection;
    }
}
