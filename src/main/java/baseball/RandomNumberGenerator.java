package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class RandomNumberGenerator {
    public static Integer generate() {
        return Randoms.pickNumberInList(getCandidateRandomNumbers());
    }

    private static List<Integer> getCandidateRandomNumbers() {
        List<Integer> ret = new ArrayList<>();
        for (int number = 100; number <= 999; ++number) {
            String numberStringType = String.valueOf(number);
            if (numberStringType.contains("0"))
                continue;
            if (isContainSameCharacter(numberStringType))
                continue;
            ret.add(number);
        }
        return ret;
    }

    private static boolean isContainSameCharacter(String string) {
        Set<Character> set = new HashSet<>();
        for(var c : string.toCharArray()){
            if(set.contains(c))
                return true;
            set.add(c);
        }
       return false;
    }
}
