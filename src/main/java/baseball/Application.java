package baseball;

public class Application {

    public static void main(String[] args) {
        ElementsMaker elementListMaker = new DividedRandomNumberElementsMaker();

        BaseballGameRunner baseballGameRunner = new BaseballGameRunner(elementListMaker);
        baseballGameRunner.runGame();
    }
}
