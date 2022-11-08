package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        final String YES = "1";
        final String NO = "2";
        boolean restart = true;
        String restartReply;

        do {


            String numberComputer = Input.computer();
            boolean notThreeStrikes = true;

            do {
                String numberPlayer = Input.player();
                Input.checkError(numberPlayer);



                PlayBaseball game = new PlayBaseball(numberComputer, numberPlayer);
                game.countStrikes();
                game.countBalls();
                game.printResult();
                notThreeStrikes = !game.has3Strikes();
            } while (notThreeStrikes);

            do {
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                restartReply = Console.readLine();

                if (restartReply.equals(YES)) {
                    restart = true;
                    continue;
                }
                if (restartReply.equals(NO)) {
                    restart = false;
                    continue;
                }
                System.out.println("입력값이 유효하지 않습니다. 다시 입력해주십시오");
            } while (!restartReply.equals(YES) && !restartReply.equals(NO));

        } while (restart);
    }


}
