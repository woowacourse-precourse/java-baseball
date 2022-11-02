package baseball;



import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class IO extends StateCode{
    public int readState(String msg){
        System.out.println(msg);
        int parseInput = -1;
        try{
            String input = Console.readLine();
            parseInput = Integer.parseInt(input);
        }catch (Error e){
            ThrowError(ERROR_NOT_INTEGER);
        }
        if(!GAME_STATES.contains(parseInput))
            ThrowError(ERROR_NONE_EXIST_GAME_STATE);

        System.out.println(parseInput);
        return parseInput;
    }

    public String readStr(String msg){
        System.out.print(msg);
        String input = Console.readLine();
        System.out.println(input);
        return input;
    }

    public boolean writeStrikes(List<Integer> strikeAndBall){
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
