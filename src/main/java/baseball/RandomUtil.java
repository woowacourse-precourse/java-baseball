package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;

public class RandomUtil {
    public HashSet<String> giveComputerNumber(){
        HashSet<String> computerNumberSet = new HashSet<>();
        while(computerNumberSet.size()<3){
            computerNumberSet.add(Integer.toString(Randoms.pickNumberInRange(1,9)));
        }
        return computerNumberSet;
    }
}
