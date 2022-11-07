package baseball.view;

public class OutputView {

    public void printGameBegin() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printResult(Long balls, Long strikes) {
        System.out.println(balls + "볼 " + strikes + "스트라이크");
    }

    public void printGameFinish() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
