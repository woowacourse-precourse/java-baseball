package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Play {
    static int restartOrEnd;

    public static void setRestart() {
        String checkUserAnswer;
        checkUserAnswer = readLine();

        if(checkUserAnswer.equals("1"))  {
            restartOrEnd = 1;
            System.out.println("aaaaaaaaaaaaa");
        }
        if(checkUserAnswer.equals("2"))  {
            restartOrEnd = 2;
            System.out.println("aaaaaaaaaaaaa");
        }
    }

    public static int getRestartOrEnd (){
        return restartOrEnd;
    }
}
