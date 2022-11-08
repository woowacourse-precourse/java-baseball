package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Game {
    private final Computer computer;
    private final ComparisonNumber comparisonNumber;

    public Game() {
        this.computer = new Computer();
        this.comparisonNumber = new ComparisonNumber();
    }

    public String restartGame() {
        System.out.println("새 게임을 시작하려면 1, 완전 종료하실려면 2를 입력해주세요");
        String input = Console.readLine();
        if (input.charAt(0) == '1' || input.charAt(0) == '2') {
            return input;
        }
        throw new IllegalArgumentException();
    }
    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        computer.computerGameSetting();
        while (true) {
            comparisonNumber.checkResult(computer.getComputerNumber(), User.getUserNumber());
            System.out.println(comparisonNumber.Message());
            if (comparisonNumber.getStrike() == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
        String input = restartGame();
        if (input.equals("1")) {
            start();
        }
    }
}