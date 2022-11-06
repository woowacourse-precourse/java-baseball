package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<String> computer = make_computer_number();
        int strike = 0;
        int ball = 0;
        
        while (true){
            //System.out.println("computer = " + computer);
            System.out.println("숫자를 입력해주세요 : " );
            String ans = Console.readLine();
            if(ans.equals("1")){
                computer = make_computer_number();
                continue;
            }else if(ans.equals("2")){
                return;
            }
            else{
                try {
                if(!check_input(ans)){
                    IllegalArgumentException e = new IllegalArgumentException();
                    throw new IllegalArgumentException();
                }
            }catch (IllegalArgumentException e){
                    throw new IllegalArgumentException();
            }}
            strike = strike(ans,computer);
            ball = ball(ans,computer);
            print_score(strike,ball);
        }

    }

    // 제대로 된 입력형식인지 확인하는 코드
    private static boolean check_input(String str) {
        int len = str.length();
        // 입력 길이가 3인지 확인
        if(len != 3){
           if(str.equals("1") | str.equals("2")){
               return true;
           }else{
                return false;}
        }else if(str.charAt(0) == str.charAt(1) | str.charAt(0) == str.charAt(2) | str.charAt(1) == str.charAt(2)){
            return false;
        }else{
        return true;}
    }

    public static List<String> make_computer_number(){
        List<String> computer = new ArrayList<>();
        while(computer.size()<3){
            int randomNumber = Randoms.pickNumberInRange(1,9);
            String str = String.valueOf(randomNumber);
            if(!computer.contains(str)){
                computer.add(str);
            }
        }
        return computer;
    }
    public static int strike(String args, List<String> computer){
        int strike = 0;
        for(int i=0; i<3 ; i++){
            Character arg = args.charAt(i);
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

    public static int ball(String args,List<String> computer){
        int ball = 0;
        //System.out.println("ball 실행");
        for(int idx=0 ; idx<3 ; idx++){
            Character arg = args.charAt(idx);
            String str = arg.toString();
            if(computer.contains(str)){
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
        if(strike == 3){
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        } else if(strike == 0 & ball == 0){
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

