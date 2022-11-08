package baseball.Domain;

import java.util.ArrayList;
import java.util.List;

import static baseball.Domain.NumberGenerator.GAME_NUM_LENGTH;

public class Hint {

    private final int STRIKE = 0;
    private final int BALL = 1;

    private List<Integer> GameResult = new ArrayList<>();

    public int getStrikeCount() {
        return GameResult.get(STRIKE);
    }

    public int getBallCount() {
        return GameResult.get(BALL);
    }

    public boolean getIsAnswer() {
        return getStrikeCount() == GAME_NUM_LENGTH;
    }

    public void printResult() {
        if (getStrikeCount() == 0 && getBallCount() == 0) {
            System.out.println("낫싱");
        }
        if (getBallCount() != 0) {
            System.out.print(getBallCount() + "볼 ");
        }
        if (getStrikeCount() != 0) {
            System.out.print(getStrikeCount() + "스트라이크 ");
        }
        System.out.println();
    }

    public void printEndMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }


    public List<Integer> getGameResult() {
        return GameResult;
    }

    public void setGameResult(List<Integer> gameResult) {
        GameResult = gameResult;
    }


}