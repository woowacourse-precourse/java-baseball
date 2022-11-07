package baseball;

import baseball.gameclient.GameClient;
import baseball.gameconsole.ClientConsole;
import baseball.gameconsole.GameClientConsole;
import baseball.generator.NumberPicker;
import baseball.generator.RandomNumberPicker;
import baseball.referee.Referee;
import baseball.validator.InputValidator;

public class Application {

    public static void main(String[] args) {
        ClientConsole clientConsole = new GameClientConsole();
        NumberPicker numberPicker = new RandomNumberPicker();
        InputValidator inputValidator = new InputValidator();
        Referee referee = new Referee();
        GameClient gameClient = new GameClient(clientConsole, numberPicker, inputValidator,
            referee);

        gameClient.start();
    }
}
