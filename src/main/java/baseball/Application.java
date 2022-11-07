package baseball;

import baseball.appconfig.AppConfig;
import baseball.computer.Computer;
import baseball.manager.Manager;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        AppConfig appConfig = new AppConfig();
        Manager manager = appConfig.manager();
        Computer computer = appConfig.computer();

        manager.printGameStart();
        String RetryOrCloseProgramValue = "";
        while (!RetryOrCloseProgramValue.equals("2")) {
            List<Integer> computerNumbers = computer.createOtherNumber();
            String resultValue = "";
            while (!resultValue.equals("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료")) {
                manager.printInputGameValue();
                String gameValueOfUser = manager.inputGameValue();
                resultValue = computer.storeCorrectResult(gameValueOfUser, computerNumbers);
                manager.printCorrectResult(resultValue);
            }
            manager.printRetryOrCloseProgram();
            RetryOrCloseProgramValue = manager.inputRetryOrCloseProgram();
        }
    }
}
