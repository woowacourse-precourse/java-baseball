package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

    }
    private static List<Integer> setComputerNumberGroup(){
        List<Integer> computerNumberGroup = new ArrayList<>();
        while(computerNumberGroup.size()<3){
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if(!computerNumberGroup.contains(randomNumber)){
                computerNumberGroup.add(randomNumber);
            }
        }
        return computerNumberGroup;
    }
}
