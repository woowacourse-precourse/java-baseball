package baseball;


import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static List<Integer> PickRandomNumber(){
        List<Integer> Number =
                new ArrayList<>();
        while (Number.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!Number.contains(randomNumber)) {
                Number.add(randomNumber);
            }
        }
        return Number;
    }
    public static int[] InputNumber(String num){
        int ch[] = new int[3];
        int choice = Integer.parseInt(num);
        for(int j = 2;j>=0;j--){
            ch[j] = choice%10;
            choice = choice/10;
        }
        return ch;
    }
    public static void main(String[] args) {
        List<Integer> RandomNumber = PickRandomNumber();
        System.out.println(RandomNumber);
        System.out.println("숫자야구게임을 시작합니다.");
        System.out.println("숫자를 입력해주세요");
        String num = Console.readLine();
        if (num.length() == 3) {
            int UserChoiceNum[] = InputNumber(num);
        } else {
            System.out.println("세자리수만 입력가능합니다");
        }



    }
}
