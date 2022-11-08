package baseball.service;

import java.util.LinkedList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberListGenerator {

    public static List<Integer> generate(){
        List<Integer> answer = new LinkedList<>();
        while(answer.size() < 3){
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!answer.contains(randomNumber)){
                answer.add(randomNumber);
            }
        }
        return answer;
    }
}
