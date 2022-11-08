package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Play {
    static int restartOrEnd;

    public static void setRestart() {
        String checkUserAnswer;
        checkUserAnswer = readLine();

        if(checkUserAnswer.equals("1"))  {
            restartOrEnd = 1;
        }
        if(checkUserAnswer.equals("2"))  {
            restartOrEnd = 2;
        }
    }

    public static int getRestartOrEnd (){
        return restartOrEnd;
    }
}
