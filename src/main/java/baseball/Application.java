package baseball;

import camp.nextstep.edu.missionutils.Console;


public class Application {

    public static Computer computer;
    public static User user;

    public static int endGame;
    public static boolean strikeOut;

    public static int strikeNum;
    public static int ballNum;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        startGame();
    }

    public static void startGame() {
        endGame = 1;
        while(endGame==1){
            computer = new Computer();
            computer.generateTarget();
            user = new User();
            strikeOut = false;

            while(!strikeOut){
                strikeNum = 0;
                ballNum = 0;
                user.getUserInput();
                getStrikeNum();
                getBallNum();
                strikeOut = checkSuccesssAndPrintResult();
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            endGame = Integer.parseInt(Console.readLine());
        }
    }

    public static void getStrikeNum() {
        for (int i = 0; i < computer.NUM_LEN; ++i) {
            if (computer.target.get(i)
                    .equals(user.userInput[i])) {
                strikeNum++;
            }
        }
    }

    public static void getBallNum() {
        for (int i = 0; i < computer.NUM_LEN; ++i) {
            for (int j = -0; j < user.NUM_LEN; ++j) {
                if (computer.target.get(i)
                        .equals(user.userInput[j])
                        && i != j) {
                    ballNum++;
                }
            }
        }
    }

    public static boolean checkSuccesssAndPrintResult(){
        String result = "";
        if (strikeNum==3){
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        else if(strikeNum>0){
            result += Integer.toString(strikeNum) + "스트라이크";
        }
        if(ballNum>0){
            result = Integer.toString(ballNum) + "볼 "+result;
        }
        if(ballNum==0 && strikeNum==0){
            result = "낫싱";
        }
        System.out.println(result);
        return false;
    }

}
