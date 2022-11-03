package baseball;

import java.util.ArrayList;
import java.util.HashSet;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    private static Boolean CheckPlayerNumberValidation(ArrayList<Integer> playerNumberArray) {
        HashSet<Integer> playerNumberSet = new HashSet<>();

        // 집합에 게임 플레이어가 입력한 숫자를 넣는다.
        for (Integer playerNumber : playerNumberArray) {
            playerNumberSet.add(playerNumber);
        }
    }
}
