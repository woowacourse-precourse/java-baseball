package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {


    static final String a = "dfd";

    static final int i = 2;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        while (true) {
            playGame();
            if (restartGame()) {
                break;
            }
        }
    }

    public static void playGame() {
        List<Integer> randomNumber = generateNumber();
        while (true) {
            List<Integer> guessNumber = getGuessNumber();
            boolean isAllStrike = checkNumber(randomNumber, guessNumber);
            if (isAllStrike) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

    public static List<Integer> generateNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static List<Integer> getGuessNumber() {
        String tmpStr = Console.readLine();
        List<Integer> numberList = stringToIntegerList(tmpStr);

        validateNumber(numberList);
        // 유효성 검사 해야함

        return numberList;
    }

    public static List<Integer> stringToIntegerList(String tmpStr) {
        String[] tmpStrArr = tmpStr.split("");
        List<Integer> tmpList = new ArrayList<>();
        for (int i = 0; i < tmpStrArr.length; i++) {
            int tmp = Integer.parseInt(tmpStrArr[i]);
            tmpList.add(tmp);
        }
        return tmpList;
    }

    public static boolean validateNumber(List<Integer> inputNumber) {
        // list 사이즈는 3
        // 1~9 까지
        // 중복 없어야 함.
        if (inputNumber.size() == 3) {
            return true;
        }

        if (inputNumber.size() == inputNumber.stream().distinct().count()) {
            return true;
        }

        String regExp = "^[1-9]+$";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            String st = Integer.toString(inputNumber.get(i));
            sb.append(st);
        }
        String s = sb.toString();
        if (s.matches(regExp)) {
            return true;
        }

        return false;
    }

    public static boolean checkNumber(List<Integer> randomNumber, List<Integer> guessNumber) {
        boolean isCorrect = false;
        int strike = 0;
        int ball = 0;
        for(int i = 0;i < 3 ;i++){
            if(randomNumber.get(i).equals(guessNumber.get(i))){
                strike++;
            }else if(randomNumber.contains(guessNumber.get(i))){
                ball++;
            }
        }
        if(strike == 3){
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            isCorrect = true;
        }else if(strike == 0 && ball == 0){
            System.out.println("낫싱");
        }else{
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
        return isCorrect;
    }

    public static boolean restartGame() {
        int i = Integer.parseInt(Console.readLine());
        if (i == 1) {
            return true;
        } else {
            return false;
        }
    }
}
