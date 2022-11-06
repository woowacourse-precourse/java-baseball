package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;


public class Application {
    static int three_strike = 0;
    static int first_game = 1;

    static void main_loop() {

    }

    static void check_to_restart() {

    }

    static void init_and_start_game() {
        three_strike = 0;

        if (first_game == 1) {
            System.out.println("숫자 야구 게임을 시작합니다.");
            first_game = 0;
        }
        main_loop();
        check_to_restart();
    }

    public static void main(String[] args) {
        init_and_start_game();
    }
}
