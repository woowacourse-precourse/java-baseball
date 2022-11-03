package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");

        boolean retry = false;

        do {
            List<Integer> computer = getComputer();
            System.out.println("computer: "+Arrays.toString(computer.toArray()));

            boolean win = false;

            while(!win) {
                List<Integer> user = getUser();
                System.out.println("user: "+Arrays.toString(user.toArray()));

                win = judgeGame(computer, user);
                System.out.println("win: "+win);
            }

        } while (retry);

        System.out.println("애플리케이션 종료");
    }

    //컴퓨터 숫자 입력
    public static List<Integer> getComputer() {
        List<Integer> computer = new ArrayList<>();

        while(computer.size() < 3) {
            addComputer(computer);
        }

        validateComputer(computer);

        return computer;
    }

    private static void addComputer(List<Integer> computer) {
        int random = Randoms.pickNumberInRange(1, 9);

        if(!computer.contains(random)) {
            computer.add(random);
        }
    }

    private static void validateComputer(List<Integer> computer) {
        if(computer.size()!=3)
            throw new IllegalArgumentException("3자리의 수가 아닙니다.");
    }

    //사용자 숫자 입력
    public static List<Integer> getUser() {
        List<Integer> user = new ArrayList<>();

        addUser(user);

        return user;
    }

    private static void addUser(List<Integer> user) {
        for(String num : splitInput()) {
            user.add(Integer.parseInt(num));
        }
    }

    private static String inputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        validateInput(input);

        return input;
    }

    private static void validateInput(String input) {
        if(!Pattern.matches("^[1-9]{3}", input))
            throw new IllegalArgumentException("1부터 9까지 3자리의 숫자를 입력해주세요");
    }

    private static String[] splitInput() {
        return inputNumber().split("");
    }

    //컴퓨터와 사용자 숫자 비교
    public static boolean judgeGame(List<Integer> computer, List<Integer> user) {
        String msg = getMSG(computer, user);
        System.out.println(msg);

        return "3스트라이크".equals(msg);
    }

    private static String getMSG(List<Integer> computer, List<Integer> user) {
        int count = countSame(computer, user);
        int strike = countStrike(computer, user);

        if(count==0) {
            return "낫싱";
        } else if(count!=strike) {
            return (count-strike) + "볼 " + strike + "스트라이크";
        } else {
            return strike + "스트라이크";
        }
    }

    private static int countSame(List<Integer> computer, List<Integer> user) {
        int count = 0;

        for(int num : user) {
            if(computer.contains(num)) {
                count++;
            }
        }

        return count;
    }

    private static int countStrike(List<Integer> computer, List<Integer> user) {
        int count = 0;

        for(int i=0; i<user.size(); i++) {
            if(Objects.equals(computer.get(i), user.get(i))) {
                count++;
            }
        }

        return count;
    }

    //재시작/종료 묻기
    private static String inputAnswer() {
        return Console.readLine();
    }
}
