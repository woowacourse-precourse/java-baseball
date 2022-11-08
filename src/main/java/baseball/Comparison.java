package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Comparison {
    static List<Integer> user = new ArrayList<>();
    static List<Integer> computer = new ArrayList<>();

    Set<Integer> userSet = new HashSet<>(user);

    public static void comNuser() {
        int strike = 0;
        int strikeNball = 0;
        int ball = 0;
//            int userNumber = 0;
        int i = 0;
        int j = 0;

        for(i =0; i<user.toArray().length;i++) {
            for (j = 0; j < computer.toArray().length; j++) {
                if (computer.get(i) - user.get(j) == 0) {
                    strikeNball = strikeNball + 1;
                }
            }
            j = 0;
        }
        for(i =0; i<user.toArray().length;i++) {
            if (computer.get(i) == user.get(i)) {
                strike = strike + 1;
            }
        }
    }
}
