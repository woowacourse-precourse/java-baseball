package baseball;

public class GameManager {
    private Computer computer = new Computer();
    private User user = new User();
    private int strike_num = 0;
    private int ball_num = 0;
    public void gameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    private void game() {
        while (!isCorrect()) {

        }
    }
    private void isStrike() {
        for (int i = 0; i < user.getUserInput().size(); i++) {
            if (computer.getRandomNumList().get(i) == user.getUserInput().get(i)) {
                strike_num++;
            }
        }
    }
    private void isBall() {
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
}
