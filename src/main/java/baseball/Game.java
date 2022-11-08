package baseball;

import java.util.List;

public class Game {
    Computer computer;
    Player player;

    public void run() {
        setInitialSetting();
        play();
    }

    public void setInitialSetting() {
        computer = new Computer();
        player = new Player();
    }

    public void play() {
        List<Integer> randomNumbers = computer.getRandomNumbers();

        List<Integer> playerInputNumbers = player.getInputNumberAsList();
    }
}
