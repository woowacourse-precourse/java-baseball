package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Player {

    public static void player3NumberInput() {
        List<Integer> player = new ArrayList<>();
        while (player.size() < 3) {
            System.out.print("숫자를 입력해주세요 : ");
            player.add(Integer.parseInt(Console.readLine()));
        }
    }
}

