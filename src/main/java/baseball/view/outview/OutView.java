package baseball.view.outview;

import java.util.List;

public class OutView {

    public static void print(List<Integer> reportList) {
        int strikeCount = reportList.get(0);
        int ballCount = reportList.get(1);
        int nothingCount = reportList.get(2);

        if (nothingCount == 3) {
            System.out.println("낫싱");
        }

        if (ballCount != 0) {
            System.out.print(ballCount + "볼 ");
        }

        if (strikeCount != 0) {
            System.out.println(strikeCount + "스트라이크");
        }

    }
}
