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

        String[] input = splitInput();
        System.out.println("input: "+Arrays.toString(input));

        return user;
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
}
