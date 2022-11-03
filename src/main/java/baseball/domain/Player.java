package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.sql.Array;
import java.util.*;

public class Player {

    public List<Integer> getInput(String readLine) {
        String verifiedInput = inputVerification(readLine);

        List<Integer> list = new ArrayList<>();
        for (String read : verifiedInput.split("")) {
            list.add(Integer.valueOf(read));
        }
        return list;
    }

}
