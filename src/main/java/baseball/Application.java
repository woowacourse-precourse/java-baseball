package baseball;

import java.awt.*;
import java.util.List;
import java.util.Scanner;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        Game g = new Game();
        int state = 0;
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (state != 2) {
            List<Integer> answer = g.createNumber();
            state = g.gameStart(answer);
            if (state == 1)
                continue;
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                    "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            state = Integer.parseInt(Console.readLine());
        }
    }
}
