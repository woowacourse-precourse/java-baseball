package baseball;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Application {
    public static void main(String[] args) {
        CreateRandomNum();
        playerNum();



    }

    public static List<Integer> CreateRandomNum(){
        List<Integer> computerNum = new ArrayList<>();
        while(computerNum.size() < 3){
            int randomNum = pickNumberInRange(1, 9);
            if(!computerNum.contains(randomNum)){
                computerNum.add(randomNum);
            }
        }
        return computerNum;
    }

    public static List<Integer> playerNum(){
        System.out.println("숫자를 입력해주세요 : ");
        String inputNumber = readLine();
        List<Integer> playerNumber = new ArrayList<>();

        for(String number : inputNumber.split("")){
            playerNumber.add(Integer.parseInt(number));
        }
        return playerNumber;
    }

    public static int howManySame(List<Integer> computerNum, List<Integer> playerNum){
        int result = 0;
        for(int i = 0; i < playerNum.size(); i++){
            if(computerNum.contains(playerNum.get(i)))
                result += 1;
        }
        return result;
    }

    public static int howManyStrike(List<Integer>computerNum, List<Integer> playerNum){
        int strike = 0;
        for(int i = 0; i < playerNum.size(); i++){
            if(computerNum.get(i) == playerNum.get(i))
                strike += 1;
        }
        return strike;
    }
}
