package baseball.helper.factory;

import baseball.domain.game.GameComputer;
import baseball.helper.exception.CannotReflectionException;
import baseball.helper.util.ReflectionFieldUtils;
import baseball.mvc.structure.FrontController;
import java.lang.reflect.Field;

public final class FrontControllerFactory {

    private static final String COMPUTER_FIELD_NAME = "computer";

    private FrontControllerFactory() {
    }

    public static FrontController createStubFrontController(long strike, long ball) {
        GameComputer stubGameComputer = GameComputerFactory.createStubGameComputer(strike, ball);
        FrontController frontController = new FrontController();

        Field computer = ReflectionFieldUtils.processReflectionField(FrontController.class, COMPUTER_FIELD_NAME);

        try {
            computer.set(frontController, stubGameComputer);
            return frontController;
        } catch (Exception e) {
            throw new CannotReflectionException(e);
        }
    }
}
