package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {

    private final static ComputerNumber computerNumber = new ComputerNumber();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> answer = computerNumber.createComputerNumber();

        while (true) {
            System.out.println("숫자를 입력해주세요 : ");
            String inputNumber = Console.readLine();
        }

    }
}
