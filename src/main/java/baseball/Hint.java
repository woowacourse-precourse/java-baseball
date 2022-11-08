package baseball;

public class Hint {
    int ball;
    int strike;

    public String toString(){
        return "ball: " + this.ball + ", strike: " + this.strike;
    }

    private void addBallCount() {
        this.ball++;
    }

    private void addStringCount(){
        this.strike++;
    }

    void checkAnswer(Game userAnswer, Game computerAnswer){
        int nowNumber;

        for(int i=0; i<3; i++){
            nowNumber = userAnswer.number[i];

            if(!Function.checkArrayContain(computerAnswer.number, nowNumber)){
                continue;
            }
            if(i==Function.checkStrike(computerAnswer.number, nowNumber)){
                addStringCount();
                continue;
            }
            addBallCount();
        }
    }

    void showHint() {
        String hint = "";
        if(this.ball !=0) {
            hint += this.ball + "볼";
        }
        if(this.strike != 0){
            if(this.ball != 0){
                hint += " " + this.strike + "스트라이크";
            }
        }
        if (hint.equals("")){
            hint = "낫싱";
        }
        System.out.println(hint);
    }
}
