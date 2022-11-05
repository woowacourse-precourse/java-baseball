package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        System.out.println("게임을 시작합니다.");
        List<Integer> computer = new ArrayList<>();
        List<Integer> user = new ArrayList<>();

        makeRandomNumber(computer);

        //사용자의 입력
        usersTurn(user);

        //사용자의 입력과 답을 비교
        Map<String, Integer> result = checking(computer, user);
        System.out.println(result);
        //결과를 출력
        //더 수행할지 여부를 확인
    }

    /**
     * 컴퓨터와 사용자의 입력을 받아 비교하는 메서드
     * Checking map.
     *
     * @param answer the answer
     * @param swing  the swing
     * @return the map
     */
    public static Map<String, Integer> checking(List<Integer> answer, List<Integer> swing) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < 3; i++) {
            if (Objects.equals(answer.get(i), swing.get(i))) {
                map.put("S", map.getOrDefault("스트라이크", 0) + 1);
            } else if (answer.contains(swing.get(i))) {
                map.put("b", map.getOrDefault("볼", 0) + 1);
            }
        }
        if (map.isEmpty()) map.put("n", 1);
        return map;
    }

    /**
     * 사용자의 입력을 검증하는
     * Users turn.
     *
     * @param user the user
     */
    public static void usersTurn(List<Integer> user) {
        while (user.size() != 3) {
            user.clear();
            System.out.print("숫자를 입력해주세요 : ");
            String[] inputArray = Console.readLine().split("");
            if (inputLengthCheck(inputArray)) continue;
            addUserList(user, inputArray);
        }
    }

    /**
     * 입력받은 수를 user에 저장하는 메서드 예외 발생시 프로그램을 종료 시키는 역할
     * Add user list.
     *
     * @param user       the user
     * @param inputArray the input array
     */
    public static void addUserList(List<Integer> user, String[] inputArray) {
        for (String keyword : inputArray) {
            try {
                int i = Integer.parseInt(keyword);
                inputRange(i);
                user.add(i);
            } catch (Exception e) {
                throw new IllegalArgumentException();
            }
        }
    }

    /**
     * 입력받은 수의 길이를 체크하는 메서드
     * Input range.
     *
     * @param i the
     */
    public static void inputRange(int i) {
        if (i <= 0 || 10 <= i) throw new IllegalArgumentException();
    }


    /**
     * 길이가 3인지 확인하는 메서드
     * Input length check boolean.
     *
     * @param inputArray the input array
     * @return the boolean
     */
    public static boolean inputLengthCheck(String[] inputArray) {
        if (inputArray.length != 3) {
            System.out.println("3자리 정수만 입력해주세요.. ");
            return true;
        }
        return false;
    }

    /**
     * 1-9 사이 무작위 숫자를 3개 구현하는 메서드
     * Make random number.
     *
     * @param computer the computer
     */
    public static void makeRandomNumber(List<Integer> computer) {
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }
}

