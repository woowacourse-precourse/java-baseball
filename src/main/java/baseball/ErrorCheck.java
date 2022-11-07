package baseball;

public class ErrorCheck {
    public static boolean isValidNumber(String user){
        try{
            Integer.parseInt(user);
            return true;
        }catch(Exception e){
            throw new IllegalArgumentException();
        }
    }

    public static boolean isValidDiffer(String user){
        int userNumber = Integer.parseInt(user);

        int first = userNumber/100;
        int second = (userNumber%100)/10;
        int third = userNumber%10;

        if(first-second!=0 && second-third!=0 && third-first!=0){
            return true;
        }else{
            throw new IllegalArgumentException();
        }
    }

    public static boolean isValidLength(String user) {
        if(user.length()!=3){
            System.out.println("3자리 숫자가 아닙니다.");
            throw new IllegalArgumentException();
        }
        return true;
    }
}
