package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;

public class Application {
    private static final int NUMBERS_SIZE = 3;
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        Comments comments = new Comments(setComments());
        Player computer = new Player(selectComputerNumber());

        comments.printStartComment();
        while (true){
            comments.printInputComment();
            Player user = new Player(toIntegers(split(Console.readLine())));

            if(playGame(computer, user, comments))
                continue;

            Restart restart = new Restart(toInt(Console.readLine()));
            if(!restart.isRestart())
                break;
            computer = new Player(selectComputerNumber());
        }

    }

    public static List<Integer> selectComputerNumber(){
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < NUMBERS_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }

    public static String[] split(String string){
        return string.split("");
    }

    public static int toInt(String input){
        return Integer.parseInt(input);
    }

    public static List<Integer> toIntegers(String[] input){
        List<Integer> player = new ArrayList<>();
        Arrays.stream(input).forEach(number -> player.add(Integer.parseInt(number)));

        return player;
    }

    public static boolean playGame(Player computer, Player user, Comments comments){
        if(numberOfStrikes(computer, user) == 3 ){
            comments.printFinishComment();
            return false;
        }
        printResult(computer, user, comments);
        return true;
    }

    public static void printResult(Player computer, Player user, Comments comments){
        if(checkNothing(computer, user)){
            comments.printNothingComment();
            return;
        }
        comments.printResultComment(numberOfBalls(computer, user), numberOfStrikes(computer,user));
    }

    public static int numberOfStrikes(Player computer, Player user){
        int count = 0;

        for(int i=0; i< NUMBERS_SIZE; i++){
            if(computer.isStrike(i, user.getNumberOfIndex(i)))
                count++;
        }

        return count;
    }

    public static int numberOfBalls(Player computer, Player user){
        int count = 0;

        for(int i=0; i< NUMBERS_SIZE; i++){
            if(computer.isBall(i, user.getNumberOfIndex(i)))
                count++;
        }

        return count;
    }

    public static boolean checkNothing(Player computer, Player user){

        for(int i=0; i< NUMBERS_SIZE; i++){
            if(computer.isContain(user.getNumberOfIndex(i)))
                return false;
        }
        return true;
    }

    public static Map<String, String> setComments(){
        Map<String, String> comments = new HashMap<>();
        comments.put("START", "숫자 야구 게임을 시작합니다.");
        comments.put("INPUT","숫자를 입력해주세요 : ");
        comments.put("FINISH", "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return comments;
    }
}
