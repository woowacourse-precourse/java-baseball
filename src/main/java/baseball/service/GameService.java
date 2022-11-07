package baseball.service;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
public class GameService {
    private static final int BALL_NUMBERS = 3;

    //Todo
    // 랜덤값 1개씩 입력받고 List 변수에 넣으면서
    // 중복확인 + 3자리인지 확인 후 return
    // view -> GameService 쪽으로 refactor
    public static List<Integer> makeRandomBall(){
        List<Integer> randomballs = new ArrayList<>();

        while(randomballs.size()<BALL_NUMBERS){
            int number = 0;
            number = Randoms.pickNumberInRange(1,9);
            if(!randomballs.contains(number))   randomballs.add(number);
        }
        return randomballs;
    }
}