package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        String computer = getRandomNumber();
        printStartMsg();
        printInputMsg();
        String userInput = getInputNumber();
    }

    public static String getRandomNumber(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        StringBuffer sb = new StringBuffer();
        for(Integer x : computer){
            sb.append(x);
        }
        return sb.toString();
    }

    public static void printStartMsg(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printInputMsg(){
        System.out.print("숫자를 입력해주세요 : ");
    }
    public static String getInputNumber(){
        String userInputNumber = Console.readLine();

        try{
            if(isInvalidNumber(userInputNumber)){
                throw new IllegalArgumentException();
            }
        } catch(NumberFormatException e){
            throw new IllegalArgumentException();
        }
        return userInputNumber;
    }
    public static void printGameResult(int ballCount, int strikeCount){
        StringBuilder result = new StringBuilder();

        if(ballCount!=0){
            result.append(ballCount+"볼");
        }
        if(ballCount!=0){
            if(result.length()!=0){
                result.append(" ");
            }
            result.append(strikeCount+"스트라이크");
        }

        if(result.length()==0){
            result.append("낫싱");
        }
    }

    public static boolean isThreeStrike(int strikeCount){
        if(strikeCount == 3){
            return true;
        }
        return false;
    }
}
