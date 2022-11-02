package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Game {
    private List<Integer> computer_answer;
    private int currentBall;
    private int currentStrike;

    public void init() {
        computer_answer = new ArrayList<>();
        while (computer_answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer_answer.contains(randomNumber)) {
                computer_answer.add(randomNumber);
            }   
        }
        currentBall = 0;
        currentStrike = 0;
    }

    public void compare_player_input_and_answer(int playerNum) {
        
    }

    public int get_strike() {
        return 0;
    }

    public int get_ball() {
        return 0;
    }

}
