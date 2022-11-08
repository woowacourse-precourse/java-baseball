package baseball;


import controller.GameController;
import factory.BaseballGameFactory;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BaseballGameFactory factory = new BaseballGameFactory();
        GameController controller = factory.getGame();
        controller.doGame();
    }
}
