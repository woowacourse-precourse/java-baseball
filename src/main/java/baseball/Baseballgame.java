package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static camp.nextstep.edu.missionutils.Console.*;

public class Baseballgame {

    private static final String CONTINUE = "1";
    private static final String QUIT = "2";

    public Baseballgame() {
    }
    public void play() {
        do {
            game();
        } while (reGame());
    }

    public void game() {
        Balls comBalls;
        Result result;

        }


    private Boolean reGame() {
        String input = "";

        return input.equals(CONTINUE);
    }

    private void printUserInputMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    private void printFormatExceptionMessage() {
        System.out.printf("%d개의 1~9 사이의 중복되지 않는 수만 입력할 수 있습니다.%n");
    }

    private void printCheckRestartExceptionMessage() {
        System.out.println("1, 2만 입력 가능합니다. 다시 입력해주세요.");
    }

    private void printCheckRestartMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }




}
