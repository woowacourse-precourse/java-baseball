package baseball;

import java.util.List;

public class Game {

    private int ball;
    private int strike;


    public void play() throws IllegalArgumentException{
        boolean regame = false;
        do {
            List<Integer> computerBallsList = Computer.makeBalls();
            while (strike != Computer.BallsLength) {
                ball=0;
                strike=0;
                List<Integer> userBallsList = User.inputBalls();
                compareComputerAndUser(computerBallsList, userBallsList);
                printResult();
            }
            strike=0;
            regame = User.wantRegame();
        }while(regame);
    }

    private void compareComputerAndUser(List<Integer> computerBallsList, List<Integer> userBallsList) {
        for(int i=0; i<computerBallsList.size(); i++){
            if(userBallsList.contains(computerBallsList.get(i))){
                ball++;
            }
            if(computerBallsList.get(i)==userBallsList.get(i)){
                strike++;
            }
        }

        ball -= strike;
        /*System.out.println(computerBallsList.toString());
        System.out.println(userBallsList.toString());
        System.out.println("ball : "+ ball);
        System.out.println("strike : "+ strike);*/
    }


    private void printResult() {
        String message = "";

        if(ball==0 && strike==0){
            message = "낫싱";

        } else if (strike==Computer.BallsLength){
            message = strike +"스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";

        } else if(ball==0){
            message = strike + "스트라이크";

        } else if(strike==0){
            message = ball + "볼";

        } else {
            message = ball + "볼 "+ strike + "스트라이크";
        }

        System.out.println(message);
    }

}
