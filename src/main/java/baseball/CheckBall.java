package baseball;

import java.util.List;

public class CheckBall {
    private CheckBall(){
    }
    public static int ball(String args, List<String> computer){
        int ball = 0;
        for(int idx=0 ; idx<3 ; idx++){
            Character arg = args.charAt(idx);
            String str = arg.toString();
            if(computer.contains(str)){
                ball = isitball(arg,computer,idx,ball);
            }
        }
        return ball;
    }

    public static int isitball(Character arg,List<String> computer, int idx, int ball){
        String str = computer.get(idx);
        Character chr = str.charAt(0);
        if(chr != arg){
            ball += 1;
        }
        return ball;
    }
}
