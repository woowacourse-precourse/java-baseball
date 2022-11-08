package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;

public class Application {
    public static void main(String[] args) {
        Map<String, List<Integer>> inputValue = new HashMap<>();
        int start = 1;
        while (start == 1) {
            inputValue = inputUser();
            untilEnd(inputValue);
            start = gameOption();
        }
    }
    public static int gameOption() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String text = Console.readLine();
        textSize(text, 1);
        return isValidateInt(text.charAt(0), 1, 2);
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
    public static List<Integer> makeUserList(List<Integer> user, String text) {
        for (int i = 0; i < text.length(); i++) {
            int value = isValidateInt(text.charAt(i), 1, 9);
            isContainUser(user, value);
            user.add(value);
        }
        if (user.size() > 3) {
            throw new IllegalArgumentException();
        }
        return user;
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
    public static Boolean compareComputerAndUser(List<Integer> computer, List<Integer> user) {
        List<Integer> strike = new ArrayList<>();
        boolean check = true;
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            strike = isSame(strike, computer.get(i), user.get(i));
        }
        for (int i = 0; i < 3; i++) {
            ball += isBall(strike, computer, user.get(i));
        }
        if (strike.size() == 3) {
            System.out.println("3스트라이크");
            check = false;
        } else if (strike.size() > 0 && ball > 0) {
            System.out.println(ball + "볼 " + strike.size() + "스트라이크");
        } else if (ball > 0) {
            System.out.println(ball + "볼");
        } else if (strike.size() > 0) {
            System.out.println(strike.size() + "스트라이크");
        } else {
            System.out.println("낫싱");
        }
        return check;
    }
    public static int isBall(List<Integer> strike, List<Integer> computer, Integer userValue) {
        if (computer.contains(userValue) && !strike.contains(userValue)) {
            return 1;
        }
        return 0;
    }
    public static List<Integer> isSame(List<Integer> strike, Integer computerValue, Integer userValue) {
        if (computerValue.equals(userValue)) {
            strike.add(computerValue);
        }
        return strike;
    }
    public static void untilEnd(Map<String, List<Integer>> inputValue) {
        while (compareComputerAndUser(inputValue.get("computer"), inputValue.get("user"))) {
            List<Integer> user = new ArrayList<>();
            userValue(user);
            inputValue.replace("user", user);
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
