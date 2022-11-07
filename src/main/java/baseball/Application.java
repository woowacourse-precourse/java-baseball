package baseball;

import baseball.Computer.Com;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Application extends Com{
    public static int[] GoAndStop(String num,int[] UserChoiceNum){
        if (num.length() == 3) {
            UserChoiceNum = Com.InputNumber(num);
        }
        if (num.length() != 3) {
            throw new IllegalArgumentException(String.format("3자리수만입력가능합니다"));
        }
        return UserChoiceNum;
    }
    public static void main(String[] args) {
        System.out.println("게임을 시작합니다,");
        List<Integer> RandomNumber = new ArrayList<>();
        //RandomNumber = PickRandomNumber();
        RandomNumber = Com.PickRandomNumber();
        System.out.println(RandomNumber);
        User: while(RandomNumber.size()>0) {
            int UserChoiceNum[] = new int[3];
            System.out.print("숫자를 입력해주세요");
            String num = Console.readLine();
            int[] UserNum = GoAndStop(num, UserChoiceNum);
                RandomNumber = CheckResult(RandomNumber, UserNum);
        }
    }
}
