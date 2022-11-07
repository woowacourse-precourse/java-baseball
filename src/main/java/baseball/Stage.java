package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Stage {
    private Number computerNumber;
    private Number userNumber;

    public Stage(Number computerNumber) {
        this.computerNumber = computerNumber;
    }

    public void progress() {
        System.out.print("숫자를 입력해주세요 : ");
        String line = Console.readLine();
        userNumber = new Number(line);
        StageResult stageResult = new StageResult(computerNumber, userNumber);
        stageResult.print();
    }

    public boolean isComplete() {
        return computerNumber.equals(userNumber);
    }
}
