package baseball;


import baseball.compute.*;
import baseball.Player.*;
import camp.nextstep.edu.missionutils.Console;
import java.util.*;
import static baseball.compute.cycle.*;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {

    public static void main(String[] args) {
        game();

    }

    public static void game(){

        System.out.println("숫자 야구 게임을 시작합니다.");
        computer.isValiableAnswer();
        System.out.println("Answer:"+computer.Answer);

        while(true) {
            System.out.print("숫자를 입력해주세요 :");
            try {
                input in = new input();
                in.isValiableAnswer();


            compare c2 = new compare();

            c2.isStrike(computer.Answer, in.UserAnswer);
            c2.isBall(computer.Answer, in.UserAnswer);
            c2.isNothing();
            //c2.printStrike();
            //c2.printBall();
            //c2.printNothing();
            System.out.println(c2.PrintInfo());
            //System.out.println("User Answer:"+in.UserAnswer);
            if(c2.isfullStrike())  break;

            } catch (Exception e) {
                throw new IllegalArgumentException(e);
            }
        }

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

        Scanner sc = new Scanner(System.in);
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        cycle.restart(readLine());

    }
}
