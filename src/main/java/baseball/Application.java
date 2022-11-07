package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Application {

    static Scanner sc;
    static int strike, ball;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            // 점수 초기화
            init();

            // 게임 시작
            game();

            // 재시작?
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String started = sc.nextLine();

            if (started.equals("2")) {
                break; // 끝
            } else if (!started.equals("1")) { // 2도 아니고 1도 아니면 예외
                throw new IllegalArgumentException();
            }
        }
        sc.close();
    }
}

