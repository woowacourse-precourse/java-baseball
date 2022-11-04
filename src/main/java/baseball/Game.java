package baseball;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
    private List<Integer> computerNumber = new ArrayList<>();
    private List<Integer> userNumber = new ArrayList<>();

    Map<String, Integer> ballAndStrike = new HashMap<>();

    // 두 수를 비교함.
    public Map compareNumbers(){
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
