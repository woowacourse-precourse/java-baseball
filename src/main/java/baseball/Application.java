package baseball;

import baseball.model.User;
import baseball.service.Game;

public class Application {
    public static void main(String[] args) {
        Game game = new Game();
        User user = game.getUser();
        game.gameStart(user.getStatus());
    }
}
