package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Application {

    private static int HundredsExtract(int NumberToUse){
        return NumberToUse/100;
    }

    private static int TensExtract(int NumberToUse){
        return (NumberToUse/10)%10;
    }

    private static int UnitsExtract(int NumberToUse){
        return NumberToUse%10;
    }

    public static boolean DuplicateCheck(int TemporaryNumber){
        int Hundreds,tens,units = 0;

        Hundreds = HundredsExtract(TemporaryNumber);
        tens = TensExtract(TemporaryNumber);
        units = UnitsExtract(TemporaryNumber);

        if(Hundreds!=tens&&
                tens!=units&&
                Hundreds!=units)
            return false;

        else return true;
    }

    public static int AllocationOfNumber() {
        int TemporaryNumber = pickNumberInRange(102,987);

        while(DuplicateCheck(TemporaryNumber)){
            TemporaryNumber = pickNumberInRange(102,987);
        }

        return TemporaryNumber;
    }

    private static int StrikeCount(int CorrectAnswer,int UserDefinedNumber){
        int result = 0;

        if(HundredsExtract(CorrectAnswer)==HundredsExtract(UserDefinedNumber)) result++;
        if(TensExtract(CorrectAnswer)==TensExtract(UserDefinedNumber)) result++;
        if(UnitsExtract(CorrectAnswer)==UnitsExtract(UserDefinedNumber)) result++;

        return result;
    }

    private static int BallCount(int CorrectAnswer,int UserDefinedNumber){
        int CorrectHundreds,CorrectTens,CorrectUnits = 0;
        int UserHundreds,UserTens,UserUnits = 0;
        int result = 0;

        CorrectHundreds = HundredsExtract(CorrectAnswer);
        CorrectTens = TensExtract(CorrectAnswer);
        CorrectUnits = UnitsExtract(CorrectAnswer);

        UserHundreds = HundredsExtract(UserDefinedNumber);
        UserTens = TensExtract(UserDefinedNumber);
        UserUnits = UnitsExtract(UserDefinedNumber);

        if(CorrectHundreds==UserTens||CorrectHundreds==UserUnits) result++;
        if(CorrectTens==UserHundreds||CorrectTens==UserUnits) result++;
        if(CorrectUnits==UserHundreds||CorrectUnits==UserTens) result++;

        return result;
    }

    private static void OutputResult(int Strike,int Ball){
        if(Strike==0&&Ball==0){
            System.out.println("낫싱");
        }
        else if(Strike == 0){
            System.out.println(Ball + "볼");
        }
        else if(Ball == 0){
            System.out.println(Strike + "스트라이크");
        }
        else{
            System.out.println(Ball + "볼 "+ Strike + "스트라이크");
        }
    }

    private static void GameStart(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private static boolean GameResult(int CorrectAnswer, int UserDefinedNumber){
        int Strike, Ball = 0;

        Strike = StrikeCount(CorrectAnswer,UserDefinedNumber);
        Ball = BallCount(CorrectAnswer,UserDefinedNumber);

        OutputResult(Strike,Ball);

        if(Strike==3){
            return true;
        }
        else{
            return false;
        }
    }
    private static int EnterANumber(){
        int InputNumber;
        do{
            InputNumber = Integer.parseInt(readLine());
        } while(InputNumber<100||InputNumber>999);
        return InputNumber;
    }
    private static void GameLoop(){
        int CorrectAnswer = AllocationOfNumber();
        int UserDefinedNumber = 0;

        do {
            System.out.print("숫자를 입력해주세요 : ");

            UserDefinedNumber = EnterANumber();
        } while(!GameResult(CorrectAnswer,UserDefinedNumber));
    }

    private static boolean GameRestart() {
        int UserIntention = 0;

        System.out.println("3스트라이크");
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");


        while (UserIntention != 1 && UserIntention != 2) {
            UserIntention = Integer.parseInt(readLine());
        }
        if (UserIntention == 1) return true;
        else return false;
    }

    private static void GameOver(){
        System.out.println("게임 종료");
    }
    private static void GameMain(){
        int CorrectAnswer = AllocationOfNumber();

        GameStart();
        do{
            GameLoop();
        }while (GameRestart());

        GameOver();

    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameMain();
    }
}
