package baseball;

public class HintMaker {
    Opponent opponent;

    public HintMaker(Opponent opponent){
        this.opponent=opponent;
    }

    private boolean isStrike(int key,int value){
        if(this.opponent.getNumbers().get(key)==value)
            return true;
        return false;
    }
    private boolean isBall(int key,int value){
        for(int i=0; i<3; i++){
            if(key==i) continue;
            if(this.opponent.getNumbers().get(i)==value)return true;
        }
        return false;
    }
    private int getValue(char value){
        return Character.getNumericValue(value);
    }

    public String getHintby(String input){
        String hint="";
        int strike=0;
        int ball=0;
        int value;
        for(int i=0; i<3; i++){
            value = getValue(input.charAt(i));
            if(isStrike(i,value)){
                strike++;
                continue;
            }
            if(isBall(i,value)) ball++;
        }
        hint += Integer.toString(strike)+Integer.toString(ball);
        return hint;
    }

}
