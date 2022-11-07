package baseball;

public class GameManager {
    private Computer computer = new Computer();
    private User user = new User();
    public void gameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    private void game() {

    }
    private int isStrike() {
        int strike_num = 0;
        for (int i = 0; i < computer.getRandomNumList().size(); i++) {
            if (computer.getRandomNumList().get(i) == user.getUserInput().get(i)) {
                strike_num++;
            }
        }
        return strike_num;
    }
    private void isBall() {
        int ball_num = 0;
    }
}
