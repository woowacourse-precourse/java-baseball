package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> number;
    public static final int NUMBER_LENGTH = 3;


    public Computer(){
        number = this.make3RandomNumber();
    }
    private List<Integer> make3RandomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }


    public void printResult(List<Integer> playerNumber) {
        int[] strikeAndBallCount = getStrikeAndBallCount(playerNumber);
        int strike = strikeAndBallCount[0];
        int ball = strikeAndBallCount[1];

        if(strike == NUMBER_LENGTH){
            System.out.println(buildResultSentence(strike, ball));
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }else{
            System.out.println(buildResultSentence(strike, ball));
        }
    }

    private int[] getStrikeAndBallCount(List<Integer> playerNumber) {
        int[] cnt = new int[2];
        for(int i=0; i<playerNumber.size(); i++){
            if(this.number.get(i) == playerNumber.get(i)){
                cnt[0]++;
            }else if(this.number.contains(playerNumber.get(i))){
                cnt[1]++;
            }
        }
        return cnt;
    }

    private String buildResultSentence(int strike, int ball){
        StringBuilder sb = new StringBuilder();
        if(ball != 0){
            sb.append(ball).append("볼 ");
        }
        if(strike != 0){
            sb.append(strike).append("스트라이크");
        }
        if(ball == 0 && strike == 0){
            sb.append("낫싱");
        }
        return sb.toString().strip();
    }
}
