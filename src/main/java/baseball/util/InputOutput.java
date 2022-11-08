package baseball.util;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputOutput extends StateCode{
    public static int readState(String msg){
        System.out.println(msg);

        String input;
        int parseInput = -1;
        try{
            input = Console.readLine();
            System.out.println(input);
            parseInput = Integer.parseInt(input);
        }catch (Error e){
            ThrowError(ERROR_INVALID_INPUT);
        }

        if(!GAME_STATES.contains(parseInput))
            ThrowError(ERROR_NONE_EXIST_GAME_STATE);

        return parseInput;
    }

    public static List<Integer> readBall(String msg){
        System.out.print(msg);

        String input = null;
        List<Integer> balls = new ArrayList<>();

        try{
            input = Console.readLine();
            System.out.println(input);
        }catch(Error e){
            ThrowError(ERROR_INVALID_INPUT);
        }

        if(input!=null && input.length() != DIGIT)
            ThrowError(ERROR_INCORRECT_LENGTH_DIGIT);

        for(int i=0; i < DIGIT; i++) {
            int num = input.charAt(i) - '0';
            if (balls.contains(num))
                ThrowError(ERROR_DUPLICATE_BALL);
            else if (!(1<=num && num<=9))
                ThrowError(ERROR_INVALID_BALL);
            balls.add(num);
        }

        return balls;
    }

    public static boolean writeStrikes(List<Integer> strikeAndBall){
        int nStrike = strikeAndBall.get(0);
        int nBall = strikeAndBall.get(1);
        if(nStrike == DIGIT)
        {
            System.out.println(DIGIT + "스트라이크");
            System.out.println(DIGIT + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        if(nStrike != 0 && nBall != 0)
            System.out.println(nBall + "볼 " + nStrike + "스트라이크");
        else if(nBall != 0)
            System.out.println(nBall+"볼");
        else if(nStrike != 0)
            System.out.println(nStrike + "스트라이크");
        else
            System.out.println("낫싱");
        return false;
    }
}
