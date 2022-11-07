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

    // 사용자가 입력한 숫자에 대해 검사하기
    private String inputNumber() {
        String input = readLine();

        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }

        char check = input.charAt(0);
        if (check == '0') {
            throw new IllegalArgumentException();
        }

        char checkTwice = input.charAt(0);
        for (int i = 1; i < input.length(); i++) {
            if (checkTwice == input.charAt(i)) { // 2번째 자릿수와 3번째 자릿수가 같을 경우
                throw new IllegalArgumentException();
            }
            if (input.charAt(i) == '0') {
                throw new IllegalArgumentException();
            }
            if (check == input.charAt(i)) {
                throw new IllegalArgumentException();
            }
            checkTwice = input.charAt(i);
        }

        return input;
    }



    public void play() {
        System.out.println(Message.START);
        String result = "";
        do {
            System.out.print(Message.INPUT);
            userNumber = inputNumber();
        } while (!result.equals(Message.CLEAR));
    }
}
