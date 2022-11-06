package baseball;

public class SystemOutput {
    public static void allStrikeMessage() {
        System.out.println("3스트라이크");
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
    public static void baseballCountMessage(BaseballCount baseballCount) {
        System.out.printf("%d볼 %d스트라이크", baseballCount.getBallcount(), baseballCount.getStrikecount());
    }
    public static void onlyBallMessage(BaseballCount baseballCount){
        System.out.printf("%d볼",baseballCount.getBallcount());
    }
    public static void onlyStrikeMessage(BaseballCount baseballCount){
        System.out.printf("%d스트라이크",baseballCount.getStrikecount());
    }

    public static void allNotSameMessage() {
        System.out.println("낫싱");
    }


}
