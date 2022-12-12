package Controller;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static Views.InputView.INPUT_VIEW;

public class GameController {
    public static final GameController GAME_CONTROLLER = new GameController();

    public List<Integer> GetUserNumber() {
        List<Integer> user = new ArrayList<>();
        int i = 0;
        String userRandomNumber = INPUT_VIEW.InputUserNumber(Console.readLine());
        while (user.size() < 3) {
            if (!user.contains(userRandomNumber.substring(i, i + 1))) {
                user.add(Integer.parseInt(userRandomNumber.substring(i, i + 1)));
                i++;
            }
        }
        return user;
    }

    public List<Integer> GetEnemyNumber() {
        List<Integer> enemy = new ArrayList<>();
        while (enemy.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!enemy.contains(randomNumber)) {
                enemy.add(randomNumber);
            }
        }
        return enemy;
    }

    public Map<String, Integer> GetStrikeAndBall(List<Integer> user, List<Integer> enemy) {
        Map<String, Integer> result = new HashMap<>();
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            if ((int) user.get(i) == enemy.get(i)) {
                strike++;
            } else if (enemy.contains(user.get(i))) {
                ball++;
            }
        }
        result.put("strike", strike);
        result.put("ball", ball);
        return result;
    }
}
