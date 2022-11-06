package baseball;

import java.util.*;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    static List<Integer> make_rand_num(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
    static List<Integer> cut_the_number(int input_num){
        List<Integer> cut_one = new ArrayList<Integer>();
        int temp_num;
        while(input_num > 0){
            temp_num = input_num % 10;
            if(!cut_one.contains(temp_num)){
                cut_one.add(temp_num);
            }
            input_num = input_num / 10;
        }
        Collections.reverse(cut_one);
        if(cut_one.size()!=3){
            throw new IllegalArgumentException();
        }
        return cut_one;
    }

    static int input_your_num(){
        String input_str;
        int input_num = 000;

        System.out.print("숫자를 입력해주세요 : ");
        input_str = Console.readLine();
        // 입력이 비었을때 예외처리
        if (input_str.isBlank()) throw new IllegalArgumentException();
        try {
            input_num = Integer.parseInt(input_str);
            System.out.println(input_num);
        } catch (NumberFormatException ex) {
            //입력값이 숫자가 아닐때 예외처리
            throw new IllegalArgumentException();
        }
        return input_num;
    }

    static boolean check_answer(List<Integer>answer , List<Integer> input_num){
        int ball_cnt = 0;
        int strike_cnt = 0;
        ball_cnt = ball_count(answer,input_num);
        strike_cnt = strike_count(answer,input_num);
        ball_cnt = ball_cnt - strike_cnt;
        if(strike_cnt == 3){
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }else if(ball_cnt == 0 && strike_cnt == 0){
            System.out.println("낫싱");
            return false;
        }else{
            if(ball_cnt!=0){
                System.out.print(ball_cnt+"볼 ");
            }
            if(strike_cnt!=0){
                System.out.print(strike_cnt + "스트라이크");
            }
            System.out.print("\n");
            return false;
        }
    }

    static int ball_count(List<Integer> answer, List<Integer> input_num){
        int ball_cnt = 0;
        for(Iterator<Integer> i = input_num.iterator();i.hasNext();){
            if(answer.contains(i.next())) ball_cnt++;
        }
        return ball_cnt;
    }

    static int strike_count(List<Integer> answer, List<Integer> input_num){
        int strike_cnt = 0;
        for(int i =0;i < input_num.size();i++){
            if(answer.get(i) == input_num.get(i)) strike_cnt++;
        }
        return strike_cnt;
    }

    static void doing_baseball(List<Integer> answer){
        List<Integer> cut_by_one;
        boolean check_continue = false;
        int input_num= 000;

        System.out.println("숫자 야구 게임을 시작합니다.");
        try {
            while (!check_continue) {
                input_num = input_your_num();
                cut_by_one = cut_the_number(input_num);
                check_continue = check_answer(answer, cut_by_one);
            }
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException();
        }
    }
    static boolean check_again(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
        String input_str;
        input_str = Console.readLine();
        if (input_str.equals("1")){
            return true;
        }
        else{
            return false;
        }
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현

    }

}
