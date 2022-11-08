package baseball;



import camp.nextstep.edu.missionutils.*;


public class Application{

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        try {
            while (runGame()) ;
        }
        catch (IllegalArgumentException e){
            System.out.println("error : " + e.getMessage());
        }
    }

    public static boolean runGame(){
        BaseballNumber baseballNumber = new BaseballNumber();
        baseballNumber.makeRandomNumber();
        String inputString;
        while(true) {
            System.out.println("숫자를 입력해주세요 : ");
            inputString = readNumber();
            MatchResult matchResult = baseballNumber.match(inputString);
            matchResult.print();
            if(matchResult.isCorrect()){
                System.out.print("3개의 숫자를 모두 맞히셨습니다! ");
                break;

            }
        }
        System.out.println("게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String gameStatus;
        gameStatus = readGameStatus();

        if(gameStatus.equals("1")){
            return true;
        }
        if(gameStatus.equals("2")){
            return false;
        }

        return false;
    }
    public static String readGameStatus() throws IllegalArgumentException{
        String inputString = Console.readLine();
        if(!inputString.equals("1") && !inputString.equals("2")){
            throw new IllegalArgumentException("1 또는 2를 입력해야합니다.");
        }
        return inputString;
    }
    public static String readNumber() throws IllegalArgumentException {
        String inputString = Console.readLine();
        try {
            Integer.parseInt(inputString);
        }
        catch (NumberFormatException e){
            throw new IllegalArgumentException("숫자만 입력해야 합니다.");
        }

        if(inputString.length() != 3){
            throw new IllegalArgumentException("숫자의 길이는 3이여야 합니다.");
        }

        if(inputString.charAt(0) == inputString.charAt(1) &&
                inputString.charAt(1) == inputString.charAt(2) && inputString.charAt(0) == inputString.charAt(2)){
            throw new IllegalArgumentException("서로 다른 3자리 숫자를 입력해야 합니다.");
        }

        return inputString;
    }
}
