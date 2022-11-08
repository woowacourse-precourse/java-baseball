package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class BaseballGameManager {

    private Pitches createComputerNumbers(){
        StringBuilder computer = new StringBuilder();
        while (computer.length() < 3) {
            char randomNumber = (char)(Randoms.pickNumberInRange(1, 9) + '0');
            if (computer.toString().indexOf(randomNumber) == -1) {
                computer.append(randomNumber);
            }
        }
        return new Pitches(computer.toString());
    }

    private boolean isGameover(){
        RestartGameOrNot userChoice = new RestartGameOrNot(Input.scanWhetherNewGame());
        return userChoice.gameover();
    }

    private void playGameOnce(){
        Pitches computer = createComputerNumbers();
        while(true) {
            Pitches pitches = new Pitches(Input.scanUserPitches());
            int strike = pitches.numOfStrike(computer);
            int ball = pitches.numOfBall(computer);
            Output.printBallCount(strike, ball);
            if(strike == 3){
                break;
            }
        }
    }

    public void startGame(){
        Output.printGameStartMessage();
        do{
            playGameOnce();
        }while(!isGameover());
    }
}
