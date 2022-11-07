package baseball.domain;

import baseball.utils.Constants;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class RandomNumber {

    public static boolean isSet(ArrayList<Integer> numList){
        Set<Integer> numSet = new HashSet<>(numList);
        return (numSet.size() == numList.size());
    }

    public static ArrayList<Integer> makeRandomNum(){
        ArrayList<Integer> RandomNumList= new ArrayList<>();
        while(RandomNumList.size()< Constants.INPUT_SIZE){
            int ran_num = Randoms.pickNumberInRange(Constants.RANDOM_START_NUM, Constants.RANDOM_END_NUM);
            RandomNumList.add(ran_num);
        }
        if (isSet(RandomNumList)) {
            return RandomNumList;
        }
        return makeRandomNum();
    }
}
