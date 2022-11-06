package baseball;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        Coin coin = new Coin();
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (coin.isCoin()) {
            Computer computer = new Computer();

            game(computer.getComputer());

            coin = inputCoin();
        }
    }

    private static void game(List<Integer> computer) {
        boolean isThreeStrike = false;

        while (!isThreeStrike) {
            System.out.print("숫자를 입력해주세요 : ");
            List<Integer> user = new Users(readLine()).getInputList();

            BaseballReferee baseballReferee = new BaseballReferee(computer, user);

            isThreeStrike = baseballReferee.isThreeStrike();
        }
    }

    private static Coin inputCoin() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        Coin coin = new Coin(readLine());
        return coin;
    }
}
