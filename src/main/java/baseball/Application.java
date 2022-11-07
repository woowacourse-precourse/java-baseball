package baseball;
import  camp.nextstep.edu.missionutils.Randoms;
import static camp.nextstep.edu.missionutils.Console.readLine;
import java.io.*;
import java.util.*;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException{
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true){
            gameStart();
            if (restartCheck()) return;
        }
    }

    public static void gameStart() throws IllegalArgumentException{
        List<Integer> computerNumber = makeComputerNumber();
        List<Integer> strikeBallList;
        List<Integer> userNumber;
        String input;

        do {
            System.out.print("숫자를 입력해주세요 : ");
            input = readLine();
            userNumberInputCheck(input);
            userNumber = makeUserNumber(input);
            strikeBallList = checkStrikeBall(userNumber, computerNumber);
            printStrikeBallList(strikeBallList.get(0), strikeBallList.get(1));
        } while (!endGameCheck(strikeBallList.get(0)));
    }

    public static List<Integer> makeComputerNumber(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static void userNumberInputCheck(String input) throws IllegalArgumentException {
        Set<Character> overlapCheck = new HashSet<>();
        for (int i = 0; i < input.length(); i++){
            overlapCheck.add(input.charAt(i));
        }
        if (input.matches("[0-9]+") && overlapCheck.size() == 3) return;
        throw new IllegalArgumentException("잘못된 입력입니다.");
    }

    public static void startEndInputCheck(String input) throws IllegalArgumentException {
        if (input.matches("[1-2]{1}"))  return;
        throw  new IllegalArgumentException("잘못된 입력입니다.");
    }

    public static List<Integer> makeUserNumber(String input){
        int num1 = Character.getNumericValue(input.charAt(0));
        int num2 = Character.getNumericValue(input.charAt(1));
        int num3 = Character.getNumericValue(input.charAt(2));
        return Arrays.asList(num1,num2,num3);
    }

    public static List<Integer> checkStrikeBall(List<Integer> userNumber, List<Integer> computerNumber){
        int strikeCount = 0, ballCount = 0;
        for (int i = 0; i < 3; i++){ // 스트라이크와 볼을 계산, 스트라이크 일 경우에도 볼 + 1을 해준다. 따라서 최종 볼은 볼 - 스트라이크다.
            if (Objects.equals(userNumber.get(i), computerNumber.get(i))) strikeCount++;
            if (computerNumber.contains(userNumber.get(i))) ballCount++;
        }
        return Arrays.asList(strikeCount,ballCount - strikeCount);
    }

    public static void printStrikeBallList(int strike, int ball){ // 스트라이크와 볼의 수를 출력하고 스트라이크 == 3이면 true를 리턴한다.
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
            return;
        }

        StringBuilder printStrikeBall = new StringBuilder();
        if (ball > 0) printStrikeBall.append(ball).append("볼 ");
        if (strike > 0) printStrikeBall.append(strike).append("스트라이크 ");
        System.out.println(printStrikeBall);
    }

    public static boolean endGameCheck(int strike){
        if (strike == 3) {
            System.out.println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }

    public static boolean restartCheck() throws IllegalArgumentException{
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = readLine();
        startEndInputCheck(input);
        return "1".equals(input);
    }
}
