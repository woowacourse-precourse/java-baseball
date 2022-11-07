package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List <Integer> answer = Collections.emptyList();

        while(true){

            gameStart();
            answer = makeRandomAnswer();
            gamePlay(answer);

            if(gameFinish().equals("2")){
                break;
            }

        }

    }
    private static void gameStart(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private static List<Integer> makeRandomAnswer(){
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {

            int randomNumber = Randoms.pickNumberInRange(1,9);

            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }

        }

        return computer;
    }

    public static void exceptionCheck(String input){
        int asciiNumberZero = 48;
        int asciiNumberNine = 57;

        // 숫자의 개수가 3개가 아닌경우
        if(input.length() != 3){
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
        // 0을 입력한 경우
        if(input.contains("0")) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
        // 숫자가 아닌것을 입력한 경우
        for(int i = 0; i < 3; i++){

            if((int)input.charAt(i) < asciiNumberZero || asciiNumberNine < (int)input.charAt(i)){
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }

        }
        // 중복된 숫자를 입력한 경우
        int i = 0;

        for(i = 0; i < 2; i++){

            if(input.charAt(i) == input.charAt(i+1)){
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }

        }

    }

    private static List<Integer> userInput(){
        List<Integer> input = new ArrayList<>();

        System.out.print("숫자를 입력해주세요 : ");
        String inputString = Console.readLine();

        exceptionCheck(inputString);

        int index = 0;

        while (input.size() < 3){
            int inputNumber = Integer.parseInt(inputString.substring(index, index+1));
            input.add(inputNumber);
            index++;
        }

        return input;
    }

    private static String stateBallAndStrike(int ball,int strike){
        String printStateOfBallAndStrike = "";

        if(ball == 0 && strike == 0){
            printStateOfBallAndStrike = "낫싱";
        } else if(ball == 0){
            printStateOfBallAndStrike = (strike + "스트라이크");
        } else if(strike == 0){
            printStateOfBallAndStrike = (ball + "볼");
        } else{
            printStateOfBallAndStrike = (ball + "볼 " + strike +  "스트라이크");
        }

        return printStateOfBallAndStrike;
    }

    public static String getBallAndStrike(List <Integer> answer, List <Integer> user){
        int numberOfStrike = 0;
        int numberOfBall = 0;
        String printStateOfBallAndStrike = "";

        for(int i = 0; i < 3; i++){

            if(answer.contains(user.get(i))){
                numberOfBall++;
            }

        }

        for(int i = 0; i < 3; i++){

            if(answer.get(i).equals(user.get(i))){
                numberOfStrike++;
                numberOfBall--;
            }

        }

        printStateOfBallAndStrike = stateBallAndStrike(numberOfBall,numberOfStrike);
        return printStateOfBallAndStrike;
    }

    private static void gamePlay(List <Integer> answer){
        List <Integer> user = Collections.emptyList();
        String threeStrike = "3스트라이크";

        while(true){
            user = userInput();
            System.out.println(getBallAndStrike(answer,user));

            if(getBallAndStrike(answer,user).equals(threeStrike)) {
                break;
            }

        }

    }

    private static String gameFinish(){
        String finishCode = "";

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        finishCode = Console.readLine();

        return finishCode;
    }
}
