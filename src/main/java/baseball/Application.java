package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Scanner;

public class Application {
    int randomNumber = 0;
    public static void main(String[] args) {
//        기능1. 컴퓨터 숫자선정

        int restart = 1;
        Random random = new Random();   //Random numbers output;
        User user = new User();         //User numbers output;
        Exceptions exceptions = new Exceptions();   //Exceptions check;
        Comparison comparison = new Comparison();       //random and user comparison;

        System.out.println("숫자 야구 게임을 시작합니다.");

        do {
            random.randomNum();

            do {
                try {
                    User.enterNum();

                    exceptions.exceptionTest();

                } catch (Exceptions.RedundantException re) {
                    System.err.println("에러메시지 : " + re.getMessage());
                    re.printStackTrace();
                } catch (Exceptions.SizeException se) {
                    System.err.println("에러메시지 : " + se.getMessage());
                    se.printStackTrace();
                } catch (Exceptions.NaturalException ne) {
                    System.err.println("에러메시지 : " + ne.getMessage());
                    ne.printStackTrace();
                }
                Comparison.comNuser();
            } while (Comparison.strike < 3);

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 눌러주세요.");
            Scanner newgame = new Scanner(System.in);
            restart = Integer.parseInt(Console.readLine());
        }while (restart<2);
//        System.out.println("게임 종료");
    }
}
