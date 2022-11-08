package baseball;

import java.util.ArrayList;
import java.util.List;

public class Application {

    // 기능 목록 1 : 숫자 야구 게임 시작 문구 생성
    static List<Integer> startMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        return makeThreeNumber();
    }

    // 기능 목록 2 : 1부터 9까지의 랜덤한 값 생성
    static int randomValue() {
        Random random = new Random();
        return random.nextInt(9) + 1;
    }
    

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        startMessage();
        List<Integer> computerNumber = makeThreeNumber();


    }
}