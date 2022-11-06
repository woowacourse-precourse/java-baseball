package baseball;

public class Player {
    private static final Player PLAYER = new Player();

    public static Player getPlayer() {
        return PLAYER;
    }


}