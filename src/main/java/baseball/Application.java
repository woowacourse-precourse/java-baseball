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
    int randomNumber = 0;
    public static void main(String[] args) {
//        기능1. 컴퓨터 숫자선정

        int restart = 1;
        Random random = new Random();

        System.out.println("숫자 야구 게임을 시작합니다.");
        random.randomNum();
//        do {
//
//
//            //      기능2. 참가자 입력
//            List<Integer> user = new ArrayList<>();
//            Set<Integer> userSet = new HashSet<>(user);
//            ;
//            int strike = 0;
//
//            int strikeNball = 0;
//
//            int ball = 0;
//            int userNumber = 0;
//            do {
//                try {
//                    userEnterNum();
//                    System.out.println(user);       //유저 입력값
//                } catch (UserEnter.RedundantException re) {
//                    System.err.println("에러메시지 : " + re.getMessage());
//                    re.printStackTrace();
//                } catch (UserEnter.SizeException se) {
//                    System.err.println("에러메시지 : " + se.getMessage());
//                    se.printStackTrace();
//                } catch (UserEnter.NaturalException ne) {
//                    System.err.println("에러메시지 : " + ne.getMessage());
//                    ne.printStackTrace();
//                }
//
//                //      기능3. 결과값 비교
//
//
//
//            } while (strike < 3);
//
//            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 눌러주세요.");
//            Scanner newgame = new Scanner(System.in);
//            restart = newgame.nextInt();
//
//        } while (restart < 2);
//
//        System.out.println("게임 종료");
//
//    }
//
//
//    class Comparison {
//        int i = 0;
//        int j = 0;
//
//                for (i = 0; i < user.toArray().length; i++) {
//
//            for (j = 0; j < computer.toArray().length; j++) {
//                if (computer.get(i) - user.get(j) == 0) {
//                    strikeNball = strikeNball + 1;
//                }
//            }
//            j = 0;
//        }
//
//                for (i = 0; i < user.toArray().length; i++) {
//            if (computer.get(i) == user.get(i)) {
//                strike = strike + 1;
//            }
//        }
//
//        int strikeNball = 0;
//        int strike = 0;
//        int ball = 0;
//        ball = strikeNball - strike;
//
////                System.out.println("중복전체: " + strikeNball);     //strike + ball 중복 카운트
////                System.out.println("스트라이크: " + strike);        //strike 카운트
////                System.out.println("볼: " + ball);                //ball 카운트
//                if (ball == 0 && 0 < strike) {
//            System.out.printf("%d스트라이크\n", strike);
//        } else if (ball != 0 && strike == 0) {
//            System.out.printf("%d볼\n", ball);
//        } else if (strike == 0 && ball == 0) {
//            System.out.println("낫싱");
//        } else {
//            System.out.printf("%d볼 %d스트라이크\n", ball, strike);
//        }
//    }
//    class User {
//        List <Integer> user = new ArrayList<>();
//
//        public void enterNum() {
//            int userNumber = 0;
//            System.out.println("숫자를 입력해주세요: ");
//            userNumber =Integer.parseInt(Console.readLine());
//
//            int[] digits = Stream.of(String.valueOf(userNumber).split("")).mapToInt(Integer::parseInt).toArray();
//            user = new ArrayList<>();
//        }
//    }
//
//    public static void userEnterNum() throws RedundantException, SizeException, NaturalException {
//    List <Integer> user = new ArrayList<>();
//    Set<Integer> userSet;
//
//
//
//
//    int userNumber = 0;
//
//
//
//    System.out.println("숫자를 입력해주세요: ");
//    userNumber =Integer.parseInt(Console.readLine());
//
//    int[] digits = Stream.of(String.valueOf(userNumber).split("")).mapToInt(Integer::parseInt).toArray();
//    user = new ArrayList<>();
//    for(int order = 0;order<digits.length;order++) {
//        user.add(digits[order]);
//    }
//    userSet = new HashSet<>(user);
//
//    if (userSet.size() != user.size()) {
//        throw new RedundantException("중복되는 숫자를 입력할 수 없습니다.");
//    }
//    if (user.size() != 3) {
//        throw new SizeException("숫자 세개를 입력해야 합니다.");
//    }
//    if (user.contains(0)) {
//        throw new NaturalException("1~9 사이의 숫자를 입력해야 합니다.");
//    }
//    }
//    static class RedundantException extends Exception {
//        RedundantException(String redundant) {
//            super(redundant);
//        }
//    }
//
//    static class SizeException extends Exception {
//        SizeException(String size) {
//            super(size);
//        }
//    }
//
//    static class NaturalException extends Exception {
//        NaturalException(String natural) {
//            super(natural);
//        }
    }
}
