package baseball;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Output.printStartMsg();
        Game Game = new Game();
        Game.start();
    }
}


