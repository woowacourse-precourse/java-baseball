package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;

public class RandomUtil {

    public HashSet<String> makeComputerNumber(){
        HashSet<String> computerNumberSet = new HashSet<>();
        while(computerNumberSet.size()<3){
            computerNumberSet.add(Integer.toString(Randoms.pickNumberInRange(1,9)));
        }
        return computerNumberSet;
    }

    public static String giveComputerNumber(){
        RandomUtil randomUtil = new RandomUtil();

        String computerNumber = "";
        for(String str:randomUtil.makeComputerNumber()) computerNumber+=str;

        return computerNumber;
    }
}
