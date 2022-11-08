package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        boolean restart = true;

        do {


            String numberComputer = Input.computer();
            boolean notThreeStrikes = true;
            boolean flag;

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
                Restart reply = new Restart();
                restart = reply.decide();
                flag = reply.isValid();
            } while (!flag);



        } while (restart);
    }


}
