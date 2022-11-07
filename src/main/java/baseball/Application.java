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
        /*
        List<Integer> answer= new ArrayList<>();
        while(answer.size()<3) {
            int rand_num = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(rand_num))
                answer.add(rand_num);
        }
        return answer;
        */

        List<Integer> number_pool = new ArrayList<>(List.of(1,2,3,4,5,6,7,8,9));
        List<Integer> answer = new ArrayList<>();
        int pool_size = 8;
        while(answer.size()<3){
            int next_num_idx = Randoms.pickNumberInRange(0,pool_size);
            answer.add(number_pool.get(next_num_idx));
            number_pool.remove(next_num_idx);
            pool_size--;
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
            throw new IllegalArgumentException("잘못된 길이 입력");
        }
        int num1=input.get(0);
        int num2=input.get(1);
        int num3=input.get(2);
        if(num1==num2 || num2==num3 || num3==num1){
            throw new IllegalArgumentException("중복 숫자 입력");
        }
        if(num1==0 || num2==0 || num3==0){
            throw new IllegalArgumentException("범위에 벗어나는 숫자 : 0 입력");
        }
    }
    public static String how_many_correct(List<Integer>input, List<Integer> answer){
        int strike=0;
        int ball = 0;
        String  result_string = "";
        for(int i=0; i<3; ++i){
            Integer num = input.get(i);
            if(num == answer.get(i))
                strike++;
            else if(answer.contains(num))
                ball++;
        }
        if(ball>0)
            result_string+=String.format("%d볼 ",ball);
        if(strike>0)
            result_string += String.format("%d스트라이크",strike);
        if(result_string.length()==0)
            result_string = "낫싱";
        return result_string;
    }
    public static void one_game_start(){
        List<Integer> answer = make_rand_num();

        while(true){
            System.out.print("숫자를 입력해주세요 : ");
            List<Integer>input = number_input();
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
