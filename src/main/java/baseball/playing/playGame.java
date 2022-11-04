package baseball.playing;

import baseball.players.Computer;
import baseball.players.User;
import camp.nextstep.edu.missionutils.Console;

public class playGame {

    private String computerNumbers;
    private String userNumbers;

    public playGame() {
        startGame();
        Computer computer = new Computer();
        computerNumbers = computer.getComputerNumbers();
    }

    private void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private String inputUserNumbers() {

        String inputNumbers = Console.readLine();
        User user = new User(inputNumbers);

        userNumbers = user.getUserNumbers();

        return userNumbers;
    }
}
