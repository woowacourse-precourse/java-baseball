package baseball;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        String answer = "";
        boolean stopFlag = false;

        while (!stopFlag) {
            answer = MakeRandomString.run();

            PlayGame.run(answer);

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }
}
