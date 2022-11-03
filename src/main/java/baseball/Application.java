package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        gameStart();

    }

    static void gameStart(){
        int[] computer = initializeComputerNumber();
    }

    static int[] initializeComputerNumber(){
        List<Integer> computerNumberList = new ArrayList<>();
        while(computerNumberList.size() < 3){
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!computerNumberList.contains(randomNumber)){
                computerNumberList.add(randomNumber);
            }
        }
        int[] computerNumberArray = computerNumberList.stream().mapToInt(i -> i).toArray();
        return computerNumberArray;
    }
}
