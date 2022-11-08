package baseball;

import static baseball.User.*;

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
        random.randomNum();

        try {
            User.enterNum();

            System.out.println(User.player);       //유저 입력값
            System.out.println(playerNumber);       //유저 비교값

            System.out.println(userSet.size());
            System.out.println(player.size());

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
    }
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

//    }
//


}
