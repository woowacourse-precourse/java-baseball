package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Game {
    private Computer computer;
    private User user;

    public Game(Computer computer, User user) {
        this.computer = computer;
        this.user = user;
    }

    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        generateNumbers();
        while (true) {
            if (isGameOver()) {
                return;
            }
            user.setNumbers(inputUserNumbers());
        }

    }

    public String inputUserNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        return input;
    }

    private void generateNumbers() {
        computer.generateRandomNumbers();
        user.setNumbers(inputUserNumbers());
    }

    private boolean isGameOver() {
        Score score = Score.getResult(computer.getNumbers(), user.getNumbers());
        if (score.checkThreeStrike()) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            computer.generateRandomNumbers();
            return restart();
        }
        return false;
    }

    private boolean restart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userChoice = Console.readLine();
        checkError(userChoice);

        if (userChoice.equals("1")) {
            return false;
        }

        return true;
    }

    private void checkError(String restartInput) {
        if (restartInput.length() != 1) {
            throw new IllegalArgumentException("1 또는 2 중 하나만 선택하세요.");
        }
        if (!restartInput.matches("^[1-2]*$")) {
            throw new IllegalArgumentException("1 또는 2 중 하나만 선택하세요.");
        }
    }
}
