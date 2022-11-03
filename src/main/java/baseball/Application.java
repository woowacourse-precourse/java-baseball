package baseball;

import java.util.ArrayList;
import java.util.HashSet;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    private static void CheckPlayerNumberValidation(ArrayList<Integer> playerNumberArray) {
        HashSet<Integer> playerNumberSet = new HashSet<>();

        // 집합에 게임 플레이어가 입력한 숫자를 넣는다.
        for (Integer playerNumber : playerNumberArray) {
            playerNumberSet.add(playerNumber);
        }

        // 집합의 크기가 3이 아니거나 숫자 0을 포함하면 예외를 발생한다.
        if (playerNumberSet.size() != 3 || playerNumberSet.contains(0)) {
            throw new IllegalArgumentException("세자리 수가 아니거나 중복되는 숫자 또는 0이 있음");
        }
    }

    private static ArrayList<Integer> getPlayerNumber() {
        
    }
}
