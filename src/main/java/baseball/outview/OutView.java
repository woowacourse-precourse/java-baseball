package baseball.outview;

import java.util.List;

public class OutView {

    public boolean print(List<Integer> reportList) {
        int strikeCount = reportList.get(0);
        int ballCount = reportList.get(1);
        int nothingCount = reportList.get(2);

        if (strikeCount == 3) {
            System.out.print(3 + "스트라이크");
            return true;
        }
        if (nothingCount == 3) {
            System.out.println("낫싱");
        }
        if (strikeCount != 0){
            System.out.println(strikeCount+"스트라이크");
        }
        if (ballCount != 0){
            System.out.println(ballCount+"볼");
        }
        return false;
    }
}
