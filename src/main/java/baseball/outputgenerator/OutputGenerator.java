package baseball.outputgenerator;

import baseball.numbercomparator.Score;

/**
 * 컴퓨터의 난수 리스트와 사용자의 입력 리스트를 비교한 결과를 바탕으로 GameResult 클래스를 생성하는 기능을 담당하는 클래스입니다.
 */
public class OutputGenerator {

    /**
     * 게임 결과를 담은 클래스를 받아서 결과에 따른 게임 종료 여부와 출력 메시지를 반환하는 메서드입니다.
     * @param score 스트라이크 개수와 볼의 개수
     * @return 게임 종료 (3스트라이크) 여부와 출력 메시지를 담은 클래스
     */
    public static GameResult outputGenerator(Score score) {
        if (score.getStrike() == 3) {
            return new GameResult(true, "3스트라이크");
        }
        else if (score.getStrike() == 0 && score.getBall() == 0) {
            return new GameResult(false, "낫싱");
        }
        else if (score.getStrike() == 0) {
            return new GameResult(false, "" + score.getBall() + "볼");
        }
        else if (score.getBall() == 0) {
            return new GameResult(false, "" + score.getStrike() + "스트라이크");
        }
        else {
            return new GameResult(false, "" + score.getBall() + "볼 " + score.getStrike() + "스트라이크");
        }
    }
}
