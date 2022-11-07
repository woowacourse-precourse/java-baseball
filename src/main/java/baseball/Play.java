package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Play {
    static int restartOrFinish = 1;

    public static void checkEnd(String endAnswer) {
        if (endAnswer != "1" || endAnswer != "2") throw new IllegalArgumentException("새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public static void printAnswer(int[] strikeAndBallCount) {
        if (strikeAndBallCount[0] == 0 && strikeAndBallCount[1] == 0) {
            System.out.println("낫싱");
            return ;
        }

        if (strikeAndBallCount[0] != 0 && strikeAndBallCount[1] != 0) {
            System.out.println(strikeAndBallCount[1] + "볼 " + strikeAndBallCount[0] + "스트라이크");
            return ;
        }

        if (strikeAndBallCount[0] != 0 && strikeAndBallCount[1] == 0) {
            System.out.println(strikeAndBallCount[0] + "스트라이크 \n 3개의 숫자를 모두 맞히셨습니다! 게임종료 \n");
        }

        if (strikeAndBallCount[0] == 0 && strikeAndBallCount[1] != 0) {
            System.out.println(strikeAndBallCount[1] + "볼");
            return ;
        }
    }

    public static void checkReStart(int [] strikeAndBallCount){
        String endAnswer;

        try {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            endAnswer = readLine();
            restartOrFinish = Integer.parseInt(endAnswer);
            if(endAnswer != "1"){
                checkEnd(endAnswer);
            }

            return ;
        } catch (IllegalArgumentException e) {
            System.out.println(e.toString());
            return ;
        }
    }

}
