package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    static Computer computer;

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        while(true){
            init();
            doGame();
            if(!isContinue()) break;
        }
    }

    private static boolean isContinue() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
        int res = Integer.parseInt(Console.readLine());

        // Exception 처리
        if(res == 1) return true;
        else if(res == 0) return false;
        else throw new IllegalArgumentException("0 또는 1만 입력해야 합니다.");
    }

    private static void init() {
        if (computer == null) computer = new Computer();
        computer.initNumbers();
    }

    private static void doGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            // making list
            List<Integer> userInput = makingIntegerList(Console.readLine());
            Integer[] res = computer.checkingNumbers(userInput);
            if(consoleOut(res)) break;
        }
    }

    private static boolean consoleOut(Integer[] res) {
        // input에 대하여 console 로 출력, 계속 진행여부를 return
        if(res[0] > 0 && res[1] > 0) {
            System.out.println(res[1] + "볼 " + res[0] + "스트라이크");
        } else if (res[0] > 0) {
            System.out.println(res[0] + "스트라이크");
        } else if(res[1] > 0){
            System.out.println(res[1] + "볼");
        }else {
            System.out.println("낫싱");
        }

        return res[0] == 3;
    }

    private static List<Integer> makingIntegerList(String readLine) {
        // 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.
        // checking
        if (readLine.length() != 3) throw new IllegalArgumentException("입력값은 공백없이 3개의 숫자로만 이루어져야 합니다.");

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < readLine.length(); i++) {
            if (Character.isDigit(readLine.charAt(i))) {
                list.add(Character.getNumericValue(readLine.charAt(i)));
            } else throw new IllegalArgumentException("올바른 숫자가 입력되어야 합니다. - " + (i+1) + " is not number.");
        }
        return list;
    }


}
