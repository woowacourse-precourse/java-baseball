package baseball;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
public class Game {
    private static final int LENGTH = 3;
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 9;

    public static final List<Integer> userNumberList = new ArrayList<>();
    public static final List<Integer> computerList = new ArrayList<>();
    Game(){
        computer();
    }
    public static void computer(){
        Check.isEmptyComputer(computerList);
        while(computerList.size() < LENGTH){
            int randomNumber = pickNumberInRange(START_NUMBER,END_NUMBER);
            if(!computerList.contains(randomNumber)){
                computerList.add(randomNumber);
            }
        }
        gameStart(computerList);
    }
    public static void user(String[] str){
        for(int i=0;i<LENGTH;i++){
            if(!userNumberList.contains(Integer.parseInt(str[i]))) {
                userNumberList.add(Integer.parseInt(str[i]));
            }
        }
    }
    public static void gameStart(List<Integer> computer){
        Check.isEmptyUserList(userNumberList);
        Print.printGetNumberMessage();

        String user = readLine();
        Check.checkNumberOnly(user);
        Check.checkInputZero(user);

        String[] splitStr = user.split("");
        Check.checkinputSize(splitStr);

        user(splitStr);

        Check.checkInputNumberDuplicate(userNumberList);

    }
}
