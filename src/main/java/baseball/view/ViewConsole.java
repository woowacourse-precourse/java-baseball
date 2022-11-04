package baseball.view;

import java.util.List;

public class ViewConsole implements Viewable {

    private final int IndexOfBall = 0;
    private final int IndexOfStrike = 1;


    @Override
    public void printHint(List<Integer> hints) {
        int Ball = hints.get(IndexOfBall);
        int Strike = hints.get(IndexOfStrike);

        calBallCount(Ball, Strike);

    }

    private static void calBallCount(int Ball, int Strike) {
        if (Ball != 0 && Strike != 0) {
            System.out.println(Ball + "볼" + " " + Strike + "스트라이크");
            return;
        }

        if (Ball != 0) {
            System.out.println(Ball + "볼");
            return;
        }

        if (Strike != 0) {
            System.out.println(Strike + "스트라이크");
            return;
        }

        System.out.println("낫싱");
    }

    @Override
    public void printStart() {

    }

    @Override
    public void printInput() {

    }

    @Override
    public void printEnd() {

    }

    @Override
    public void printIsContinue() {

    }

}
