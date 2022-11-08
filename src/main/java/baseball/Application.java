package baseball;

import baseball.computerCalculate.ComputerCalculate;
import baseball.inputs.GameInput;
import baseball.inputs.GameOutput;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        GameInput gameInput = new GameInput();
        GameOutput gameOutput = new GameOutput();
        ComputerCalculate computerCalculate = new ComputerCalculate();

        gameOutput.printWhenStart();

        List<Integer> computerInput = gameInput.computerMadeNumbers();
        boolean playingAgain;

        do{
            String userInput = gameInput.userPlayingInput();

            boolean doesUserWin = computerCalculate.compareUserAndComputer(userInput,computerInput);
            if(doesUserWin){
                gameOutput.printWhenUserWin();
            }

            playingAgain = !doesUserWin || gameInput.checkingAgainInput();
            if(doesUserWin && playingAgain){
                computerInput = gameInput.computerMadeNumbers();
            }

        }while(playingAgain);
    }
}
