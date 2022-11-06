package baseball;

import java.util.List;

// 숫자 야구 게임 관리
public class NumberBaseballGameServer {

    private static final int GAME_NUMBER_RANGE_MAX = 9;
    private static final int GAME_NUMBER_RANGE_MIN = 1;
    private static final int COUNT_GAME_NUMBER = 3;
    private int gameNumber;

    public void run() {
        // 게임의 흐름과 순서 관리
    }

    public List<Integer> makeNewGameNumber() {
        // 게임 숫자(1부터 9까지 서로 다른 수로 이루어진 3자리의 숫자) 생성
        return List.of();
    }

    public NumberBaseballGameJudgedResultDto judgeInputNumber(int inputNumber) {
        // 플레이어가 입력한 숫자를 받아 이에 대한 판별
        return new NumberBaseballGameJudgedResultDto();
    }
}
