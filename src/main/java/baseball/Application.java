package baseball;

public class Application {
    public static void main(String[] args) {
        Game game = new Game();
        game.notifyStart();
        do {
            try {
                game.start();
                game.notifyRestartOrEnd();
                game.setRestarter(game.getRestartOrEndNumber());
            }catch (IllegalArgumentException e){
                game.restarter = false;
                throw new IllegalArgumentException();
            }
        }while (game.restarter);
        }
    }

