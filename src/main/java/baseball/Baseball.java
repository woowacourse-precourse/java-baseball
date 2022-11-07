package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.Set;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Baseball {
    private String userNumber;
    private String randomNumber;

    public Baseball() {
        userNumber = "";
        randomNumber = "";
    }

    public void setUserNumber(String number) {
        this.userNumber = number;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public String getRandomNumber() {
        return randomNumber;
    }

    public void initialize() {
        randomNumber = createRandomNumber(3);
    }

    private String createRandomNumber(int number) {
        Set<Character> randomNumbers = new HashSet<>();
        String result = "";
        int count = 0;

        while (number > count) {
            char c = Character.forDigit(Randoms.pickNumberInRange(1, 9), 10);

            if(randomNumbers.contains(c)) {
                continue;
            }

            randomNumbers.add(c);
            result += c;
            count++;
        }

        return result;
    }


    public void play() {
        System.out.println(Message.START);
        String result = "";
        do {
            System.out.print(Message.INPUT);

        } while (!result.equals(Message.CLEAR));
    }
}
