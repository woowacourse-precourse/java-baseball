package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Player {
    protected static List<Integer> answer;
    public Player(){}
    public static String getAnswer(){
        System.out.println("숫자를 입력해주세요 : ");
        String str = Console.readLine();
        return str;
    }
}
