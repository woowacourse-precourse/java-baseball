package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int i=1;
        int len=args.length;
        System.out.println("숫자 야구 게임을 시작합니다.");
        while(true) {

            one_game_start();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            if(isRegame())
                continue;
            break;

        }
    }
    public static List<Integer> make_rand_num(){
        List<Integer> answer= new ArrayList<>();
        while(answer.size()<3) {
            int rand_num = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(rand_num))
                answer.add(rand_num);
        }
        return answer;
    }
    public static List<Integer> number_input(){
        String[] string_input =  Console.readLine().split("");
        List<Integer> integer_input = new ArrayList<>();
        for(String str : string_input)
            integer_input.add(Integer.parseInt(str));
        return integer_input;
    }
    public static void input_test(List<Integer> input){
        if(input.size()!=3){
            throw(new IllegalArgumentException("잘못된 입력"));
        }
    }
    public static String how_many_correct(List<Integer>input, List<Integer> answer){
        int strike=0;
        int ball = 0;
        String  return_string = "";
        for(int i=0; i<3; ++i){
            Integer num = input.get(i);
            if(num == answer.get(i))
                strike++;
            else if(answer.contains(num))
                ball++;
        }
        if(ball>0)
            return_string+=String.format("%d볼 ",ball);
        if(strike>0)
            return_string += String.format("%d스트라이크",strike);
        if(return_string.length()==0)
            return_string = "낫싱";
        return return_string;
    }
    public static void one_game_start(){
        List<Integer> answer = make_rand_num();

       // answer = List.of( 5,8,9 );
        //System.out.println(answer);
        while(true){
            System.out.print("숫자를 입력해주세요 : ");
            List<Integer>input = number_input();
            //System.out.println(input);
            input_test(input);


            String result = how_many_correct(input, answer);
            System.out.println(result);
            if(result.equals("3스트라이크"))
                break;

        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
    public static boolean isRegame(){
        String isRestart = Console.readLine();
        if(isRestart.equals("1"))
            return true;
        else if(isRestart.equals("2"))
            return false;
        else
            throw(new IllegalArgumentException(isRestart));
    }
}
