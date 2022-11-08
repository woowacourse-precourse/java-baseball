package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;
import java.util.HashSet;
import java.util.Scanner;
import static baseball.UserEnter.userEnterNum;

public class Application{
    public static void main(String[] args) {
//        기능1. 컴퓨터 숫자선정
        int randomNumber = 0;
        int restart = 1;

        System.out.println("숫자 야구 게임을 시작합니다.");
        do {
            List<Integer> computer = new ArrayList<>();
            while (computer.size() < 3) {
                randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
//                    System.out.print(randomNumber); //컴퓨터 입력값 출력
                }
            }
            System.out.println(computer);  //컴퓨터 입력값 리스트 출력

    //      기능2. 참가자 입력
            int strike = 0;
            List <Integer> user = new ArrayList<>();
            Set<Integer> userSet = new HashSet<>(user);;
            int strikeNball = 0;

            int ball = 0;
            int userNumber = 0;
            int attempt = 0;
            do {


                try {
                    userEnterNum();
                } catch (UserEnter.RedundantException re) {
                    System.err.println("에러메시지 : " + re.getMessage());
                    re.printStackTrace();
                } catch (UserEnter.SizeException se) {
                    System.err.println("에러메시지 : " + se.getMessage());
                    se.printStackTrace();
                } catch (UserEnter.NaturalException ne) {
                    System.err.println("에러메시지 : " + ne.getMessage());
                    ne.printStackTrace();
                }

    //      기능3. 결과값 비교
                int i = 0;
                int j = 0;

                for (i = 0; i < user.toArray().length; i++) {

                    for (j = 0; j < computer.toArray().length; j++) {
                        if (computer.get(i) - user.get(j) == 0) {
                            strikeNball = strikeNball + 1;
                        }
                    }
                    j = 0;
                }

                for (i = 0; i < user.toArray().length; i++) {
                    if (computer.get(i) == user.get(i)) {
                        strike = strike + 1;
                    }
                }
                ball = strikeNball - strike;

//                System.out.println("중복전체: " + strikeNball);     //strike + ball 중복 카운트
//                System.out.println("스트라이크: " + strike);        //strike 카운트
//                System.out.println("볼: " + ball);                //ball 카운트
                if (ball ==0 && 0 < strike) {
                    System.out.printf("%d스트라이크\n", strike);
                } else if(ball !=0&&strike == 0) {
                    System.out.printf("%d볼\n", ball);
                } else if(strike == 0 && ball == 0 ){
                        System.out.println("낫싱");
                } else{
                    System.out.printf("%d볼 %d스트라이크\n", ball, strike);
                }

            } while (strike < 3);

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 눌러주세요.");
            Scanner newgame = new Scanner(System.in);
            restart = newgame.nextInt();

        } while (restart < 2);

        System.out.println("게임 종료");

//        boolean compare = computer.get(0) == user.get(0);
//        System.out.println(compare);
//
//        System.out.println(userNumber.getClass().getSimpleName());
//
//        if (computer == user) {
//            System.out.println("True");
//        }


    }
}
