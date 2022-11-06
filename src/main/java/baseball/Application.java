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


    public static void main(String[] args) {
        // TODO: 프로그램 구현

    }

}
