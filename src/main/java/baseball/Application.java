package baseball;

public class Application {
    private Player player;

    public Application() {
        player = new Player();
    }

    public void startMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public boolean checkRestart(String playerRestart) {
        char letter = playerRestart.charAt(0);
        return letter == '1';
    }

    public void start() {
        startMessage();
        boolean restart = true;
        while (restart) {
            Game game = new Game(player);
            game.start();
            String restartCommand = player.getRestartCommand();
            player.isValidRestartCommand(restartCommand);
            restart = checkRestart(restartCommand);
        }
    }

    public static void main(String[] args) {
        Application app = new Application();
        app.start();
    }
}
