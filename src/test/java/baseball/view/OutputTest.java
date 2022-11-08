package baseball.view;

import baseball.model.HintReq;
import org.junit.jupiter.api.Test;

import static baseball.view.Output.*;
import static org.junit.jupiter.api.Assertions.*;

class OutputTest {

    @Test
    void 모두_프린트() {
        HintReq hintReq = new HintReq(2,0);
        System.out.println("볼만 프린트");
        hintPrint(hintReq);
    }

    @Test
    void 볼만있는_경우() {
        HintReq hintReq = new HintReq(2,0);
        System.out.println("볼만 프린트");
        OnlyBall(hintReq);
    }

    @Test
    void 스트라이크만있는_경우() {
        HintReq hintReq = new HintReq(0,2);
        System.out.println("스트라이크만 프린트");
        OnlyStrike(hintReq);
    }

    @Test
    void 볼과_스트라이크가_있는_경우() {
        HintReq hintReq = new HintReq(1,2);
        System.out.println("볼과_스트라이크 프린트");
        BallAndStrike(hintReq);
    }

    @Test
    void 낫싱() {
        HintReq hintReq = new HintReq(0,0);
        System.out.println("낫싱 프린트");
        Noting(hintReq);
    }
}