package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args){
        while(true){
            int strike = 0;
            int ball = 0;

            System.out.println("숫자 야구 게임을 시작합니다.");

            // 1. 3자리 수 랜덤 생성 - Randoms의 pickNumberInRange()사용
            List<Integer> numbers = new ArrayList<>();
            while (numbers.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);

                // 각 수는 서로 다른 수
                if (!numbers.contains(randomNumber)) {
                    numbers.add(randomNumber);
                }
            }

            
        }
    }
}
