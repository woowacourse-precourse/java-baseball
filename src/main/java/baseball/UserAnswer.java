package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class UserAnswer {

    public int setUserEndGame() {
        UserEndGameException endGame = new UserEndGameException();
        String userToInt = Console.readLine();
        int userNum = Integer.parseInt(userToInt);

        endGame.checkUserHasOneOrTwo(userNum);

        return userNum;
    }

    public List<Integer> setUserAnswer() {
        UserException exception = new UserException();
        List<Integer> user = new ArrayList<>();

        String userToChar = Console.readLine();
        char [] userToInt = userToChar.toCharArray();
        for(char ch : userToInt) {
            user.add(Character.getNumericValue(ch));
        }

        exception.checkUserHasException(user);

        return user;
    }

    public void printEnterNum() {
        System.out.print("숫자를 입력해주세요 : ");

    }

}
