package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<String> computer = new ArrayList<>();
        while(computer.size() <3){
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if(!computer.contains(randomNumber)){
                computer.add(String.valueOf(randomNumber));
            }
        }
        int strike = 0;
        int ball = 0;
        System.out.println("숫자 야구 게임을 시작합니다.");
        System.out.println("args 개수 = " + args.length);
        System.out.println("computer = " + computer);
        System.out.println(args[0]);
        System.out.println(args[0].charAt(1));
        strike = strike(args,computer);
        ball = ball(args,computer);
        print_score(strike,ball);
        System.out.println("게임을 종료합니다");
    }

    public static int strike(String[] args, List<String> computer){
        int strike = 0;
        for(int i=0; i<3 ; i++){
            Character arg = args[0].charAt(i);
            Character ans = computer.get(i).charAt(i);
            System.out.println("arg = " + arg);
            System.out.println("ans = " + ans);
            strike = isitstrike(arg,ans,strike);
        }
        return strike;
    }

    public static int isitstrike(Character arg, Character ans, int strike){
        if(arg == ans){
            strike += 1;
        }
        return strike;
    }

    public static int ball(String[] args,List<String> computer){
        int ball = 0;
        for(int idx=0 ; idx<3 ; idx++){
            Character arg = args[0].charAt(idx);
            if(computer.contains(arg)){
                ball = isitball(arg,computer,idx,ball);
            }
        }
        return ball;
    }

    public static int isitball(Character arg,List<String> computer, int idx, int ball){
        if(computer.get(0).charAt(idx) != arg){
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

