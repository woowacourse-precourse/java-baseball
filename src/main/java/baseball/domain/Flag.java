package baseball.domain;

import baseball.contorller.GameController;
import baseball.view.Views;

import java.util.Arrays;
import java.util.function.Consumer;

public enum Flag {
    Y("1", GameController::start),
    N("2", service -> Views.FINISH_VIEW.getView().view());

    private final String flag;
    private final Consumer<GameController> consumer;

    Flag(String flag, Consumer<GameController> consumer) {
        this.flag = flag;
        this.consumer = consumer;
    }

    public static Flag getFlag(String string) {
        return Arrays.stream(Flag.values())
                .filter(f -> f.flag.equals(string))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    public void accept(GameController controller) {
        this.consumer.accept(controller);
    }
}
