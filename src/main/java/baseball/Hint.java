package baseball;

public class Hint {
    public int strike;
    private int ball;

    public void getHint(int[] userNumber, int[] computerNumber){
        for (int i = 0; i < 3; i++){
            countStrike(userNumber[i], computerNumber[i]);
            countBall(userNumber[i], computerNumber, i);
        }

        printHint();
    }

    private void printHint(){
        if (this.ball > 0) {
            System.out.print(this.ball + "볼 ");
        }
        if (this.strike > 0) {
            System.out.print(this.strike + "스트라이크 ");
        }
        if (this.ball == 0 && this.strike == 0) {
            System.out.print("낫싱");
        }
        System.out.println();
    }
    private void countStrike(int user, int computer){
        if (user == computer){
            this.strike++;
        }
    }
    private void countBall(int user, int[] computerNumber, int presentIndex){
        for (int i = 0; i < 3; i++){
            if (presentIndex != i && computerNumber[i] == user){
                this.ball++;
            }
        }
    }
}
