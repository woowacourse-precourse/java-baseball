package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    public static List<Integer> generateNumber() {
        List<Integer> computerAnswer = new ArrayList<>();
        while (computerAnswer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerAnswer.contains(randomNumber)) {
                computerAnswer.add(randomNumber);
            }
        }
        return computerAnswer;
    }
    public static List<Integer> getPlayerAnswer() {
        System.out.print("숫자를 입력해주세요 : ");
        String playerAnswerStr = Console.readLine();
        List<Integer> playerAnswer = stringToIntegerList(playerAnswerStr);

        validateNumber(playerAnswer);

        return playerAnswer;
    }
    public static List<Integer> stringToIntegerList(String inputStr) {
        String[] inputStrArr = inputStr.split("");
        List<Integer> inputIntList = new ArrayList<>();
        for (int i = 0; i < inputStrArr.length; i++) {
            int tmp = Integer.parseInt(inputStrArr[i]);
            inputIntList.add(tmp);
        }
        return inputIntList;
    }
    public static boolean validateNumber(List<Integer> playerAnswer) {
        //length check
        if (playerAnswer.size() != 3) {
            throw new IllegalArgumentException("length error");

        }

        //same check
        if (playerAnswer.size() != playerAnswer.stream().distinct().count()) {
            throw new IllegalArgumentException("duplicate error");
        }

        //number only check
        String regExp = "^[1-9]+$";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            String st = Integer.toString(playerAnswer.get(i));
            sb.append(st);
        }
        String s = sb.toString();
        if (!s.matches(regExp)) {
            throw new IllegalArgumentException("not number error");
        }

        return true;
    }
}
