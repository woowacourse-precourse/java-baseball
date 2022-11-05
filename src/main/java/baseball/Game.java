package baseball;


import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {
    List<Integer> answer;

    public Game(){
        List<Integer> pool = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
        answer = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            int pick = Randoms.pickNumberInList(pool);

            answer.add(pick);

            pool.remove(pick - 1);
        }
    }

    public List<Integer> getAnswer(){
        return answer;
    }
}
