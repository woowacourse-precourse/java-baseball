package baseball.utils;

public class UserOutput {

    public static void printResult(int ball, int strike){
        String result = "";

        if (ball != 0)
            result+= ball +"볼";
        if (strike != 0)
            result+= " " + strike +"스트라이크";
        if (result.length() == 0)
            result = "낫싱";

        System.out.println(result.strip());
    }
}
