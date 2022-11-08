package baseball.utils.appConfig;

import baseball.computer.ComputerGameEndChecker;
import baseball.computer.ComputerGameEndCheckerImple;
import baseball.computer.ComputerHintGenerator;
import baseball.computer.ComputerHintGeneratorImple;
import baseball.computer.ComputerNumbersGenerator;
import baseball.computer.ComputerNumbersGeneratorImple;
import baseball.computer.GameComputer;
import baseball.computer.GameComputerImple;
import baseball.gameController.Game;
import baseball.gameController.GameImple;
import baseball.player.PlayerInput;
import baseball.player.PlayerInputImple;
import baseball.player.PlayerInputValidator;
import baseball.player.PlayerInputValidatorImple;

import java.util.ArrayList;
import java.util.List;


/**
 * 의존관계 주입은 여기만 한다
 */
public class AppConfig {

    public static GameComputer createGameComputer() {
        return new GameComputerImple(createComputerNumbersGenerator()
                , createComputerHintGenerator()
                , createComputerGameEndChecker());
    }

    public static ComputerNumbersGenerator createComputerNumbersGenerator() {
        return new ComputerNumbersGeneratorImple();
    }

    public static ComputerHintGenerator createComputerHintGenerator() {
        return new ComputerHintGeneratorImple();
    }

    public static ComputerGameEndChecker createComputerGameEndChecker() {
        return new ComputerGameEndCheckerImple();
    }


    public static Game createGame() {
        return new GameImple(createPlayerInput()
                , createGameComputer());
    }


    public static PlayerInput createPlayerInput() {
        return new PlayerInputImple(initNumbersType()
                , createPlayerInputValidator());
    }

    public static PlayerInputValidator createPlayerInputValidator() {
        return new PlayerInputValidatorImple();
    }

    public static List<Integer> initNumbersType() {
        return new ArrayList<>(3);
    }


}
