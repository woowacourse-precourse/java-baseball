package baseball;

import baseball.service.*;
import camp.nextstep.edu.missionutils.Console;

import java.io.IOException;
import java.util.List;

public class Application {
    public static void main(String[] args) throws IOException {
        GameSystem gameSystem = new GameSystem();
        gameSystem.start();
    }
}
