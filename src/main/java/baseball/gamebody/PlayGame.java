package baseball.gamebody;

import java.util.List;

import baseball.gamesetting.InputException;

public class PlayGame extends InputException {
    int nothing(List<String> playerNumber, List<String> computerNumber) {
        int overLapNumber = 0;
        for(String a : playerNumber) {
            if(computerNumber.contains(a)) {
                overLapNumber += 1;
            }
        }
        return overLapNumber;
    }
    
    void ballAndStrike(List<String> playerNumber, List<String> computerNumber) {
        int ball = 0;
        int strike = 0;
        
        for(String a : playerNumber) {
            if(computerNumber.contains(a)) {
                ball += 1;
            }
        }
        
        for(int i=0; i<3; i++) {
            if(playerNumber.get(i).equals(computerNumber.get(i))) {
                strike += 1;
            }
        }
        
        if(strike==0) {
            System.out.println(ball+ "볼");
        }else if(strike == ball) {
            System.out.println(strike+ "스트라이크");
        }else {
            ball -= strike;
            System.out.println(ball+ "볼 "+ strike+ "스트라이크");
        }
    }

    public void plaingGame(List<String> playerNumber, List<String> computerNumber) {
        if(this.nothing(playerNumber, computerNumber)==0) {
            System.out.println("낫싱");
        }else {
            this.ballAndStrike(playerNumber, computerNumber);
        }
    }
}
