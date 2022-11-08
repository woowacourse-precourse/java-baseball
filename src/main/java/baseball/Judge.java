package baseball;

import java.util.ArrayList;

public class Judge {
    private final Computer computer;
    private final Player player;
    private final CheckException check;

    public Judge() {
        this.player = new Player();
        this.computer = new Computer();
        this.check = new CheckException();
    }

    public ArrayList<Integer> getPlayerNumbers() {
        this.player.decideNumbers(this.player.inputNumbers());
        return this.player.getNumbers();
    }

    public ArrayList<Integer> getComputerNumbers() {
        return this.computer.getNumbers();
    }

    public Result compareBalls(ArrayList<Integer> playerNumbers, ArrayList<Integer> computerNumbers) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < GameStatus.MAX_SIZE.getValue(); i++) {
            if (playerNumbers.get(i).equals(computerNumbers.get(i))) {
                strike++;
            } else if (computerNumbers.contains(playerNumbers.get(i))) {
                ball++;
            }
        }
        return new Result(strike, ball);
    }

    public int decideGameContinue() {
        return this.check.validateGameStatusData(this.player.inputGameStatusData());
    }
}
