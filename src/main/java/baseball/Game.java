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

        for (int i = 0; i < randomNumbers.size(); i++) {
            System.out.println(randomNumbers.get(i));
        }

        GameJudgement gameJudgement = new GameJudgement();

        boolean gameEnd;
        do {
            List<Integer> playerInputNumbers = player.getInputNumberAsList();

            gameEnd = gameJudgement.judge(randomNumbers, playerInputNumbers);
        } while (!gameEnd);
    }
}
