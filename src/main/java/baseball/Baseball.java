package baseball;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Baseball {
    public void run() {
        Core T = new Core();
        List<Integer> computer = T.generateRandomNumber(3);
        boolean endFlag=false;
        while(!endFlag){
            System.out.print("숫자를 입력해주세요 : ");
            String userInput = readLine();
            T.validateUserInputThreeDifferentNumbers(userInput);
            List<Integer> user = T.stringToIntegerList(userInput);

            int strikes = T.countStrike(computer, user);
            int balls = T.countBall(computer, user);
            T.printGameResult(strikes, balls);

            endFlag = T.isEndFlagged(strikes);
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
