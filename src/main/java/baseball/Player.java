package baseball;

import static baseball.Computer.NUM_LIMIT_LENGTH;

import java.util.ArrayList;
import java.util.List;

public class Player {

    public static List<Integer> toIntegerPlayerInput(String playerInput) {
        if (playerInput.isEmpty()) {
            throw new IllegalArgumentException("값을 입력하지 않았습니다. 3자리 숫자를 입력해주세요.");
        }
        List<Integer> playerInputNumber = new ArrayList<>(NUM_LIMIT_LENGTH);
        String[] playerInputArr = playerInput.split("");
        for (String str : playerInputArr) {
            playerInputNumber.add(Integer.parseInt(str));
        }
        return playerInputNumber;
    }
}
