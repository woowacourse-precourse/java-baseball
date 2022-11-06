package baseball;

public class MessagePrinter {
    private static final String INIT = "숫자 야구 게임을 시작합니다.";
    private static final String END = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    private static final String ASK_INPUT = "숫자를 입력해주세요 : ";
    private static final String ASK_REPLAY = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";


    public void printInit() {
        System.out.println(INIT);
    }

    public void printFinish() {
        System.out.println(END);
    }

    public void askInput() {
        System.out.print(ASK_INPUT);
    }

    public void askReplay() {
        System.out.println(ASK_REPLAY);
    }
}
