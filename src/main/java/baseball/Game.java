package baseball;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
    Map<String, Integer> ballAndStrike = new HashMap<>();

    User user;
    Computer computer;

    public void initGame() {
        user = new User();
        computer = new Computer();
        computer.setRandomNumber();
    }

    public void startGame() {
        while(true) {
            initGame();
            user.input();
            compareNumbers(computer.getRandomNumber(), user.getInputNumberList());
        }
    }

    // 두 수를 비교함.
    public Map compareNumbers(List computerNumber, List userNumber){
        int ballCount = 0, strikeCount = 0;
        for(int i = 0; i < userNumber.size(); i++) {
            if(userNumber.get(i) == computerNumber.get(i)) {
                ballAndStrike.put("strike", ++strikeCount);
            } else {
                ballAndStrike.put("ball", ++ballCount);
            }
        }
        return ballAndStrike;
    }
}
