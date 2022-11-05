package baseball;
import  camp.nextstep.edu.missionutils.Randoms;
import static camp.nextstep.edu.missionutils.Console.readLine;
import java.io.*;
import java.util.*;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException{
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true){
            start();
        }
    }

    public static void start() throws IllegalArgumentException{
        List<Integer> computerNumber = computerNumber();
        List<Integer> strikeBallList;
        String input;
        int strike, ball;
        while (true){
            System.out.print("숫자를 입력해주세요 : ");
            input = readLine();
            inputCheck(input);

        }

    }

    public static List<Integer> computerNumber(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static void inputCheck(String input) throws IllegalArgumentException {
        Set<Character> overlapcheck = new HashSet<>();
        for (int i = 0; i < input.length(); i++){
            overlapcheck.add(input.charAt(i));
        }
        if (input.matches("[0-9]") && overlapcheck.size() == 3) return;
        if (input.matches("[1-2]{1}"))  return;
        new IllegalArgumentException("잘못된 입력입니다.");
    }

    public static List<Integer> checkStrikeBall(List<Integer> userNumber, List<Integer> computerNumber){
        int strikeCount = 0, ballCount = 0;
        for (int i = 0; i < 3; i++){ // 스트라이크와 볼을 계산, 스트라이크 일 경우에도 볼 + 1을 해준다. 따라서 최종 볼은 볼 - 스트라이크다.
            if (Objects.equals(userNumber.get(i), computerNumber.get(i))){
                strikeCount++;
            }
            if (computerNumber.contains(userNumber.get(i))){
                ballCount++;
            }
        }
        return Arrays.asList(strikeCount,ballCount - strikeCount);
    }

    public static boolean endGame(int strike, int ball){ // 스트라이크와 볼의 수를 출력하고 스트라이크 == 3이면 true를 리턴한다.
        if (strike == 0 && ball == 0) System.out.println("낫싱");
        else if (strike != 0 && ball != 0){
            System.out.println(ball+"볼 "+strike+"스트라이크");
        }
        else if (ball == 0) {
            System.out.println(strike+"스트라이크");
            if (strike == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                return true;
            }
        }
        else {
            System.out.println(ball+"볼");
        }
        return false;
    }

}
