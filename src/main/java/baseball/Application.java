package baseball;

public class Application {
    public static void main(String[] args) {
        boolean isContinue = true;
        PrintComment.printStartComment();
        Game game = new Game();
        do {
            game.start();

            if (!game.isAnswer()) {
                continue;
            }
            if (!game.canRestart()){
                isContinue = false;
                continue;
            }
            game = new Game();
        } while(isContinue);
    }
}
