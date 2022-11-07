package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameView {


    public static void startGame() {
        // TODO: 프로그램 구현
        createRandomNumber();

    }

    public static List createRandomNumber() {  // 리스트 형태로 수 생성
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
//        System.out.println("랜덤 수 생성"+computer);
        return computer;
    }
}
