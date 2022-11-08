package baseball;

public class Application {

    public static void main(String[] args) {
        Assembler assembler = new Assembler();
        assembler.createAndWire();
        final GameController gameController = assembler.getGameController();
        gameController.process();
    }
}
