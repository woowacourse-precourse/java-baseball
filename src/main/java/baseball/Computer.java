package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    
    private User user;
    private static String[] gameResult;

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
        gameResult = new String[3];
        User user = new User();
        List<Integer> computerNumbers = createRandomNumber();
        List<Integer> userNumbers = user.createUserNumber();
        System.out.println(computerNumbers);
        for (int i = 0; i < computerNumbers.size(); i++) {
            int userNumber = userNumbers.get(i);
            if (isSameIndexOfSameNumber(computerNumbers, userNumbers, userNumber)) {
                gameResult[i] = "스트라이크";
                continue;
            }
            if (isContainsNumber(computerNumbers, userNumber)) {
                gameResult[i] = "볼";
                continue;
            }
            gameResult[i] = "낫싱";
        }
        return gameResult;
    }

    public boolean isContainsNumber(List<Integer> computerNumbers, int number) {
        if (computerNumbers.contains(number)) {
            return true;
        }
        return false;
    }

    public boolean isSameIndexOfSameNumber(List<Integer> computerNumbers, List<Integer> userNumbers, int number) {
        if (isContainsNumber(computerNumbers, number)) {
            int computerNumberIndex = computerNumbers.indexOf(number);
            int userNumberIndex = userNumbers.indexOf(number);
            if (computerNumberIndex == userNumberIndex) {
                return true;
            }
        }
        return false;
    }
}