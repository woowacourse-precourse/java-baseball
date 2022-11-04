package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }


        String userNumberString = Console.readLine();
        String[] userNumberStringList = userNumberString.split("");
        List<Integer> user = listToArrayList(userNumberStringList);


    }

    public static List<Integer> listToArrayList(String[] userNumberStringList) {
        List<Integer> userNumberIntegerList = new ArrayList<>();

        for (int i = 0; i < userNumberStringList.length; i++) {
            userNumberIntegerList.add(Integer.parseInt(userNumberStringList[i]));
        }

        return userNumberIntegerList;
    }
}
