package baseball;

public class ConfirmAnswer {

    public ConfirmAnswer() {

    }

    private void giveHint(String hint) {
        System.out.println(hint);

        if (hint == "3스트라이크") {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }
}
