package baseball.view;

import baseball.model.HintReq;

public class Output {
    public void hintPrint(HintReq hintReq) {
        printOnlyBall(hintReq);
        printOnlyStrike(hintReq);
        printBallAndStrike(hintReq);
        printNoting(hintReq);
    }

    private void printOnlyBall(HintReq hintReq) {
        if (hintReq.getBallCount() != 0 && hintReq.getstrikeCount() == 0) {
            System.out.println(hintReq.getBallCount() + "볼");
        }
    }

    private void printOnlyStrike(HintReq hintReq) {
        if (hintReq.getBallCount() == 0 && hintReq.getstrikeCount() != 0) {
            System.out.println(hintReq.getstrikeCount() + "스트라이크");
        }
    }

    private void printBallAndStrike(HintReq hintReq) {
        if (hintReq.getBallCount() != 0 && hintReq.getstrikeCount() != 0) {
            System.out.println(hintReq.getBallCount() + "볼 " + hintReq.getstrikeCount() + "스트라이크");
        }
    }

    private void printNoting(HintReq hintReq) {
        if (hintReq.getBallCount() == 0 && hintReq.getstrikeCount() == 0) {
            System.out.println("낫싱");
        }
    }
}
