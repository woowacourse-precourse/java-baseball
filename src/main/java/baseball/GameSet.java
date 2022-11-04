package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;


public class GameSet {
    private static List<Integer> computerAnswer;
    private static List<Integer> userAnswer;
    private static int strikeCount;
    private static int ballCount;

    public GameSet(){
        setComputerAnswer();
    }
    //랜덤으로 3자리수 숫자 만들어주는 함수
    public static void setComputerAnswer(){
        computerAnswer = new ArrayList<>();
        while(computerAnswer.size() < 3){
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!computerAnswer.contains(randomNumber)) {
                computerAnswer.add(randomNumber);
            }
        }
    }
    //게임을 시작하는 함수
    public static void playBaseballGame(){
        PrintMessage.inputUserNum();
        String inputNumber = Console.readLine();
        userAnswer = makeUserAnswer(inputNumber);
        ValidCheck.validInputNumber(userAnswer);
        compareAnswer();
        PrintMessage.ballStrikeMessage(ballCount, strikeCount);
    }
    // 입력값을 List<Integer> 형태로 변환해주는 함수
    public static List<Integer> makeUserAnswer(String inputNumber){
        List<String> inputArray = List.of(inputNumber.split(""));
        List<Integer> userSolution = new ArrayList<>();

        for(String number : inputArray){
            userSolution.add(Integer.parseInt(number));
        }
        return userSolution;
    }
    // 볼과 스트라이크 갯수를 세어주는 함수
    public static void compareAnswer(){
        strikeCount = 0;
        ballCount = 0;
        for(int i = 0; i < userAnswer.size(); i++){
            if(computerAnswer.indexOf(userAnswer.get(i)) == i){
                strikeCount++;
                continue;
            }
            if(computerAnswer.contains(userAnswer.get(i))){
                ballCount++;
            }
        }
    }
    public static boolean gameEndCheck(){
        if(strikeCount == 3){
            PrintMessage.answerMessage();
            PrintMessage.gameContinue();
            String userResponse = Console.readLine();
            if(userResponse.contains("1")){
                setComputerAnswer();
                return true;
            }
            if(userResponse.contains("2")){
                return false;
            }
            throw new IllegalArgumentException("1, 2 이외의 숫자를 입력하셨습니다");
        }
        return true;
    }
}
