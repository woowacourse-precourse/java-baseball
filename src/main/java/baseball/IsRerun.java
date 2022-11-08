package baseball;

import java.util.List;

public class IsRerun {
    public boolean isFalse(boolean gameStatus, List<Integer> countStrBallList) {
        //게임 진행 판단
        if (countStrBallList.get(1) == 3) {
            System.out.println("3개의 숫자를 모두 맞히였습니다! 게임 종료");
            gameStatus = false;
        } else {
            gameStatus = gameStatus;
        }

        return gameStatus;
    }
}

