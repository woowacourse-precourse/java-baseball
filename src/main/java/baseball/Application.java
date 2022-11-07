package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {

    public static final String optionOne = "1";
    public static final String optionTwo = "2";

    public static final String nothingMessage = "낫싱;";
    public static final String ballMessage = "볼";
    public static final String strikeMessage = "스트라이크";

    public static final String startMessage = "숫자 야구 게임을 시작합니다.";
    public static final String inputNumberMessage = "숫자를 입력해주세요 : ";
    public static final String successMessage = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public static void printMessage(String message){
        System.out.println(message);
    }

    public static List<Integer> createRandomNumber(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static String receiveInput(){
        String input = Console.readLine();
        return input;
    }

    public static void checkInputLength(String inputString, int len){
        if(inputString.length()!=len)
            throw new IllegalArgumentException();
    }

    public static List <Integer> checkInputInteger(String inputString){
        List<Integer> inputStringToIntegerList = new ArrayList<Integer>();
        for(int i=0; i<inputString.length(); i++){
            if('0'<=inputString.charAt(i) && inputString.charAt(i)<='9') {
                inputStringToIntegerList.add((int) inputString.charAt(i) - '0');
            }
        }
        if(inputStringToIntegerList.size()!=3)
            throw new IllegalArgumentException();
        return inputStringToIntegerList;
    }

    public static void checkInputDuplicate(List <Integer> input){
        int cntFrequency=0;
        for(int i=0; i<input.size(); i++){
            cntFrequency = Collections.frequency(input, input.get(i));
            if(cntFrequency!=1) throw new IllegalArgumentException();
        }
    }

    public static void checkOption(String curOption){
        if(!(curOption.equals(optionOne) || curOption.equals(optionTwo))){
            throw new IllegalArgumentException();
        }
    }

    public static List <Integer> guessResult(List <Integer> computer, List <Integer> player){
        List <Integer> result = new ArrayList<>();
        int ball = 0;
        int strike = 0;
        int index;
        for(int i=0; i<player.size(); i++){
            index = computer.indexOf(player.get(i));
            if(index==-1) {}
            else if(index==i) strike++;
            else ball++;
        }
        result.add(ball);
        result.add(strike);
        return result;
    }

    public static String createGuessResultMessage(List <Integer> result){
        int ball = result.get(0);
        int strike = result.get(1);
        String message = "";
        if(ball==0 && strike==0) message = nothingMessage;
        else if(ball==0 && strike!=0) message = Integer.toString(strike).concat(strikeMessage);
        else if(ball!=0 && strike==0) message = Integer.toString(ball).concat(ballMessage);
        else if(ball!=0 && strike!=0) message = ball + ballMessage+ " " + strike + strikeMessage;
        return message;
    }

    public static void startGame(List <Integer> computer){
        String inputString;
        List <Integer> input;
        List <Integer> result;
        String resultMessage;
        printMessage(startMessage);
        do{
            printMessage(inputNumberMessage);
            inputString = receiveInput();
            checkInputLength(inputString, 3);
            input = checkInputInteger(inputString);
            checkInputDuplicate(input);
            result = guessResult(computer, input);
            resultMessage = createGuessResultMessage(result);
            printMessage(resultMessage);
            if(result.get(1)==3) printMessage(successMessage);
        }while(!(result.get(1)==3));
    }


    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}