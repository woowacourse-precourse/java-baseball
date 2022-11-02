package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        final int RESTART = 1;
        final int GAME_OVER = 2;

        while(true) {
            List<Integer> computerNumber = computerRanmdomNumberExtract();
            System.out.println("computerNumber = " + computerNumber);
            playGame(computerNumber);
            if(getUserDecision()==GAME_OVER){
                break;
            }
        }

    }

    private static void playGame(List<Integer> computerNumber) {
        while(true){
        System.out.print("숫자를 입력하세요 : ");
        String inputUserNumber = Console.readLine();

        isInputAlright(inputUserNumber);
        List<Integer> userNumberList = inputProcess(inputUserNumber);

        int strike = 0;
        int ball = 0;
        if(playBall(computerNumber, userNumberList, strike, ball)){
            break;
        }
        }
    }

    private static Integer getUserDecision() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        Integer user_decision = Integer.parseInt(Console.readLine());
        System.out.println("user_decision = " + user_decision);
        return user_decision;
    }

    private static boolean playBall(List<Integer> computerNumber, List<Integer> userNumberList,
        int strike, int ball) {
        for(int i=0; i<3; i++){
            if(userNumberList.get(i) == computerNumber.get(i)){
                strike++;
            }
            else {
                ball = getBall(computerNumber, userNumberList, ball, i);
            }
        }
        printGameResult(strike,ball);
        if(strike==3){
            return true;
        }
        return false;
    }

    private static void printGameResult(int strike, int ball) {
        if(strike ==3){
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
        else if(strike ==0 && ball ==0){
            System.out.println("낫싱");
        }
        else{
            System.out.println(ball +"볼 " + strike + "스트라이크");
        }
    }

    private static int getBall(List<Integer> computerNumber, List<Integer> userNumberList, int ball,
        int i) {
        for(int j=0; j<3; j++){
            if(i ==j){
                continue;
            }
            if(userNumberList.get(i) == computerNumber.get(j))
            {
                ball++;
            }
        }
        return ball;
    }


    public static List<Integer> inputProcess(String userNumber) {
        return convertStringToIntegerList(userNumber);
    }

    public static List<Integer> convertStringToIntegerList(String userNumber) {
        List<Integer> userNumberList = new ArrayList<>();
        for(int i=0; i<3; i++){
            int putNumber = Character.getNumericValue(userNumber.charAt(i));
            userNumberList.add(putNumber);
        }
        return userNumberList;
    }

    public static List<Integer> computerRanmdomNumberExtract() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static void isInputAlright(String user1) {
        if(user1.length()!=3){
            throw new IllegalArgumentException("입력 오류");
        }
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                inputOverlapCheck(user1, i, j);
            }
        }
    }

    public static void inputOverlapCheck(String user1, int i, int j) {
        if(i == j){
            return;
        }
        if(user1.charAt(j) == user1.charAt(i))
        {
            throw new IllegalArgumentException("입력 숫자중 중복");
        }
    }
}
