package baseball;

public class GameManager {
    private Computer computer = new Computer();
    private User user = new User();
    private int strike_num = 0;
    private int ball_num = 0;
    public void gameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        game();
        reGame();
    }
    private void game() {
        computer.computer_random_num();
        do {
            user.userInput();
            isStrike();
            isBall();
            printResult();
        } while (!isCorrect());
        System.out.println(computer.getRandomNumList().size() + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
    private void isStrike() {
        strike_num = 0;
        for (int i = 0; i < computer.getRandomNumList().size(); i++) {
            if (computer.getRandomNumList().get(i) == user.getUserInput().get(i)) {
                strike_num++;
            }
        }
    }
    private void isBall() {
        ball_num = 0;
        for (int i = 0; i < computer.getRandomNumList().size(); i++) {
            if (computer.getRandomNumList().contains(user.getUserInput().get(i))) {
                ball_num++;
            }
        }
        ball_num -= strike_num;
    }
    private boolean isCorrect() {
        for (int i = 0; i < user.getUserInput().size(); i++) {
            if (computer.getRandomNumList().get(i) == user.getUserInput().get(i)) {}
            else return false;
        }
        return true;
    }
    private void printResult() {
        if (strike_num != 0 && ball_num != 0) { // n 볼 n 스트라이크
            System.out.println(ball_num + "볼 " + strike_num + "스트라이크");
        } else if (strike_num != 0 && ball_num == 0) { // n 스트라이크
            System.out.println(strike_num + "스트라이크");
        } else if (strike_num == 0 && ball_num != 0) { // n 볼
            System.out.println(ball_num + "볼");
        } else if (strike_num == 0 && ball_num == 0) { // 낫싱
            System.out.println("낫싱");
        }
    }
    private void reGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        if (user.userReGameInput() == 1) {
            game();
        }
    }
}
