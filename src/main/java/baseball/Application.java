package baseball;
import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        int game = 1;
        do{
            List<Integer> computer = Settings.makeNumber();
            Play.playGame(computer);
            System.out.println("게임을 새로 시작하려면 1, 게임을 종료하려면 2를 입력하세요. ");
            game = Integer.parseInt(Console.readLine());
            game = Settings.restartExcetion(game);
        } while(game==1);
    }
}
