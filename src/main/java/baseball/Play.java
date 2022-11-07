package baseball;
import static baseball.Application.*;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Play {

    public static void setRestart() {
        String checkUserAnswer;
        checkUserAnswer = readLine();

        if(checkUserAnswer == "1")  restartOrEnd = 1;
        if(checkUserAnswer == "2")  restartOrEnd = 2;


    }
}
