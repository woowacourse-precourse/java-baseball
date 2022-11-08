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
        while (secretDigits.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!secretDigits.contains(randomNumber)) {
                secretDigits.add(randomNumber);
            }
        }
    }

    public List<Integer> getSecretDigits() {
        return secretDigits;
    }
}
