package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        if (strike==3) {
            System.out.println(strike+"스트라이크");
            //프로그램 종료
        } else {
            if (matchCount==0) {
                System.out.println("낫싱");
            } else {
                int ball = matchCount - strike;
                System.out.println(ball+"볼 "+strike+"스트라이크");
            }
        }
    }
}
