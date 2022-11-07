package baseball;

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

        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber))
                computer.add(randomNumber);
        }

        System.out.println("숫자 야구 게임을 시작합니다.");
        System.out.println("숫자를 입력해주세요 : ");

        List<Integer> user;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String answer = br.readLine();
            int userNumber = Integer.parseInt(answer);
            user = seperateNumber(userNumber);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        HashMap<String, Integer> resultMap = compareNumber(user, computer);

    }

    private static List<Integer> seperateNumber(int number) {
        List<Integer> numberList = new ArrayList<>();
        int hundred = 100;
        while (hundred > 0) {
            numberList.add(number/hundred);
            number %= hundred;
            hundred /= 10;
        }
        return numberList;
    }

    private static HashMap<String, Integer> setHashMap() {
        HashMap<String, Integer> hashmap = new HashMap<>();
        hashmap.put("Ball", 0);
        hashmap.put("Strike", 0);
        return hashmap;
    }

    private static HashMap<String, Integer> compareNumber(List<Integer> user, List<Integer> computer) {
        HashMap<String, Integer> resultMap = setHashMap();
        for(int userNumber : user) {
            int userIndex = user.indexOf(userNumber);
            if (computer.contains(userNumber) && (computer.indexOf(userNumber)==userIndex))
                resultMap.put("Strike", resultMap.get("Strike") + 1);
            else if (computer.contains(userNumber))
                resultMap.put("Ball", resultMap.get("Ball") + 1);
        }
        return resultMap;
    }


}
