package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;

public class Application {

    private static final StringBuilder sb = new StringBuilder();
    private static Map<Integer, Integer> targetNumber = null;
    private static String status = "start";
    private static List<Integer> inputNumber = null;
    private static String inputStr = null;

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while("start".equals(status)){
            gameStartFunc();
        }
        resetGameSetting();
    }

    public static void gameStartFunc() {
        try {
            setTargetNumber();
            while("start".equals(status)){
                System.out.println("숫자를 입력해주세요 : ");
                input();
                compareNumber();
                System.out.println(sb);
                sb.setLength(0);
            }
            gameEndFunc();
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    public static void gameEndFunc(){
        if("end".equals(status)){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            input();
            if("1".equals(inputStr)){
                status = "start";
            }
        }
    }

    public static void resetGameSetting(){
        targetNumber = null;
        sb.setLength(0);
        inputNumber = null;
        inputStr = null;
        status = "start";
    }

    private static void setTargetNumber() {
        Map<Integer, Integer> computer = new HashMap<>();
        int idx = -1;
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.containsKey(randomNumber)) {
                computer.put(randomNumber, ++idx);
            }
        }
        targetNumber = computer;
    }

    private static void input() {
        try {
            inputStr = Console.readLine();
            inputValidation(inputStr);
            inputNumber = new ArrayList<>();
            for(char c : inputStr.toCharArray()){
                inputNumber.add((int)c - '0');
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }

    private static void inputValidation(String input) {
        if ( !validateNumber(input) || !validateStartNumber(input) || !validateEndNumber(input)){
            throw new IllegalArgumentException();
        }
    }

    private static boolean validateNumber(String str) {
        boolean rtn = true;
        for (char c : str.toCharArray()) {
            if (String.valueOf(c).matches("[^0-9]")) {
                rtn = false;
                break;
            }
        }
        return rtn;
    }

    private static boolean validateStartNumber(String str) {
        boolean rtn = true;
        if("start".equals(status) && str.length() != 3){
            rtn = false;
        }
        return rtn;
    }

    private static boolean validateEndNumber(String str) {
        boolean rtn = true;
        if("end".equals(status) && !("1".equals(str) || "2".equals(str))){
            rtn = false;
        }
        return rtn;
    }

    private static void compareNumber(){
        int[] ballStrikeList = new int[2];
        for(int num : inputNumber){
            if(targetNumber.containsKey(num)){
                checkBallOrStrike(num, ballStrikeList);
            }
        }
        setCompareResult(ballStrikeList);
    }

    private static void checkBallOrStrike(int num, int[] ballStrikeList){
        if(targetNumber.get(num) == inputNumber.indexOf(num)){
            ++ballStrikeList[1];
        }else{
            ++ballStrikeList[0];
        }
    }

    private static void setCompareResult(int[] ballStrikeList){
        if(ballStrikeList[1] == 3){
            status = "end";
        }
        if(ballStrikeList[0] > 0){
            sb.append(ballStrikeList[0]).append("볼").append(" ");
        }
        if(ballStrikeList[1] > 0){
            sb.append(ballStrikeList[1]).append("스트라이크");
        }
        if(sb.toString().length() == 0){
            sb.append("낫싱");
        }
    }
}
