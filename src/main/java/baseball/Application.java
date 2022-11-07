package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;

public class Application{

    static List<Integer> computerNumber = new ArrayList<>();
    static List<Integer> userNumber = new ArrayList<>();
    static Integer strikeCount = 0;
    static Integer ballCount = 0;

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while(true) {
            createRandomNumber();
            Integer gameResult = startUserGame();
            if(gameResult == 2){
                break;
            }else if(gameResult == 1){
                resetValue();
            }
        }
    }

    // 랜덤함수생성
    public static void createRandomNumber(){
        while (computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
    }

    // 게임스타트
    public static Integer startUserGame(){
        if(strikeCount != 3){
            userInputNumbers();
            countStrikeAndBall();
            printStrikeAndBall();
            return 0;
        }else{
            return answerNumber();
        }
    }

    // 사용자 입력 및 유효성검사
    public static void userInputNumbers(){
        userNumber.removeAll(userNumber);

        System.out.print("숫자를 입력해주세요 : ");
        String inputStr = readLine();
        HashSet<String> overlapCheck = new HashSet<>();

        Arrays.stream(inputStr.split("")).forEach(f -> {
            overlapCheck.add(f);
            userNumber.add(Integer.parseInt(f));
        });

        if(!inputStr.matches("[0-9]{3}") || overlapCheck.size() != 3){
            throw new IllegalArgumentException("잘못된 값을 입력했습니다.");
        }
    }

    // ball & strike count
    public static void countStrikeAndBall(){
        strikeCount = 0;
        ballCount = 0;

        for(int i=0; i<computerNumber.size(); i++){
            if(computerNumber.get(i) == userNumber.get(i)){
                strikeCount++;
            }else if(computerNumber.contains(userNumber.get(i))){
                ballCount++;
            }
        }
    }

    // ball & strike info print
    public static void printStrikeAndBall(){
        if(ballCount > 0 && strikeCount > 0){
            System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
        }else if(strikeCount > 0){
            System.out.println(strikeCount + "스트라이크");
        }else if(ballCount > 0){
            System.out.println(ballCount + "볼");
        }else{
            System.out.println("낫싱");
        }
    }

    // 정답 이후 로직(재시작 or 종료)
    public static Integer answerNumber(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String newGameChoice = readLine();

        if(newGameChoice.matches("[1-2]{1}")){
            return Integer.parseInt(newGameChoice);
        }else{
            throw new IllegalArgumentException("잘못된 값을 입력했습니다.");
        }
    }

    // 전역변수 reset
    public static void resetValue(){
        strikeCount = 0;
        ballCount = 0;
        computerNumber.removeAll(computerNumber);
    }
}