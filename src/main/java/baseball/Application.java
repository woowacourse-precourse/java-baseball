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
        System.out.println("숫자 야구 게임을 시작합니다.");
        game();
    }

    public static void game() {
        List<Integer> computer = new ArrayList<>();
        List<Integer> user = new ArrayList<>();
        HashMap<String, Integer> resultMap = new HashMap<>();
        computer = setComputerNumber();
        System.out.println("숫자를 입력해주세요 : ");
        user = setUserNumber();
        resultMap = getCompareResult(user, computer);
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
            if (user.contains(number) || user.size()>3)
                throw new IllegalArgumentException();
            user.add(number);
        }
        return user;
    }

    public static HashMap<String, Integer> setResultMap() {
        HashMap<String, Integer> initalMap = new HashMap<>();
        initalMap.put("스트라이크", 0);
        initalMap.put("볼", 0);
        initalMap.put("낫싱", 0);
        return initalMap;
    }

    public static HashMap<String, Integer> getCompareResult(List<Integer> user, List<Integer> computer) {
        HashMap<String, Integer> resultMap = setResultMap();
        for (int userNumber : user) {
            if (computer.contains(userNumber)) {
                int userIndex = user.indexOf(userNumber);
                if (computer.indexOf(userNumber) == userIndex)
                    resultMap.put("스트라이크", resultMap.get("스트라이크") + 1);
                else
                    resultMap.put("볼", resultMap.get("볼") + 1);
                resultMap.put("낫싱", 1);
            }
        }
        return resultMap;
    }

}
