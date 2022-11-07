package baseball;

import baseball.Input.InputManager;
import baseball.Output.Message;
import baseball.Output.OutputManager;


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
    private void playGameUntilCorrectAnswer()
    {
        String userInput = new String();

        while(!gameController.isAnswer(userInput))
        {
            outputManager.output(Message.NUMBER_INPUT_REQUEST_MESSAGE);
            userInput = inputManager.readInputFromUser();
            String hintMessage = gameController.getHint(userInput);
            outputManager.output(hintMessage);
        }
    }

    private boolean playNextGameFromUserInput()
    {
        while(true)
        {
            try
            {
                String userInput = inputManager.readInputFromUser();
                return playNextGame(Integer.parseInt(userInput));
            }
            catch (IllegalArgumentException e)
            {
                outputManager.output(e.getMessage());
            }
        }
    }

    public void doGame()
    {
        boolean playNextGame = true;
        outputManager.output(Message.GAME_START_MESSAGE);
        while(playNextGame)
        {
            gameController.generateRandomNumber();

            playGameUntilCorrectAnswer();

            outputManager.output(Message.INPUT_CORRECT_MESSAGE);

            playNextGame = playNextGameFromUserInput();
        }

        outputManager.output(Message.GAME_END_MESSAGE);
    }

    private Boolean playNextGame(Integer userInput)
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
