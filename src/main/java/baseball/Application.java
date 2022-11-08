package baseball;

import java.util.HashMap;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");

    }
    public static void checkException(int num){
        String numString = Integer.toString(num);
        if (numString.length() != 3){
            throw new IllegalArgumentException();
        }
        if (numString.contains("0")){
            throw new IllegalArgumentException();
        }
        if (!containSameNumber(numString)){
            throw new IllegalArgumentException();
        }
    }
}
