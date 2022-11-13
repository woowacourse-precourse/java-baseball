package baseball;

import baseball.domain.Judgement;
import baseball.domain.NumberGenerator;
import baseball.domain.Referee;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 객체 지향 프로그래밍
 * 1. 기능을 가지고 있는 클래스를 인스턴스화(=객체)한다.
 * 2. 필요한 기능을 (역할에 맞는) 인스턴스가 수행하게 한다. (의인화)
 * 3. 각 결과를 종합한다.
 */
public class Application {
    private static final int ZERO = 0;
    private static final int BASEBALL_LENGTH = 3;
    private static final int RESTART =1;
    private static final int EXIT = 2;
    private static boolean flag = true;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        NumberGenerator generator = new NumberGenerator();
        List<Integer> computer = generator.createRandomNumber();

        Referee referee = new Referee();

        String result ="";
        while(flag) {
            result = referee.compare(computer, askNumbers());
            System.out.println(result);
            if(result.equals("3스트라이크")) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                int restartAnswer = askRestart();
                processRestartAnswer(restartAnswer);
            }
        }
    }

    public static List<Integer> askNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();

        List<Integer> numbers = new ArrayList<>();
        for(String number: input.split("")) {
            numbers.add(Integer.valueOf(number));
        }
        if(numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("중복된 숫자가 있습니다. 다시 입력해주세요");
        }
        if(!isCorrectForm(numbers)) {
            throw new IllegalArgumentException(ZERO +"가 아닌 " + BASEBALL_LENGTH + "자리 숫자를 입력해주세요.");
        }
        return numbers;
    }
    public static boolean isCorrectForm(List<Integer> numbers) {
        if(numbers.size() == BASEBALL_LENGTH && !numbers.contains(ZERO)) {
            return true;
        }
        return false;
    }
    public static int askRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int restart = getRestart();
        return restart;
    }
    public static int getRestart() {
        String s = Console.readLine();
        int restart = Integer.parseInt(s);
        return restart;
    }
    private static void processRestartAnswer(int restartAnswer) {
        if(restartAnswer == RESTART) {
            flag = true;
        }
        else if(restartAnswer != EXIT) {
            throw new IllegalArgumentException("1 또는 2의 숫자를 입력해주세요.");
        } else {
            flag = false;
        }
    }
}
