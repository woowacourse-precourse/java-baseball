package baseball.utils;

import baseball.view.InputView;
import baseball.view.OutputView;

public class InputHandler {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public String getUserBalls() {
        try{
            String userInput = inputView.inputPlayerBalls();
            new BallsValidator(userInput);
            return userInput;
        }catch (IllegalArgumentException e){
            outputView.printError(e.getMessage());
            return getUserBalls();
        }
    }

    public int getRestart(){
        try{
            String restart = inputView.inputRestart();
            new RestartValidator(restart);
            return Integer.parseInt(restart);
        }catch (IllegalArgumentException e ){
            outputView.printError(e.getMessage());
            return getRestart();
        }
    }
}
