package baseball;

import java.util.Scanner;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            //try {
                Game game = new Game();
                if (game.routine()) {
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    int num = Integer.parseInt(readLine());
                    if (num == 1)
                        continue;
                    else if (num == 2)
                        break;
                }
            //} catch (IllegalArgumentException e) {
                //System.out.println(e);
//                return ;
            //}
        }
    }
}
