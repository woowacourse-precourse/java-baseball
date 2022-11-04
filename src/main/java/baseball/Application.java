package baseball;

import static org.assertj.core.api.Assertions.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.assertj.core.api.Assertions;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Scanner scanner = new Scanner(System.in);
        
        int nextProgress = 1;  //숫자 야구 게임을 재시작 또는 종료를 판단하는 변수
        while (nextProgress == 1) {
            System.out.println("숫자 야구 게임을 시작합니다.");

            List<Integer> computer = getRandomInteger();


        }
        System.out.println("게임 종료");
    }
    
    private static List<Integer> getRandomInteger() {
        List<Integer> result = new ArrayList<>();
        while (result.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            //서로 다른 3자리수를 저장
            if (!result.contains(randomNumber)) {
                result.add(randomNumber);
            }
        }
        return result;
    }

}
