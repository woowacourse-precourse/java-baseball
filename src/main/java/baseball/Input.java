package baseball;
import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Input {
    private int range;
    private Pattern pattern;
    private Matcher matcher;
    public Input(int min ,int max ,int range){
        if(minInputCheck(min,max,range)){
            String regex="^["+min+"-"+max+"]+$";
            pattern = Pattern.compile(regex);
            this.range=range;
        }
        else throw new IllegalArgumentException("잘못된 값을 입력했습니다.");
    }
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
        matcher = pattern.matcher(input);
        return matcher.matches();
    }
    private boolean playInputCheck(String input){return input.length() == range;}
    private boolean endInputCheck(String input){return input.equals("1") || input.equals("2");}
    private boolean minInputCheck(int min, int max,int range){return (max-min+1)>=range;}
}