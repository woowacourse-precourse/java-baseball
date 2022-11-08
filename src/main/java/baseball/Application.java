package baseball;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        String answer = "";
        int stopFlag = 0;

        while (stopFlag == 0) {
            answer = MakeRandomString.run();

            try {
                PlayGame.play(answer);
            } catch (Exception e) {
                throw new IllegalArgumentException();
            }

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

            try {
                stopFlag = StopGame.isStop();
            } catch (Exception e) {
                throw new IllegalArgumentException();
            }
        }
    }
}
