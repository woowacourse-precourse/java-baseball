package baseball.repository;

import baseball.domain.Player;

public class PlayerRepository {

    private Player player;

    public void setPlayer(int firstNumber, int secondNumber, int thirdNumber) {
        this.player = new Player(firstNumber,secondNumber,thirdNumber);
    }

    public Player getPlayer() {
        return this.player;
    }

}
