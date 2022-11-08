package baseball.service;

import camp.nextstep.edu.missionutils.Console;

import java.io.IOException;

public class Ending {
    public static boolean endGame() throws IOException {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String input = Console.readLine();
        if(input.equals("1")){
            return true;
        }else if(input.equals("2")){
            return false;
        }else return endGame();
    }
}
