package baseball.logic;

public class Exception {

    public String inputException(String num){
        if(checkSame(num) || checkThreedigit(num)){
            throw new IllegalArgumentException();
        }
        return num;
    }

    private boolean checkSame(String num){
        for(int i=0; i<num.length()-1; i++){
            if(num.charAt(i)==num.charAt(i+1)){
                return true;
            }
        }
        return false;
    }

    private boolean checkThreedigit(String num){
        if(!(num.length()==3)){
            return true;
        }
        return false;
    }
}
