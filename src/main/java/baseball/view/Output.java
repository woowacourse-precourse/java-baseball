package baseball.view;

import baseball.model.HintReq;

public class Output {
    public static void hintPrint(HintReq hintReq) {
        OnlyBall(hintReq);
        OnlyStrike(hintReq);
        BallAndStrike(hintReq);
        Noting(hintReq);
    }

    private static void OnlyBall(HintReq hintReq) {
        if (hintReq.getBallCount() != 0 && hintReq.getStrikeCount() == 0) {
            System.out.println(hintReq.getBallCount() + "볼");
        }
    }

    private static void OnlyStrike(HintReq hintReq) {
        if (hintReq.getBallCount() == 0 && hintReq.getStrikeCount() != 0) {
            System.out.println(hintReq.getStrikeCount() + "스트라이크");
        }
    }

    private static void BallAndStrike(HintReq hintReq) {
        if (hintReq.getBallCount() != 0 && hintReq.getStrikeCount() != 0) {
            System.out.println(hintReq.getBallCount() + "볼 " + hintReq.getStrikeCount() + "스트라이크");
        }
    }

    private static void Noting(HintReq hintReq) {
        if (hintReq.getBallCount() == 0 && hintReq.getStrikeCount() == 0) {
            System.out.println("낫싱");
        }
    }
}
