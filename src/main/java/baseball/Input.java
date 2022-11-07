package baseball;
import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Input {

    public String playInput(){
        String input = Console.readLine();
        if(regexCheck(input) && playInputCheck(input)){
            return input;
        }
        else throw new IllegalArgumentException("잘못된 값을 입력했습니다.");
    }
    public String endInput(){
        String input = Console.readLine();
        if (regexCheck(input) && endInputCheck(input)){
            return input;
        }
        else throw new IllegalArgumentException("잘못된 값을 입력했습니다.");
    }
    private boolean regexCheck(String input){
        String regex="^[1-9]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
    private boolean playInputCheck(String input){
        if(input.length() == 3) return true;
        return false;
    }
    private boolean endInputCheck(String input){
        if(input.equals("1")  || input.equals("2")) return true;
        return false;
    }
}
