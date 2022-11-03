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

        boolean doesUserWin,playingAgain;

        do{
            List<Integer> computerInput = gameInput.computerMadeNumbers();
            String userInput = gameInput.userPlayingInput();

            doesUserWin = computerCalculate.compareUserAndComputer(userInput,computerInput);
            playingAgain = !doesUserWin || gameInput.checkingAgainInput();

        }while(playingAgain);
    }
}
