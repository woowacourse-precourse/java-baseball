package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        if(!check_input(args)){
           // IllegalArgumentException
        }
        // TODO: 프로그램 구현
        List<String> computer = new ArrayList<>();
        while(computer.size()<3){
            int randomNumber = Randoms.pickNumberInRange(1,9);
            String str = String.valueOf(randomNumber);
            if(!computer.contains(str)){
                computer.add(str);
            }
        }
        int strike = 0;
        int ball = 0;
        System.out.println("숫자 야구 게임을 시작합니다.");
        System.out.println("computer = " + computer);
        strike = strike(args,computer);
        ball = ball(args,computer);
        print_score(strike,ball);
        System.out.println("게임을 종료합니다");
    }

    // 제대로 된 입력형식인지 확인하는 코드
    private static boolean check_input(String[] args) {
        // 입력 길이가 3인지 확인
        if(args.length != 3){
            return false;
        }
        //서로 다른 숫자를 입력받는지 확인
        if(args[0] == args[1] | args[0] == args[2] | args[1] == args[2]){
            return false;
        }
        return true;
    }

    public static int strike(String[] args, List<String> computer){
        int strike = 0;
        for(int i=0; i<3 ; i++){
            Character arg = args[0].charAt(i);
            String str = computer.get(i);
            Character ans = str.charAt(0);
//            System.out.println("arg = " + arg);
//            System.out.println("ans = " + ans);
            strike = isitstrike(arg,ans,strike);
        }

    //    System.out.println("strike = " + strike);
        return strike;
    }

    public static int isitstrike(Character arg, Character ans, int val){
        int strike = val;
        //System.out.println("isitstrike 실행");
        if(arg == ans){
            strike += 1;
        }
        return strike;
    }

    public static int ball(String[] args,List<String> computer){
        int ball = 0;
        //System.out.println("ball 실행");
        for(int idx=0 ; idx<3 ; idx++){
            Character arg = args[0].charAt(idx);
            if(computer.contains(arg)){
                ball = isitball(arg,computer,idx,ball);
            }
        }
        return ball;
    }

    public static int isitball(Character arg,List<String> computer, int idx, int ball){
        //System.out.println("isitball 실행");
        String str = computer.get(idx);
        Character chr = str.charAt(0);
        if(chr != arg){
         ball += 1;
        }
        return ball;
    }

    // 점수를 말해주는 메서드
    public static void print_score(int strike, int ball){
        if(strike == 0 & ball == 0){
            System.out.println("낫싱");
        } else if (strike == 0 & ball != 0) {
            System.out.println(ball + "볼");
        } else if (strike !=0 & ball ==0) {
            System.out.println(strike + "스트라이크");
        } else {
            System.out.println( ball +"볼 " + strike + "스트라이크 ");
        }
    }
}

