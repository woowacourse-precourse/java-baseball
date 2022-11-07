package baseball;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Randoms;

public class PlayNumberBaseballGame {

    public List<Integer> createRandomNumberOfComputer() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public String outputGameStartStatement() {
        return "숫자 야구 게임을 시작합니다.";
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

    public boolean isThreeStrike(List<Integer> computer, List<Integer> player) {
        if (Arrays.equals(computer.toArray(), player.toArray())) {
            return true;
        }
        return false;
    }

    public boolean isStrike(int computerNum, int playerNum){
        if(computerNum==playerNum){
            return true;
        }
        return false;
    }

    public boolean isBall(List<Integer> computer, int playerNum){
        if(computer.contains(playerNum)){
            return true;
        }
        return false;
    }

    public String outputResultComparisonOfNumbers(int strike, int ball){
        String result="";

        if(strike==3){
            result = "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";
        }
        else if(ball==0 && strike==0){
            result= "낫싱";
        }
        else {
            if (ball > 0) {
                result=String.valueOf(ball)+"볼 ";
            }
            if (strike > 0) {
                result+=(String.valueOf(strike)+"스트라이크");
            }
        }
        return result;
    }

    public String outputAskPlayNewGameStatement(){
        return "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    }

    public boolean isNewGame(int playerAnswer){
        if(playerAnswer==1) {
            return true;
        }
        return false;
    }
}
