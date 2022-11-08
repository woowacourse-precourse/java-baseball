package baseball;

public class UserOutput {
    public static void userNumInputMessage() {
        System.out.print("숫자를 입력해주새요 : ");
    }

    public static void userChoiceReplayOrStopMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public static void userWinMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void RefereeMessage(int ballCount, int strikeCount) {
        if(ballCount>0)
            System.out.printf("%d볼 ", ballCount);

        if (strikeCount>0)
            System.out.printf("%d스트라이크", strikeCount);

        if(ballCount==0 && strikeCount==0)
            System.out.printf("낫싱");
        System.out.println();
    }
}
