package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        boolean restart = true;
        String reply;

        do {


            String numberComputer = Input.computer();
            boolean notThreeStrikes = true;

            do {
                String numberPlayer = Input.player();
                Input.checkError(numberPlayer);



                PlayBaseball round = new PlayBaseball(numberComputer, numberPlayer);
                round.countStrikes();
                round.countBalls();
                round.printResult();
                notThreeStrikes = !round.has3Strikes();
            } while (notThreeStrikes);

            do {
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                reply = Console.readLine();

                if (reply.equals("1")) {
                    restart = true;
                    continue;
                }
                if (reply.equals("2")) {
                    restart = false;
                    continue;
                }
                System.out.println("입력값이 유효하지 않습니다. 다시 입력해주십시오");
            } while (!reply.equals("1") && !reply.equals("2"));

        } while (restart);
    }
}
