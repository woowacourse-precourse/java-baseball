package baseball;

import java.util.ArrayList;
import java.util.List;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {

    public int checkBall (List<Integer> answer, List<Integer> userInput) {
        int howManyBall = 0;
        for (int i=0; i<3; i++) {
            if (answer.contains(userInput.get(i))) {
                howManyBall++;
            }
        }
        return howManyBall;
    }

    public List<Integer> getUserInput() {
        System.out.println("숫자를 입력해주세요 : ");
        String userInputString = readLine();
        List<Integer> userInput = new ArrayList<>();
        for (int i=0; i<3; i++) {
            userInput.set(i,Character.getNumericValue(i));
        }
        return userInput;
    }

    public int checkStrike (List<Integer> answer, List<Integer> userInput, int howManyBall) {
        int howManyStrike = 0;
        for (int i=0; i<3; i++) {
            if (answer.get(i).equals(userInput.get(i))) {
                howManyStrike++;
                howManyBall--;
            }
        }
        return howManyStrike;
    }

    public boolean returnAnswer (int howManyBall, int howManyStrike) {
        if (howManyStrike==3) {
            return true;
        } else {
            return false;
        }
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}
