package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class GameStart {
    public static final String RESTART = "1";
    public static final String END = "2";

    public void run() {
        Message.gameStart();
        String answer = RESTART;
        while (isRestart(answer)) {
            List<Integer> computerNum = setComputer();
            startNewGame(computerNum);
            Message.endOrRestart();
            answer = Console.readLine();
        }

    }

    private void startNewGame(List<Integer> computerNum) {
        boolean endGame = false;
        while (!endGame) {
            List<Integer> userNum = setUser();
            endGame = isEnd(getStrikeCount(userNum, computerNum));
            Message.printResult(getBallCount(userNum, computerNum), getStrikeCount(userNum, computerNum));
        }
        Message.gameEnd();
    }

    private List<Integer> setUser() {
        User user = new User();
        List<Integer> userNum = new ArrayList<>();
        userNum = user.input();
        return userNum;
    }

    private List<Integer> setComputer() {
        Computer computer = new Computer();
        List<Integer> computerNum = new ArrayList<>();
        computerNum = computer.getRandomNumber();
        return computerNum;
    }


    public int getBallCount(List<Integer> userNum, List<Integer> computerNum) {
        return (int) Stream.iterate(0, i -> i < userNum.toArray().length, i -> i + 1)
                .filter(i -> computerNum.contains(userNum.get(i)) && computerNum.get(i) != userNum.get(i))
                .count();
    }

    public int getStrikeCount(List<Integer> userNum, List<Integer> computerNum) {
        return (int) Stream.iterate(0, i -> i < userNum.toArray().length, i -> i + 1)
                .filter(i -> computerNum.get(i) == userNum.get(i))
                .count();
    }

    public boolean isEnd(int strikeCount) {
        return strikeCount == 3;
    }

    public boolean isRestart(String answer) {
        if (answer.equals(RESTART)) {
            return true;
        } else if (answer.equals(END)) {
            return false;
        }
        throw new IllegalArgumentException();
    }
}
