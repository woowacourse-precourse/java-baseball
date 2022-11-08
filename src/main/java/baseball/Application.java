package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        gameStart();
    }

    // 게임 시작
    public static void gameStart() {
        int[] computerNumbers = getRandomNumbers();
        int[] userNumbers = getUserNumbers();
        compareNumbers(computerNumbers, userNumbers);
    }
}
