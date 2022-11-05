package baseball.domain;

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
        //1부터 9까지의 난수3개 생성
        ArrayList<Integer> RandomNumList= new ArrayList<>();
        while(RandomNumList.size()<3){
            int ran_num = Randoms.pickNumberInRange(1, 9);
            RandomNumList.add(ran_num);
        }

        if (isSet(RandomNumList)) {
            return RandomNumList;
        }
        return makeRandomNum();
    }
}
