package baseball;

import baseball.process.EndGame;
import baseball.process.InitGame;
import baseball.process.MainGame;
import baseball.setting.Setting;
import baseball.ui.OutputText;
import baseball.unit.Game;

import java.util.List;

public class Application {

    public static void main(String[] args) {

        OutputText outputText = new OutputText();
        InitGame initGame = new InitGame(outputText);
        EndGame endGame = new EndGame(outputText);

        List<Integer> computerNumber = initGame.createComputerNumber();

        while(true){
            MainGame mainGame = new MainGame(outputText);
            List<Integer> inputNumber = mainGame.inputGuessNumber();

            Game game = new Game(computerNumber, inputNumber);
            List<Integer> count = game.count();
            if(mainGame.judge(count.get(0), count.get(1))){
                if(!endGame.continueGame())
                    break;
                computerNumber = initGame.createComputerNumber();
            }
        }
    }
}
