package baseball;

public class Baseball {
    private User user = new User();

    public void playGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        user.hitTheBall();
    }
}
