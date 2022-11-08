package baseball;

public class Hint {
    static final String BALL = "볼";
    static final String STRIKE = "스트라이크";
    static final String NOTHING = "낫싱";

    int ball;
    int strike;

    public String toString() {
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

        for(int i = 0; i < Game.NUMBER_TOTAL; i++){
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
            hint += this.ball + BALL;
        }
        if(this.strike != 0){
            if(this.ball != 0){
                hint += " ";
            }
            hint += this.strike + STRIKE;
        }
        if (hint.equals("")){
            hint = NOTHING;
        }
        System.out.println(hint);
    }
}
