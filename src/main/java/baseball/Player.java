package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Player {
    protected static List<Integer> answer;
    public Player(){}

    public static List<Integer> splitAnswer(String number){
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < number.length(); i++){
            list.add((int)number.charAt(i)-'0');
        }
        return list;
    }
    public static List<Integer> getAnswer(){
        List<Integer> list = new ArrayList<>();
        System.out.println(SystemMessage.REQUEST_INPUT_NUMBER);
        String str = Console.readLine();
        list = splitAnswer(str);
        return list;
    }
}
