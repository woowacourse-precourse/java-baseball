package baseball.objects;

import baseball.valid.Validation;
import baseball.view.View;
import baseball.view.service.ViewService;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Game {
    private final Computer computer;
    private final Referee referee;
    private final Player player;
    private final Validation validation = new Validation();

    public Game(Computer computer, Referee referee, Player player) {
        this.computer = computer;
        this.referee = referee;
        this.player = player;
    }

    public boolean start() {
        computer.generateNumbers();
        referee.receiveComputerNumbers(computer.getNumbers());

        boolean isFinished = false;
        while (!isFinished) {
            View.pushNumber();

            savePlayerNumberToReferee(player, referee);

            ViewService responseView = referee.answerNumber();
            isFinished = responseView.countOfViewCheck();
        }

        return restart();
    }

    private void savePlayerNumberToReferee(Player player, Referee referee) {
        savePlayerNumber(player);
        referee.receivePlayerNumbers(player.getNumbers());
    }

    private void savePlayerNumber(Player player) {
        String pushNumber = pushBaseballNumber();
        player.sayNumbers(stringNumberToList(pushNumber));
    }

    private String pushBaseballNumber() {
        String baseBallPushNumber = pushNumber();
        validation.validNumbers(baseBallPushNumber);
        return baseBallPushNumber;
    }

    private boolean restart() {
        String restartPushNumber = pushNumber();
        validation.restartNumberValid(restartPushNumber);
        return Integer.valueOf(restartPushNumber).equals(1);
    }

    private List<Integer> stringNumberToList(String number) {
        return Arrays.stream(number.split("")).map(Integer::valueOf).collect(Collectors.toList());
    }

    private String pushNumber() {
        return Console.readLine();
    }
}
