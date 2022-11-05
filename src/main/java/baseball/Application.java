package baseball;

import baseball.Input.InputManageable;
import baseball.Input.InputManager;
import baseball.Output.Message;
import baseball.Output.OutputManager;

import java.util.List;

public class Application {
    private InputManager inputManager;
    private OutputManager outputManager;
    private GameController gameController;

    private static final Integer doNextGameInput = 1;
    private static final Integer doNotNextgameInput = 2;
    public Application()
    {
        inputManager = new InputManager();
        outputManager = new OutputManager();
        gameController = new GameController();
    }

    public void doGame()
    {
        boolean doNextGame = true;
        while(doNextGame)
        {
            gameController.generateRandomNumber();
            String userInput = new String();

            while(!gameController.isAnswer(userInput))
            {
                outputManager.output(Message.NUMBER_INPUT_REQUEST_MESSAGE);
                userInput = inputManager.readInputFromUser();
                String hintMessage = gameController.getHint(userInput);
                outputManager.output(hintMessage);
            }

            outputManager.output(Message.INPUT_CORRECT_MESSAGE);

            while(true)
            {
                try
                {
                    userInput = inputManager.readInputFromUser();
                    doNextGame = hasNextGame(Integer.parseInt(userInput));
                    break;
                }
                catch (IllegalArgumentException e)
                {
                    outputManager.output(e.getMessage());
                }
            }

        }

    }

    private Boolean hasNextGame(Integer userInput)
    {
        if(userInput.equals(doNextGameInput))
        {
            return true;
        }
        else if(userInput.equals(doNotNextgameInput) )
        {
            return false;
        }

        throw new IllegalArgumentException(Message.USER_INPUT_FOR_NEXT_GAME_ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        new Application().doGame();
    }
}
