package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 숫자 비교, 조건 비교, 종료 비교
        String newgame = "1";
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (newgame.equals("1")) {
            List<Integer> computer = setComputerNumber();
            game(computer);
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            newgame = Console.readLine();
            if (!newgame.equals("1") && !newgame.equals("2"))
                throw new IllegalArgumentException();
            if (newgame.equals("2"))
                System.out.println("게임 종료");
        }
    }

    public static void game(List<Integer> computer) {
        while (true) {
            List<Integer> user;
            HashMap<String, Integer> resultMap;
            System.out.println("숫자를 입력해주세요 : ");
            user = setUserNumber();
            if (user.size() != 3)
                throw new IllegalArgumentException();
            resultMap = getCompareResult(user, computer);
            printResult(resultMap);
            if (isAllCorrect(resultMap)) {
                break;
            }
        }
    }

    public static List<Integer> setComputerNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static List<Integer> setUserNumber() {
        List<Integer> user = new ArrayList<>();
        int number;
        String answer = Console.readLine();
        for (String s : answer.split("")) {
            number = Integer.parseInt(s);
            if (user.contains(number))
                throw new IllegalArgumentException();
            user.add(number);
        }
        return user;
    }

    public static HashMap<String, Integer> setResultMap() {
        HashMap<String, Integer> initalMap = new HashMap<>();
        initalMap.put("strike", 0);
        initalMap.put("ball", 0);
        initalMap.put("nothing", 0);
        return initalMap;
    }

    public static HashMap<String, Integer> getCompareResult(List<Integer> user, List<Integer> computer) {
        HashMap<String, Integer> resultMap = setResultMap();
        for (int userNumber : user) {
            int userIndex = user.indexOf(userNumber);
            if (computer.contains(userNumber) && computer.indexOf(userNumber) == userIndex)
                resultMap.put("strike", resultMap.get("strike") + 1);
            else if (computer.contains(userNumber) && computer.indexOf(userNumber) != userIndex)
                resultMap.put("ball", resultMap.get("ball") + 1);
            else resultMap.put("nothing", resultMap.get("nothing") + 1);
        }
        return resultMap;
    }

    public static void printResult(HashMap<String, Integer> resultMap) {
        if (resultMap.get("nothing") == 3)
            System.out.print("낫싱");
        else {
            if (resultMap.get("ball") > 0) {
                System.out.print(resultMap.get("ball") + "볼 ");
            }
            if (resultMap.get("strike") > 0) {
                System.out.print(resultMap.get("strike") + "스트라이크");
            }
        }
        System.out.println();
    }

    public static boolean isAllCorrect(HashMap<String, Integer> resultMap) {
        if (resultMap.get("strike") == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }

}
