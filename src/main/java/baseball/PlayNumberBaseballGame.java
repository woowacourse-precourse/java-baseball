package baseball;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import baseball.GameProgressLine;
import baseball.InputException;

public class PlayNumberBaseballGame {
    List<Integer> computerRandomNumbers = new ArrayList<>();
    List<Integer> playerInputNumbers = new ArrayList<>();
    private boolean isAnswer=false;

    public void playNumberBaseballOneGame(){
        isAnswer=false;
        computerRandomNumbers=setRandomNumberOfComputer();

        while (!isAnswer) {
            System.out.println(GameProgressLine.PLAYER_INPUT_LINE.getLine());
            playerInputNumbers = getInputNumbersOfPlayer();
            String outputResultLine = compareNumbersBetweenComputerAndPlayer(computerRandomNumbers, playerInputNumbers);
            System.out.println(outputResultLine);
            playerInputNumbers.clear();
        }
        computerRandomNumbers.clear();

        System.out.println(GameProgressLine.ASK_RETRY_LINE.getLine());
        boolean retry = isRetry();
        if(retry){
           playNumberBaseballOneGame();
        }
    }

    public List<Integer> setRandomNumberOfComputer() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public List<Integer> getInputNumbersOfPlayer(){

        String inputLine = Console.readLine();
        InputException.inputNotThreeNumberException(inputLine);
        InputException.inputHasSameCharException(inputLine);

        List<Integer> player = new ArrayList<>();
        for(int location = 0; location<inputLine.length(); location++){
            player.add(inputLine.charAt(location)-'0');
        }

        return  player;
    }

    public String compareNumbersBetweenComputerAndPlayer(List<Integer> computer, List<Integer> player) {
        String compareResult = "";
        int strike = 0;
        int ball = 0;

        if (isThreeStrike(computer, player)) {
            strike = 3;
            compareResult = outputResultComparisonOfNumbers(strike, ball);
            return compareResult;
        }

        for (int numberLocation = 0; numberLocation < 3; numberLocation++) {
            if (isStrike(computer.get(numberLocation), player.get(numberLocation))) {
                strike++;
            } else if (isBall(computer, player.get(numberLocation))) {
                ball++;
            }
        }

        compareResult = outputResultComparisonOfNumbers(strike, ball);
        return compareResult;
    }

    private boolean isThreeStrike(List<Integer> computer, List<Integer> player) {
        if (Arrays.equals(computer.toArray(), player.toArray())) {
            return true;
        }
        return false;
    }

    private boolean isStrike(int computerNum, int playerNum){
        if(computerNum==playerNum){
            return true;
        }
        return false;
    }

    private boolean isBall(List<Integer> computer, int playerNum){
        if(computer.contains(playerNum)){
            return true;
        }
        return false;
    }

    private String outputResultComparisonOfNumbers(int strike, int ball){
        String result="";

        if(strike==3){
            isAnswer=true;
            result = "3스트라이크\n";
            result += GameProgressLine.END_LINE.getLine();
        }
        else if(ball==0 && strike==0){
            result= "낫싱";
        }
        else if(ball==0 && strike>0){
            result= String.valueOf(strike)+"스트라이크";
        }
        else if(ball>0 && strike==0){
            result=String.valueOf(ball)+"볼";
        }
        else {
            result=String.valueOf(ball)+"볼 "+String.valueOf(strike)+"스트라이크";
        }
        return result;
    }

    public boolean isRetry(){
        String inputLine = Console.readLine();
        InputException.inputNotOneOrTwoException(inputLine);

        if(inputLine.equals("1")) {
            return true;
        }
        return false;
    }
}
