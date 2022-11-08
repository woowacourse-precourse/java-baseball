package baseball.participant;

import baseball.result.ResultType;

public class Emcee {

    public void showStartingGuide(String playerName) {
        String guide = "숫자 야구 게임을 시작합니다.\n" +
                "타자는 3자리 숫자를 정합니다.\n" +
                "투수는 3자리 숫자를 던져서 타자를 3진 아웃 시키면 됩니다!\n" +
                "타자가 생각하는 3자리 숫자를 맞추면 3진 아웃입니다.\n" +
                "그러면 " + playerName + "선수! 투수 위치로 입장해주세요!";
        System.out.println(guide);
    }

    public void showResultMessage(ResultType resultType, int numberOfBall, int numberOfStrike) {
        if (resultType == ResultType.EXACT_MATCH) {
            System.out.println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        } else if (resultType == ResultType.BALL_AND_STRIKE) {
            System.out.println(numberOfBall + "볼 " + numberOfStrike + "스트라이크");
        } else if (resultType == ResultType.ONLY_STRIKE) {
            System.out.println(numberOfStrike + "스트라이크");
        } else if (resultType == ResultType.ONLY_BALL) {
            System.out.println(numberOfBall + "볼");
        } else if (resultType == ResultType.NOTHING) {
            System.out.println("낫싱");
        }
    }

    public void showEndingGuide() {
        String guide = "숫자 야구 게임을 종료합니다!\n" +
                "투수는 마운드에서 퇴장해주세요.\n" +
                "플레이 해주셔서 감사합니다!";
        System.out.println(guide);
    }
}
