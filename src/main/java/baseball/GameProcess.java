package baseball;

import java.util.List;

public class GameProcess {

    // 게임 최초 시작
    public static void newStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        start();
    }

    // 게임 시작
    public static void start() {
        // 랜덤수 생성
        List<Integer> randomNum = RandomNum.generate();

        System.out.print("숫자를 입력해주세요 : ");
    }

}
