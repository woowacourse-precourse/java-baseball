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

public class Application {
    public static void main(String[] args) {
//        기능1. 컴퓨터 숫자선정
        int randomNumber = 0;
        int restart = 1;
        System.out.println("숫자 야구 게임을 시작합니다.");
        do {
            int strikeNball = 0;
            int strike = 0;
            int ball = 0;
            int userNumber = 0;

            List<Integer> computer = new ArrayList<>();
            while (computer.size() < 3) {
                randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                    System.out.print(randomNumber);
                }
            }

    //      기능2. 참가자 입력

            do {
                strikeNball = 0;
                strike = 0;
                ball = 0;
                userNumber = 0;

                System.out.print("\n숫자를 입력해주세요: ");

                userNumber = Integer.parseInt(Console.readLine());

                int[] digits = Stream.of(String.valueOf(userNumber).split("")).mapToInt(Integer::parseInt).toArray();

                List<Integer> user = new ArrayList<>();

                for (int order = 0; order < digits.length; order++) {
                    user.add(digits[order]);
                }
                Set<Integer> userSet = new HashSet<>(user);

                System.out.println("computer: " + computer);  //컴퓨터 출력물 분석용
                System.out.println("user: " + user);  // 유저 입력값 분석용
                System.out.println(userNumber); // 유저 입력값 확인용


                if (userSet.size() != user.size()) {
                    throw new IllegalArgumentException("중복되는 숫자를 입력할 수 없습니다.");
                }
                if (user.size() != 3) {
                    throw new IllegalArgumentException("숫자 세개를 입력해주세요.");
                }
                if (user.contains(0)) {
                    throw new IllegalArgumentException("1~9 사이의 숫자를 입력하셔야 합니다.");
                }
    //        if (userNumber/100==0 || (userNumber/10)%10==0 || userNumber%10==0) {
    //            throw new IllegalArgumentException("0을 입력할 수 없습니다.");
    //        }

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

                System.out.println("중복전체: " + strikeNball);
                System.out.println("스트라이크: " + strike);
                System.out.println("볼: " + ball);
                if (ball ==0 && 0 < strike && strike<3) {
                    System.out.printf("%d스트라이크\n", strike);
                } else if(ball !=0&&strike == 0) {
                    System.out.printf("%d볼\n", ball);
                } else if(strike == 0 && ball == 0 ){
                        System.out.println("낫싱");
                } else if(strike == 3){
                    System.out.println("삼진아웃");
                } else{
                    System.out.printf("%d볼 %d스트라이크\n", ball, strike);
                }

            } while (strike < 3);

            System.out.println("3개의 숫자를 모두 맞히셨습니다.");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 눌러주세요.");
            Scanner newgame = new Scanner(System.in);
            restart = newgame.nextInt();

        } while (restart < 2);

        System.out.println("숫자야구게임을 완전히 종료하겠습니다.");

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
