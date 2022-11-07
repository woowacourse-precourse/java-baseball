package baseball.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
public class GameService {
    private static final int BALL_NUMBERS = 3;
    public final static List<Integer> RANDOMBALL = new ArrayList<>();
    public static int strike = 0;
    public static List<Integer> userball = new ArrayList<>();
    public static void startOrder(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        GameService.makeRandomBall();
    }
    public static void inputOrder() {
        while(strike != 3){
            try {
                System.out.print("숫자를 입력해주세요 : ");
                String inputballnumber = Console.readLine();
                // 입력받은 수 확인 할 handler 필요
                userball = stringToObject(inputballnumber);
            } catch (IllegalArgumentException e){
                System.out.println("잘못된 입력입니다. 프로그램을 종료합니다.");
                break;
            }
        }
    }
    public static List<Integer> makeRandomBall(){
        while(RANDOMBALL.size()<BALL_NUMBERS){
            int number = 0;
            number = Randoms.pickNumberInRange(1,9);
            if(!RANDOMBALL.contains(number))   RANDOMBALL.add(number);
        }
        System.out.println(RANDOMBALL);
        return RANDOMBALL;
    }
    public static List<Integer> stringToObject(String inputball){
        List<Integer> usernumberdata = new ArrayList<>();
        String[] inputballarray = inputball.split("");

        for(int i=0; i<inputball.length(); i++){
            usernumberdata.add(Integer.valueOf(inputballarray[i]));
        }
        return usernumberdata;
    }
}