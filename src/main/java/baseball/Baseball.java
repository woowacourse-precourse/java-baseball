package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;

public class Baseball {
    public void run() {
        Core core = new Core();
        Utils utils = new Utils();
        List<Integer> computer = utils.generateRandomNumber(3);
        boolean endFlag = false;
        while (!endFlag) {
            System.out.print("숫자를 입력해주세요 : ");
            String userInput = readLine();
            utils.validateStringThreeDifferentDigits(userInput);
            List<Integer> user = utils.stringToIntegerList(userInput);

            int strikes = core.countStrike(computer, user);
            int balls = core.countBall(computer, user);
            core.printGameResult(strikes, balls);

            endFlag = core.isEndFlagged(strikes);
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
