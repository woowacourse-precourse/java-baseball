package baseball.helper.factory;

import baseball.domain.game.GameComputer;
import baseball.mvc.structure.FrontController;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class FrontControllerFactory {

    private static final String COMPUTER_FIELD_NAME = "computer";
    private static final int FIELD_INDEX = 0;

    private FrontControllerFactory() {
    }

    public static FrontController createStubFrontController(long strike, long ball) {
        GameComputer stubGameComputer = GameComputerFactory.createStubGameComputer(strike, ball);

        FrontController frontController = new FrontController();

        List<Field> fields = Arrays.stream(FrontController.class.getDeclaredFields())
                .filter(field -> field.getName().equals(COMPUTER_FIELD_NAME))
                .collect(Collectors.toList());

        Field computer = fields.get(FIELD_INDEX);
        computer.setAccessible(true);

        try {
            computer.set(frontController, stubGameComputer);
            return frontController;
        } catch (Exception e) {
            return new FrontController();
        }
    }
}
