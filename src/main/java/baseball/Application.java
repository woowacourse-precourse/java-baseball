package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            int b = startGame.makegameStartEnd();
            if(b == 1) {
                continue;
            } else if (b == 2) {
                System.out.println("게임 종료");
                break;
            }
        }
    }
}
