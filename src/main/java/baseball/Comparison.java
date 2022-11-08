package baseball;

import static baseball.Random.computer;
import static baseball.User.player;
public class Comparison {
    static int strike = 0;
    static int strikeNball = 0;
    static int ball = 0;
    public static void comNuser() {
        strike = 0;
        strikeNball = 0;
        ball = 0;

        int i = 0;
        int j = 0;

        for(i =0; i<player.toArray().length;i++) {
            for (j = 0; j < computer.toArray().length; j++) {
                if (computer.get(i) - player.get(j) == 0) {
                    strikeNball = strikeNball + 1;
                }
            }
            j = 0;
        }
        for(i =0; i<player.toArray().length;i++) {
            if (computer.get(i) == player.get(i)) {
                strike = strike + 1;
            }
        }
        ball = strikeNball - strike;
            System.out.println("중복전체: " + strikeNball);     //strike + ball 중복 카운트
            System.out.println("스트라이크: " + strike);        //strike 카운트
            System.out.println("볼: " + ball);                //ball 카운트

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
    }
}

//
//    int i = 0;
//    int j = 0;
//
//
//                for (i = 0; i < user.toArray().length; i++) {
//
//        for (j = 0; j < computer.toArray().length; j++) {
//        if (computer.get(i) - user.get(j) == 0) {
//        strikeNball = strikeNball + 1;
//        }
//        }
//        j = 0;
//        }
//
//        for (i = 0; i < user.toArray().length; i++) {
//        if (computer.get(i) == user.get(i)) {
//        strike = strike + 1;
//        }
//        }
//        ball = strikeNball - strike;
//
////                System.out.println("중복전체: " + strikeNball);     //strike + ball 중복 카운트
////                System.out.println("스트라이크: " + strike);        //strike 카운트
////                System.out.println("볼: " + ball);                //ball 카운트
//        if (ball ==0 && 0 < strike && strike<3) {
//        System.out.printf("%d스트라이크\n", strike);
//        } else if(ball !=0&&strike == 0) {
//        System.out.printf("%d볼\n", ball);
//        } else if(strike == 0 && ball == 0 ){
//        System.out.println("낫싱");
//        } else if(strike == 3){
//        System.out.println("삼진아웃");
//        } else{
//        System.out.printf("%d볼 %d스트라이크\n", ball, strike);
//        }