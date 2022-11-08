package baseball;


import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class BaseBallGame {
    private final String REGAME = "1";
    private final String FINISHGAME = "2";

    public void reStart(String userNum) {
        if (userNum.equals(REGAME)) {
            run();
        } else if (userNum.equals(FINISHGAME)) {
            return;
        } else {
            throw new IllegalArgumentException();
        }
    }


    public void run() {
        //사용할 클래스 생성
        Computer computer = new Computer();
        User user = new User();
        CompareNumber compareNumber = new CompareNumber();

        //난수 생성
        List<Integer> computerNumber = computer.randomNumbers();
        compareNumber.setComputer(computerNumber);

        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            System.out.printf("숫자를 입력해주세요 : ");
            String userNum = Console.readLine();
            List<Integer> userNumber = user.inputNumbers(userNum);
            if (compareNumber.gameRun(userNumber)) {
                break;
            }
        }

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userNum = Console.readLine();
        reStart(userNum);
    }

}