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
        List<Integer> candidateDigits = new ArrayList<>();

        while (candidateDigits.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!candidateDigits.contains(randomNumber)) {
                candidateDigits.add(randomNumber);
            }
        }

        secretDigits = candidateDigits;
    }

    public List<Integer> getSecretDigits() {
        return secretDigits;
    }
}
