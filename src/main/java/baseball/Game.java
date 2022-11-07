package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Game {

    public void start() {
        Computer computer = new Computer(new NumberGenerator());
        Referee referee = new Referee(new Rule());
        Player player = new Player();

        System.out.println(computer.getNumbers());

        computer.giveNumbersToReferee(referee);
        View.start();

        boolean helper = false;
        do {
            System.out.print("숫자를 입력하세요 : ");
            String readLine = Console.readLine();
            player.sayNumbers(readLine);
            player.giveNumbersToReferee(referee);

            ResponseView gameMessage = referee.answerNumber();
            helper = gameMessage.check();
        } while (!helper);
        {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String reStartNumber = Console.readLine();

            if (Integer.parseInt(reStartNumber) == 1) {
                restart();
            }
        }
    }

    private void restart() {
        start();
    }
}
