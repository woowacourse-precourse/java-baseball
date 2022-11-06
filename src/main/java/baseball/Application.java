package baseball;
import java.util.*;
//camp.nextstep.edu.missionutils is provided by pre-course admin
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
public class Application {
    static int strike, ball;
    private static final int BALL_COUNT = 3;
    public static void main(String[] args) {
        List<Integer> Computer = new ArrayList<>();
        List<Integer> User = new ArrayList<>();
        System.out.println("숫자 야구 게임을 시작합니다.");
        //if continue signal received, keep playing game
        do{
            Game(User, Computer);
        }
        while(Replay(Computer));
    }

    private static void err_check(String UserInput, List<Integer> User){
        if(UserInput.length() != 3)
            throw new IllegalArgumentException("오직 세 자리의 숫자만 입력 가능합니다.");
        Set<Integer> set = new HashSet<>(User);
        if(set.size() != User.size()) 
            throw new IllegalArgumentException("각 자릿수는 서로 다른 숫자만 입력 가능합니다.");
        else if(User.contains(0))
             throw new IllegalArgumentException("1부터 9까지의 숫자만 입력 가능합니다.");
        else if(User.size() != 3)
            throw new IllegalArgumentException("오직 세 자리의 숫자만 입력 가능합니다.");
    }

    private static void MakeAnswer(List<Integer> Computer){
        for(int i = 0; i < BALL_COUNT; i++){
            int number = Randoms.pickNumberInRange(1, 9);
            if(Computer.contains(number)) 
                i--;
            else Computer.add(number);
        }
    }

    private static void MakeUser(String UserInput, List<Integer> User){
        String []split_input = UserInput.split("");
        for(int i = 0; i < BALL_COUNT; i++)
            User.add(Integer.parseInt(split_input[i]));
        err_check(UserInput, User);
    }

    private static void Game(List<Integer> User, List<Integer> Computer){
        //init
        strike = 0;
        ball = 0;
        MakeAnswer(Computer);
        do{
            System.out.println("숫자를 입력해주세요 : ");
            String UserInput = Console.readLine();
            MakeUser(UserInput, User);
            //if input has no problem, compare three numbers
            Compare_Answer(User, Computer);
        }
        while(!All_Strikes());
    }

    private static void Compare_Answer(List<Integer> User, List<Integer> Computer){
        for(int idx = 0; idx < BALL_COUNT; idx++){
            //if computer's index equal as i(gradually), get strike
            if(Computer.indexOf(User.get(idx)) == idx) 
                strike++; 
            //if not strike but in it at other index, get ball
            else if(Computer.contains(User.get(idx))) 
                ball++;
        }
        Print_Result();
    }

    private static boolean All_Strikes(){
        if(strike == BALL_COUNT){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }

    private static boolean Replay(List<Integer> Computer){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String regame = Console.readLine();
        if(regame.equals("1"))
            return true;
        else if(regame.equals("2"))
            return false;
        //user select neither 1 nor 2
        else
            throw new IllegalArgumentException("1과 2만 선택할 수 있습니다.");
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