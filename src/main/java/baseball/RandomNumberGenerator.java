package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;

public class RandomNumberGenerator {


    public static String generate(int length) {
        StringBuilder builder = new StringBuilder();
        HashSet<Integer> selectedNumbers = new HashSet<>();

        int selected;
        while (builder.length() < length) {
            selected = Randoms.pickNumberInRange(1, 9);
            if (!selectedNumbers.contains(selected)) {
                builder.append(selected);
                selectedNumbers.add(selected);
            }
        }
        return builder.toString();
    }
}
