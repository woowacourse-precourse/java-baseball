package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Game {

    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public String receiveUserNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        return input;
    }

    public Integer controlGame(Result result) {
        if(result.getStrike()==3) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            Integer coin = Integer.valueOf(Console.readLine());

            return coin;
        }

        return 0;
    }
}
