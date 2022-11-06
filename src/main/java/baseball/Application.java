package baseball;

import java.util.*;

//camp.nextstep.edu.missionutils is provided by pre-course admin
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    static int strike, ball;
    public static void main(String[] args) {
        List<Integer> Computer = new ArrayList<>();
        List<Integer> User = new ArrayList<>();
        System.out.println("숫자 야구 게임을 시작합니다.");
        //if continue signal received, keep playing game
        while(Continue_or_End()){
            MakeAnswer(Computer);
            StartGame(User, Computer);
        }
    }

    private static void err_check(List<Integer> User){
        Set<Integer> set = new HashSet<>(User);
        if(set.size() != User.size()) 
            throw new IllegalArgumentException("각 자릿수는 서로 다른 숫자만 입력 가능합니다.");
        else if(User.contains(0))
             throw new IllegalArgumentException("1부터 9까지의 숫자만 입력 가능합니다.");
        else if(User.size() != 3) 
            throw new IllegalArgumentException("오직 세 자리의 숫자만 입력 가능합니다.");
    }

    private static void MakeAnswer(List<Integer> Computer){
        for(int i = 0; i < Computer.size(); i++){
            int number = Randoms.pickNumberInRange(1, 9);
            if(Computer.contains(number)) 
                i--;
            else Computer.add(number);
        }
    }

    private static void MakeUser(String UserInput, List<Integer> User){
        String []split_input = UserInput.split("");
        for(int i = 0; i < UserInput.length(); i++)
            User.add(Integer.parseInt(split_input[i]));
    }

    private static void StartGame(List<Integer> User, List<Integer> Computer){
        System.out.println("숫자를 입력해주세요 : ");
        String UserInput = Console.readLine();
        MakeUser(UserInput, User);
        //after read user's choice, check error of user's input
        err_check(User);
        //if input has no problem, compare three numbers
        Compare_Answer(User, Computer);
        Print_Result();
    }

    private static void Compare_Answer(List<Integer> User, List<Integer> Computer){
        //initialize in every game
        strike = 0, ball = 0;
        for(int idx = 0; idx < User.size(); idx++){
            //if computer's index equal as i(gradually), get strike
            if(Computer.indexOf(User.get(idx)) == idx) 
                strike++; 
            //if not strike but in it at other index, get ball
            else if(Computer.contains(User.get(idx))) 
                ball++;
        }
    }
    
    private static void Print_Result(){
        //it has both strike and ball
        if(strike != 0 && ball != 0)
            System.out.println(ball + "볼 " + strike + "스트라이크");
        //only ball(s)
        else if(strike == 0 && ball != 0)
            System.out.println(ball + "볼");
        //only strike(s)
        else if(strike != 0 && ball == 0)
            System.out.println(strike + "스트라이크");
        //neither strike nor ball
        else
            System.out.println("낫싱");
    }
}
