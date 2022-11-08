package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class SecretNumber {
    private List<Integer> secretDigits;

    public SecretNumber(){
        secretDigits = new ArrayList<>();
    }

    public void generateSecretDigits() {
        List<Integer> candidateList = new ArrayList<>();

        while (candidateList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!candidateList.contains(randomNumber)) {
                candidateList.add(randomNumber);
            }
        }

        secretDigits = candidateList;
    }

    public List<Integer> getSecretDigits() {
        return secretDigits;
    }
}
