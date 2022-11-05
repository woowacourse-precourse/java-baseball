package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        //  run("246", "135", "1", "597", "589", "2");

        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> computer = new ArrayList<>();
        List<Integer> user = new ArrayList<>();


        do {
            user.clear();
            computer.clear();

            gameRun(computer, user);
            //더 수행할지 여부를
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String oneMore = readLine();
            if (oneMore.equals("1")) continue;
            if (oneMore.equals("2")) {
                System.out.println("게임 종료");
                break;
            }
        } while (true);


    }

    /**
     * 실제로 수행하는 게임
     * Game run.
     *
     * @param computer the computer
     * @param user     the user
     */
    private static void gameRun(List<Integer> computer, List<Integer> user) {
        makeRandomNumber(computer);

        boolean flag = true;
        while (flag) {
            user.clear();
            usersTurn(user);
            flag = resultPrint(computer, user);
        }
    }

    /**
     * 결과를 입력받아 정답을 출력하는 메서드
     * Result print boolean.
     *
     * @param computer the computer
     * @param user     the user
     * @return the boolean
     */
    private static boolean resultPrint(List<Integer> computer, List<Integer> user) {
        Map<String, Integer> result = checking(computer, user);

        if (result.isEmpty()) System.out.println("낫싱");
        if (result.containsKey("볼")) System.out.print(result.get("볼") + "볼 ");
        if (result.containsKey("스트라이크")) {
            System.out.print(result.get("스트라이크") + "스트라이크");
            if (result.get("스트라이크") == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                return false;
            }
        }

        return true;
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
                map.put("스트라이크", map.getOrDefault("스트라이크", 0) + 1);
            } else if (answer.contains(swing.get(i))) {
                map.put("볼", map.getOrDefault("볼", 0) + 1);
            }
        }
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
            System.out.print("숫자를 입력해주세요 : ");
            String[] inputArray = readLine().split("");
            if (inputArray.length > 3) {
                throw new IllegalArgumentException();
            }
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

