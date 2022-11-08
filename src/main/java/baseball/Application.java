package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        printStartMsg();
        while(true){
            String computer = getRandomNumber();
            startGame(computer);
            if(!getUserRestartEndNumber()) break;
        }

    }
    public static void startGame(String randomNum){
        while(true){
            printInputMsg();
            String userNumber = getInputNumber();

            int strikeCount = getStrikeCount(userNumber, randomNum);
            int ballCount = getBallCount(userNumber,randomNum);

            printGameResult(ballCount,strikeCount);

            if(isThreeStrike(strikeCount)){
                printEndMsg();
                break;
            }
        }
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
            if(isInvalidValue(userInputNumber)){
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

    public static void printEndMsg(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public static boolean getUserRestartEndNumber(){
        String input = Console.readLine();
        int num = Integer.parseInt(input);
        if(num==1){
            return true;
        }
        else if(num==2)
            return false;
        else{
            throw new IllegalArgumentException();
        }
    }

    public static boolean isInvalidValue(String userInputNum){
        List<Character> parsing = new ArrayList<>();
        for(char c : userInputNum.toCharArray()){
            if(!('1'<=c && '9'>=c)) return false; // 숫자가 아닌 경우
            int tmp = Integer.valueOf(c);
            if(parsing.contains(c)) return false; // 중복 숫자 있는 경우
            if(tmp<1 && tmp>9) return false; // 1~9 범위 안의 수가 아닌경우
        }
        if(parsing.size()>3) return false; // 세 자리 수가 아닌 경우
       return true;
    }

    public static int getBallCount(String userNumber, String randomNumber){
        int ballCount = 0;
        int strikeCount = getStrikeCount(userNumber, randomNumber);
        for(String number : userNumber.split("")){
            if(randomNumber.contains(number)){
                ballCount++;
            }
        }
        return ballCount-strikeCount;
    }

    public static int getStrikeCount(String userNumber, String randomNumber){
        int strikeCount = 0;
        for(int i=0;i<3;i++){
            if(userNumber.charAt(i)==randomNumber.charAt(i)){
                strikeCount++;
            }
        }
        return strikeCount;
    }
}
