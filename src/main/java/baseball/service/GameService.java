package baseball.service;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
public class GameService {
    private static final int BALL_NUMBERS = 3;

    public static void startOrder(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        System.out.println(GameService.makeRandomBall());
    }
    public static void inputOrder() {
        System.out.print("숫자를 입력해주세요 : ");
    }

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