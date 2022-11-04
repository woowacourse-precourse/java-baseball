package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    public List<Integer> createRandomNumber() {
        List<Integer> computerNumbers = new ArrayList<>();
        while (computerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
        return computerNumbers;
    }

    public String[] compareNumber() {
        String[] gameResult = new String[3];
        User user = new User();
        List<Integer> computerNumbers = createRandomNumber();
        List<Integer> userNumbers = user.createUserNumber();
        for (int i = 0; i < computerNumbers.size(); i++) {
            int userNumber = userNumbers.get(i);
            if (findSameNumber(computerNumbers, userNumber)) {
                gameResult[i] = "볼";
                continue;
            }
            gameResult[i] = "낫싱";
        }
        return gameResult;
    }

    public boolean findSameNumber(List<Integer> numberList, int number) {
        if (numberList.contains(number)) {
            return true;
        }
        return false;
    }
}
