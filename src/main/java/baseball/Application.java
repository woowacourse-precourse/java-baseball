package baseball;

import java.sql.SQLOutput;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        boolean restart = true;
        String reply;

        do {


            String numberComputer = Input.computer();
            System.out.println(numberComputer);
            boolean notThreeStrikes = true;

            do {
                String numberPlayer = Input.player();
                System.out.println(numberPlayer);
                Input.checkError(numberPlayer);



                PlayingBaseball round = new PlayingBaseball(numberComputer, numberPlayer);
                round.countStrikes();
                round.countBalls();
                round.printResult();
                notThreeStrikes = !round.has3Strikes();
            } while (notThreeStrikes);

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            reply = Console.readLine();

            if (reply.equals("2")) {
                restart = false;
            }
            System.out.println(reply);
            System.out.println(restart);


        } while (restart);
    }
    }
