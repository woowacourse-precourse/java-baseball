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
        strike = strike(args,computer);
        ball = ball(args,computer);
        print_score(strike,ball);
    }

    /***
     * 스트라이크 카운트 해주는 메서드
     * 글자를 뽑아서 받은후 같은지 비교해주는 메서드 isitsame 존재 ( 스트라이크를 인자로 받아줌)
     * */
    public static int strike(String[] args, List<String> computer){
        int strike = 0;
        for(int i=0; i<3 ; i++){
            String arg = args[i];
            String ans = computer.get(i);
            isitstrike(arg,ans,strike);
        }
        return strike;
    }

    public static int isitstrike(String arg, String ans, int strike){
        if(arg == ans){
            strike += 1;
        }
        return strike;
    }

    /***
     * 볼을 카운트 해주는 메서드. 스트라이크와 비슷하지만 isitsame과 다르게 자릿수가 다른 같은 숫자가 존재할 때만
     * 볼 카운트를 올려준다.
     * contains 로 포함하고 있으면 isitball을 실행한다.
     * 뽑은 글자와 idx를 넘겨주고 answer의 idx가 그 글자와 달라야 한다!
     **/
    public static int ball(String[] args,List<String> computer){
        int ball = 0;
        for(int idx=0 ; idx<3 ; idx++){
            String arg = args[idx];
            if(computer.contains(arg)){
                isitball(arg,computer,idx,ball);
            }
        }
        return ball;
    }

    public static int isitball(String arg,List<String> computer, int idx, int ball){
        if(computer.get(idx) != arg){
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

