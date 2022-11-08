package baseball.exception;

import baseball.controller.Game;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseballException {

    public static void vaildNumArr(List<Integer> arrNums) {
        Set<Integer> setNums = new HashSet<>(arrNums);
        if (arrNums.size() != setNums.size()) {
            throw new IllegalArgumentException("각각 다른 숫자를 입력해 주십시오.");
        }
    }
    public static void vaildNum(int num){
        if (num < 100 || num > 999) {
            throw new IllegalArgumentException("3개의 숫자를 입력해 주십시오.");
        }
    }

    public static void vaildShutDownInput(int num){
        if (num==Game.getNewGameCode() || num==Game.getShutDownCode()) {
        } else {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }
}
