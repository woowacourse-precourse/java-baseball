package baseball;

import java.util.ArrayList;
import java.util.Collections;
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
        currentBall = 0;
        currentStrike = 0;
        List<Integer> player_list = new ArrayList<>();
        int_to_list(playerNum, player_list);
        compare_list_and_answer(player_list);
    }

    private void compare_list_and_answer(List<Integer> player_list) {
        for(int i =0;i<3;i++)
        {
            if(player_list.get(i) == computer_answer.get(i))
                currentStrike++;
            
            else if(computer_answer.contains(player_list.get(i)))
                currentBall++;
            
        }
    }

    private void int_to_list(int playerNum, List<Integer> player_list) {
        int num = playerNum;

        while(num > 0) {
            player_list.add(num %10);
            num /= 10;
        }

        Collections.reverse(player_list);
    }

    public int get_strike() {
        return currentStrike;
    }

    public int get_ball() {
        return currentBall;
    }

}
