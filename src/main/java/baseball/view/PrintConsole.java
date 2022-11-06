package baseball.view;

import baseball.model.Computer;

public class PrintConsole {

    public static void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void receiveNum(){
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void endGame(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public static String printResult(Computer resultComputer) {
        String printBall = printBall(resultComputer);
        String printStrike = printStrike(resultComputer);
        String printNothing = printNothing(resultComputer);

        int ball = resultComputer.getBall();
        int strike = resultComputer.getStrike();

        String result = "";
        if (ball > 0 && strike > 0) {
            result += printBall + " " + printStrike;
        } else {
            result += printBall;
            result += printStrike;
            result += printNothing;
        }
        result += '\n';
        System.out.println(result);
        return result;
    }

    private static String printBall(Computer resultComputer) {
        String ballToString = "";
        int resultBall = resultComputer.getBall();
        if (resultBall > 0) {
            ballToString += resultBall + "볼";
        }
        return ballToString;
    }

    private static String printStrike(Computer resultComputer) {
        String strikeToString = "";
        int resultStrike = resultComputer.getStrike();
        if (resultStrike > 0) {
            strikeToString += resultStrike + "스트라이크";
        }
        return strikeToString;
    }

    private static String printNothing(Computer resultComputer) {
        String nothingToString = "";
        boolean isNothing = resultComputer.getNothing();
        if (isNothing) {
            nothingToString += "낫싱";
        }
        return nothingToString;
    }

}
