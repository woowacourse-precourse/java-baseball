package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        boolean restartIsYes;
        String coin;

        do {

            String numberComputer = Input.computer();
            System.out.println(numberComputer);
            boolean notThreeStrikes = true;

            do {
                String numberPlayer = Input.player();
                System.out.println(numberPlayer);

                PlayingBaseball round = new PlayingBaseball(numberComputer, numberPlayer);
                System.out.println(round.countStrikes());
                System.out.println(round.countBalls());
                round.printResult();
                notThreeStrikes = !round.has3Strikes();
            } while (notThreeStrikes);

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            coin = Console.readLine();
            if (coin == "1") {
                restartIsYes = true;
            }
            if (coin == "2") {
                restartIsYes = false;
            }

        } while (restartIsYes)
    }
}
