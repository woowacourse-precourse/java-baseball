package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static List<Integer> randomNumber;
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        StartGame();
    }

    public static void StartGame(){
        GetRandomNumber();
    }

    public static void GetRandomNumber(){
        randomNumber = new ArrayList<>();
        while (randomNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!Application.randomNumber.contains(randomNumber)) {
                Application.randomNumber.add(randomNumber);
            }
        }
    }
}
