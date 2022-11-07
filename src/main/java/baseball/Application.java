package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.CheckBall.ball;
import static baseball.CheckInput.make_error;
import static baseball.CheckStrike.strike;
import static baseball.GameController.gameController;
import static baseball.MakeComputerNumber.make_computer_number;
import static baseball.PrintScore.print_score;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
//        System.out.println("숫자 야구 게임을 시작합니다.");
//        List<String> computer = make_computer_number();
//        int strike = 0;
//        int ball = 0;
//        while (true){
//            System.out.println("숫자를 입력해주세요 : " );
//            String ans = Console.readLine();
//            if(ans.equals("1")){
//                computer = make_computer_number();
//                continue;
//            }else if(ans.equals("2")){
//                return;
//            }
//            else{
//            make_error(ans);
//            }
//            strike = strike(ans,computer);
//            ball = ball(ans,computer);
//            print_score(strike,ball);
//        }
        gameController();

    }

    // 제대로 된 입력형식인지 확인하는 코드
//    private static boolean check_input(String str) {
//        String[] num = {"0","1","2","3","4","5","6","7","8","9"};
//        List<String> nums = Arrays.asList(num);
//        int len = str.length();
//        for(int i= 0; i<len ; i++){
//            Character c = str.charAt(i);
//            String s = c.toString();
//            if(!nums.contains(s)){
//                return false;
//            }
//        }
//        if(len != 3){
//           if(str.equals("1") | str.equals("2")){
//               return true;
//           }else{
//                return false;}
//        }
//        else if(str.charAt(0) == str.charAt(1) | str.charAt(0) == str.charAt(2) | str.charAt(1) == str.charAt(2)){
//            return false;
//        }
//        else{
//        return true;}
//    }
//
//    public static void make_error(String ans){
//        try {
//            if(!check_input(ans)){
//                IllegalArgumentException e = new IllegalArgumentException();
//                throw new IllegalArgumentException();
//            }
//        }catch (IllegalArgumentException e){
//            throw new IllegalArgumentException();
//        }
//    }

//    public static List<String> make_computer_number(){
//        List<String> computer = new ArrayList<>();
//        while(computer.size()<3){
//            int randomNumber = Randoms.pickNumberInRange(1,9);
//            String str = String.valueOf(randomNumber);
//            if(!computer.contains(str)){
//                computer.add(str);
//            }
//        }
//        return computer;
//    }
//    public static int strike(String args, List<String> computer){
//        int strike = 0;
//        for(int i=0; i<3 ; i++){
//            Character arg = args.charAt(i);
//            String str = computer.get(i);
//            Character ans = str.charAt(0);
//            strike = isitstrike(arg,ans,strike);
//        }
//        return strike;
//    }
//
//    public static int isitstrike(Character arg, Character ans, int val){
//        int strike = val;
//        if(arg == ans){
//            strike += 1;
//        }
//        return strike;
//    }
//
//    public static int ball(String args,List<String> computer){
//        int ball = 0;
//        for(int idx=0 ; idx<3 ; idx++){
//            Character arg = args.charAt(idx);
//            String str = arg.toString();
//            if(computer.contains(str)){
//                ball = isitball(arg,computer,idx,ball);
//            }
//        }
//        return ball;
//    }
//
//    public static int isitball(Character arg,List<String> computer, int idx, int ball){
//        String str = computer.get(idx);
//        Character chr = str.charAt(0);
//        if(chr != arg){
//         ball += 1;
//        }
//        return ball;
//    }

    // 점수를 말해주는 메서드
//    public static void print_score(int strike, int ball){
//        if(strike == 3){
//            System.out.println("3스트라이크");
//            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
//            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
//        } else if(strike == 0 & ball == 0){
//            System.out.println("낫싱");
//        } else if (strike == 0 & ball != 0) {
//            System.out.println(ball + "볼");
//        } else if (strike !=0 & ball ==0) {
//            System.out.println(strike + "스트라이크");
//        } else {
//            System.out.println( ball +"볼 " + strike + "스트라이크 ");
//        }
//    }
}

