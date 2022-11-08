package baseball.view;

public class View {
    private View() {
    }

    public static void printStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printInputRequest() {
        System.out.print("숫자를 입력해주세요 : ");
    }
}
