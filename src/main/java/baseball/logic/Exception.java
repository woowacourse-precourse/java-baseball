package baseball.logic;

import java.util.List;

public class Exception {

    public List<Integer> inputException(List<Integer> playerInput){
        if(checkSame(playerInput) || checkThreedigit(playerInput) || checkZero(playerInput)){
            throw new IllegalArgumentException();
        }
        return playerInput;
    }

    private boolean checkSame(List<Integer> playerInput){
        for(int i=0; i<playerInput.size()-1; i++){
            if(playerInput.get(i)==playerInput.get(i+1)){
                return true;
            }
        }
        return false;
    }

    private boolean checkThreedigit(List<Integer> playerInput){
        if(!(playerInput.size()==3)){
            return true;
        }
        return false;
    }

    private boolean checkZero(List<Integer> playerInput){
        if(playerInput.contains(0)){
            return true;
        }
        return false;
    }
}
