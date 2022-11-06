package baseball;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Game {
    private static final String START_STRING = "숫자 야구 게임을 시작합니다.";
    private static final int BALL_INDEX = 0;
    private static final int STRIKE_INDEX = 1;

    private final Player computer;
    private final Player player;

    public Game() {
        this.computer = new Player();
        this.player = new Player();
    }

    public void init() {
        System.out.println(START_STRING);
    }

    public void start() {
        computer.setRandomNumber();
        player.setNumber();
        HashMap<Integer, Integer> compareBoard = new HashMap<>();
        compareBoard = getCompareBoard(computer);
        }
    private HashMap<Integer, Integer> getCompareBoard(Player computer) {
        HashMap<Integer, Integer> compareBoard = new HashMap<>();
        ArrayList<Integer> computerNumbers = computer.getNumbers();
        for (int i = 0; i < computerNumbers.size(); i++) {
            compareBoard.put(computerNumbers.get(i), i);
        }
        return compareBoard;
    }

    private ArrayList<Integer> getScore(Player player, HashMap<Integer, Integer> compareBoard) {
        ArrayList<Integer> score = new ArrayList<>(List.of(0, 0));
        ArrayList<Integer> playerNumbers = player.getNumbers();
        for (int i = 0; i < playerNumbers.size(); i++) {
            if (isStrike(playerNumbers.get(i), i, compareBoard)) {
                score.set(STRIKE_INDEX, score.get(STRIKE_INDEX) + 1);
                continue;
            }
            if (isBall(playerNumbers.get(i), compareBoard)) {
                score.set(BALL_INDEX, score.get(BALL_INDEX) + 1);
            }
        }
        return score;
    }

    private Boolean isStrike(Integer number, Integer index, HashMap<Integer, Integer> compareBoard) {
        if (compareBoard.containsKey(number)) {
            return compareBoard.get(number).equals(index);
        }
        return false;
    }

    private Boolean isBall(Integer number, HashMap<Integer, Integer> compareBoard) {
        return compareBoard.containsKey(number);
    }
}