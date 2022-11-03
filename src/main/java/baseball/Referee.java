package baseball;

import java.util.List;

public class Referee {

    int strike;
    int ball;

    Ball comBall = new Ball();
    Ball humanBall = new Ball();

    final String Strike = "스트라이크";
    final String Ball = "볼";
    final String Nothing = "낫싱";

    public Referee() {

    }
    public void playBall(){
        do {
            start();
            while(restart());
        }
    }

    private void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        giveHint();
    }

    public void giveHint() {
        comBall.makeComputerBalls();
        while(!isAnswer()){
            strike=0;
            ball=0;
            humanBall.makeHumanBalls();
            compareStrike(comBall, humanBall);
            compareBall(comBall, humanBall);
            if(strike==0&&ball==0){
                System.out.println(Nothing);
            }
            if(strike!=0&&ball!=0){
                System.out.println(ball+Ball+" "+strike+Strike);
            }
            if(strike!=0&&ball==0){
                System.out.println(strike+Strike);
            }
            if(strike==0&&ball!=0){
                System.out.println(ball+Ball);
            }
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void compareBall(Ball comBall, Ball humanBall) {
        for (int i = 0; i < comBall.size(); i++) {
            if (humanBall.contains(comBall.get(i)) && humanBall.indexOf(comBall.get(i)) != i) {
                ball++;
            }
        }
    }

    public void compareStrike(Ball comBall, Ball humanBall) {
        for (int i = 0; i < comBall.size(); i++) {
            if (humanBall.contains(comBall.get(i)) && humanBall.indexOf(comBall.get(i)) == i) {
                strike++;
            }
        }
    }

    public boolean isAnswer(){
        return strike==3;
    }
}
