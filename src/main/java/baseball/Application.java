package baseball;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BaseballComputer baseballComputer = new BaseballComputer();
        GameMessage gameMessage = new GameMessage();
        gameMessage.startGameMessage();
        baseballComputer.start();
    }
}
