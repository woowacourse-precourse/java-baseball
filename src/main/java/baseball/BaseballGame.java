package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BaseballGame {
    private List<Integer> computerNumber;
    BaseballGame()
    {
        System.out.println("숫자 야구 게임을 시작합니다.");
        randomize();
        play();
    }
    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    static List<Integer> StrToNumericList(String input){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            list.add(Character.getNumericValue(input.charAt(i)));
        }
        return list;
    }
    static boolean sizeNotThree(List<Integer> inputList){
        if (inputList.size() != 3)
            return true;
        return false;
    }

    static boolean numberIsZero(List<Integer> inputList) {
        for (int i = 0; i < 3; i++) {
            if (inputList.get(i) == 0) {
                return true;
            }
        }
        return false;
    }
    static boolean isDuplicate(List<Integer> inputList){
        for (int i = 0; i < 2; i++) {
            for (int j = i + 1; j < 3; j++)
                if (inputList.get(i) == inputList.get(j))
                    return true;
        }
        return false;
    }

    static void printResult(int strike, int ball){
        if(ball == 0 && strike == 0)
            System.out.println("낫싱");
        else if(ball > 0 && strike > 0)
            System.out.println(ball + "볼 " + strike + "스트라이크");
        else if(ball > 0 && strike == 0)
            System.out.println(ball + "볼");
        else if(ball == 0 && strike > 0) {
            if(strike == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            }
            else
                System.out.println(strike + "스트라이크");
        }
    }
    static List<Integer> countBallAndStrike(List<Integer> computerList, List<Integer> inputList){ // 배열로 묶어서 주기
        int strike = 0;
        int ball = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (computerList.get(i) == inputList.get(j)){
                    if(i == j)
                        strike++;
                    else
                        ball++;
                }
            }
        }
        list.add(strike);
        list.add(ball);
        return list;
    }

    public void randomize() {
        computerNumber = new ArrayList<>();
        while (computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
    }

    public void play(){
        String input, retry;
        int strike, ball;
        boolean win = false;
        List<Integer> inputList;
//        Scanner scanner = new Scanner(System.in);

        while(!win){
            try{
                System.out.print("숫자를 입력해주세요 : ");
                input = Console.readLine();
                if(!isNumeric(input))
                    throw new IllegalArgumentException();
                inputList = StrToNumericList(input);
                if(sizeNotThree(inputList) || numberIsZero(inputList) || isDuplicate(inputList)) {
                    throw new IllegalArgumentException();
                }
            }
            catch(IllegalArgumentException e){
                e.printStackTrace();
                return;
            }
            strike = countBallAndStrike(computerNumber, inputList).get(0);
            ball = countBallAndStrike(computerNumber, inputList).get(1);
            printResult(strike, ball);

            if(strike == 3){
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                retry = Console.readLine();
                try{
                    if(retry.equals("1")) {
                        win = false;
                        randomize();
                    }
                    else if(retry.equals("2"))
                        win = true;
                    else
                        throw new IllegalArgumentException();
                }
                catch(IllegalArgumentException e){
                    e.printStackTrace();
                    return;
                }
            }
        }
    }
}
