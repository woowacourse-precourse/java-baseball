package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Baseball {
    private int gameState = 1;
    private String compareResult = "";
    private final String answerResult = "3스트라이크";
    private List<Integer> answerNumber = new ArrayList<>();
    private List<Integer> userNumber = new ArrayList<>();

    public void setAnswerNumber(){
        answerNumber.clear();
        int digitNumber = 0;
        while (answerNumber.size()<3){
            digitNumber = Randoms.pickNumberInRange(1,9);
            if(!answerNumber.contains(digitNumber))answerNumber.add(digitNumber);
        }

    }
    public void setUserNumber(){
        userNumber.clear();
        String inputUserName = Console.readLine();
    }
}
