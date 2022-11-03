package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class GameServer {
    private List<Integer> computerNumbers = new ArrayList<>();
    private List<Integer> userNumbers = new ArrayList<>();

    public void createRandomNumber() {
        while (computerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
    }

    public String getUserNumber() {
        String userNumber = Console.readLine();
        return userNumber;
    }

    public void setUserNumber(String userNum) {
        int userNumber = Integer.parseInt(userNum);
        int divideNum = 100;
        for (int i = 0; i < 3; i++) {
            userNumbers.add(userNumber / divideNum);
            userNumber /= divideNum;
            divideNum /= 10;
        }
    }
}
