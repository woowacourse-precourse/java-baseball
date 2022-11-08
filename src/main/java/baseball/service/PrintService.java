package baseball.service;

import java.util.List;

public class PrintService {
    public void gameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void requestInput() {
        System.out.print("숫자를 입력해 주세요: ");
    }

    public void printStrikeBallResult(List<Integer> counts) {
        System.out.println(getResultString(counts));
    }

    public String getResultString(List<Integer> counts) {
        StringBuilder resultStringBuilder = new StringBuilder();
        boolean spacing = false;

        if (counts.get(1) != 0) {
            resultStringBuilder.append(counts.get(1));
            resultStringBuilder.append("볼");
            spacing = true;
        }

        if (counts.get(0) != 0) {
            if (spacing) {
                resultStringBuilder.append(" ");
            }

            resultStringBuilder.append(counts.get(0));
            resultStringBuilder.append("스트라이크");
        }

        if (resultStringBuilder.length() == 0) {
            resultStringBuilder.append("낫싱");
        }

        return resultStringBuilder.toString();
    }

    public void printGameEnd() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
