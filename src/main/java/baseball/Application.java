package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.ArrayList;

public class Application {

    public static int checkStrike(List<Integer> randomNum, List<Integer> inputNum) {
        int count=0;
        for(int i=0;i<randomNum.size();i++) {
            if(randomNum.get(i)==inputNum.get(i))
                count++;
        }
        return count;
    }

    public static boolean checkNum(List<Integer> randomNum, List<Integer> inputNum) {

        int strike=checkStrike(randomNum,inputNum);
        int ball=checkBall(randomNum,inputNum);

        if(strike==3) {
            return true;
        }
        else if(strike==0&&ball==0) {
            System.out.println("낫싱");
            return false;
        }
        else {
            System.out.println(output(strike,ball));
            return false;
        }

    }

    public static void exception(String inputString) throws IllegalArgumentException {

        if(inputString.length()!=3) {
            throw new IllegalArgumentException();
        }
        if(inputString.contains("0")) {
            throw new IllegalArgumentException();
        }
        if(!inputString.matches("[+-]?\\d*(\\.\\d+)?")) {
            throw new IllegalArgumentException();
        }
        char zero= inputString.charAt(0);
        char one= inputString.charAt(1);
        char two= inputString.charAt(2);
        if(zero==one||zero==two||one==two) {
            throw new IllegalArgumentException();
        }
    }

    public static List<Integer> input() {
        List<Integer> inputNum =new ArrayList<Integer>();

        String inputString=Console.readLine();

        exception(inputString);

        int stringToNum=Integer.parseInt(inputString);
        inputNum.add(stringToNum/100);
        inputNum.add((stringToNum%100)/10);
        inputNum.add(stringToNum%10);

        return inputNum;
    }

    public static List<Integer> random(){
        List<Integer> computer = new ArrayList<Integer>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static void game() {
        List<Integer> randomNum= random();

        while(true) {
            System.out.print("숫자를 입력해주세요 : ");
            List<Integer> inputNum=input();
            boolean returnValue=checkNum(randomNum,inputNum);
            if(returnValue)
                break;
            else
                continue;
        }
    }

    public static void startGame() throws IllegalArgumentException {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while(true) {

            game();
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            String userInput=Console.readLine();

            if(userInput.equals("1")) {
                continue;
            }
            else if(userInput.equals("2")) {
                break;
            }
            else {
                throw new IllegalArgumentException();
            }
        }
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        startGame();
    }
}
