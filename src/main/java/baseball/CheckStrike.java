package baseball;

import java.util.List;

public class CheckStrike {
    private CheckStrike() {
    }
    public static int strike(String args, List<String> computer){
        int strike = 0;
        for(int i=0; i<3 ; i++){
            Character arg = args.charAt(i);
            String str = computer.get(i);
            Character ans = str.charAt(0);
            strike = isitstrike(arg,ans,strike);
        }
        return strike;
    }

    public static int isitstrike(Character arg, Character ans, int val){
        int strike = val;
        if(arg == ans){
            strike += 1;
        }
        return strike;
    }
}
