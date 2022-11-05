package baseball;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class PlayBaseballGame {
    private Integer strike;
    private Integer ball;
    private List<Integer> RandomNum;
    private List<Integer> UserNum;

    String userInput = Console.readLine();
    UserNum = getUserNum(userInput);

    public void RandomNum(){
        while(RandomNum.size() < 3){
            int num = Randoms.pickNumberInRange(1,9);
            if (!RandomNum.contains(num)){
                RandomNum.add(num);
            }
        }
    }

    public void checkUserInput(String userInput){
        if (userInput.length() != 3){
            new throw IllegalArgumentException();
        }

        for (int i = 0; i < userInput.length(); i++){
            if(userInput.charAt(i) == 0){
                new throw IllegalArgumentException();
            }
        }

        // 각 자리 숫자 비교해서 달라야함

    }

    public static List<Integer> getUserNum(String userInput){
        List<Integer> userNum = new ArrayList<>();
        for (int i = 0; i < userInput.length(); i++){
            userNum.add(Character.getNumericValue(userInput.charAt(i)));
        }

        return userNum;
    }

}
