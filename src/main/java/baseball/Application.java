package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;

public class Application {
    public static void main(String[] args) {
        Map<String, List<Integer>> inputValue = new HashMap<>();
        int start = 1;
    }
    public static List<Integer> inputComputer() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randNum = Randoms.pickNumberInRange(1, 9);
            computer = isContain(computer, randNum);
        }
        return computer;
    }
    public static List<Integer> isContain(List<Integer> list, int value) {
        if (!list.contains(value)) {
            list.add(value);
        }
        return list;
    }
    public static Map<String,List<Integer>> inputUser() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> computer = inputComputer();
        List<Integer> user = new ArrayList<>();
        Map<String,List<Integer>> result = new HashMap<>();
        userValue(user);
        result.put("user",user);
        result.put("computer", computer);
        return result;
    }
    public static List<Integer> userValue(List<Integer> user) {
        System.out.print("숫자를 입력해주세요 : ");
        String text = Console.readLine();
        textSize(text, 3);
        makeUserList(user, text);
        return user;
    }
    private static void makeUserList(List<Integer> user, String text) {
        for (int i = 0; i < text.length(); i++) {
            int value = isValidateInt(text.charAt(i), 1, 9);
            isContainUser(user, value);
            user.add(value);
        }
        if (user.size() > 3) {
            throw new IllegalArgumentException();
        }
    }
    public static int isValidateInt(Character str, int start, int end) {
        int value = 0;
        try {
            Integer.parseInt(str.toString());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        if ((Integer.parseInt(str.toString()) >= start) && (Integer.parseInt(str.toString()) <= end)) {
            value = Integer.parseInt(str.toString());
        } else {
            throw new IllegalArgumentException();
        }
        return value;
    }
    public static void isContainUser(List<Integer> user, int value) {
        if (user.contains(value)) {
            throw new IllegalArgumentException();
        }
    }
    public static void textSize(String text, int size) {
        if (text.length() != size) {
            throw new IllegalArgumentException();
        }
    }
}
