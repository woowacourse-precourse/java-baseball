package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Application {

    public static int HundredsExtract(int NumberToUse){
        return NumberToUse/100;
    }

    public static int TensExtract(int NumberToUse){
        return (NumberToUse/10)%10;
    }

    public static int UnitsExtract(int NumberToUse){
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

    public static List<Integer> AllocationOfNumber() {
        List<Integer> TemporaryNumber = new ArrayList<>();
        while(TemporaryNumber.size() < 3){
            int Random = Randoms.pickNumberInRange(1,9);
            if(!TemporaryNumber.contains(Random)){
                TemporaryNumber.add(Random);
            }
        }

        return TemporaryNumber;
    }

    public static int StrikeCount(List<Integer> CorrectAnswer,List<Integer> UserDefinedNumber){
        int result = 0;

        if(CorrectAnswer.get(0)==UserDefinedNumber.get(0)) result++;
        if(CorrectAnswer.get(1)==UserDefinedNumber.get(1)) result++;
        if(CorrectAnswer.get(2)==UserDefinedNumber.get(2)) result++;

        return result;
    }

    public static int BallCount(List<Integer> CorrectAnswer,List<Integer> UserDefinedNumber){
        int result = 0;


        if(CorrectAnswer.get(0)==UserDefinedNumber.get(1)||CorrectAnswer.get(0)==UserDefinedNumber.get(2)) result++;
        if(CorrectAnswer.get(1)==UserDefinedNumber.get(0)||CorrectAnswer.get(1)==UserDefinedNumber.get(2)) result++;
        if(CorrectAnswer.get(2)==UserDefinedNumber.get(0)||CorrectAnswer.get(2)==UserDefinedNumber.get(1)) result++;

        return result;
    }

    public static void OutputResult(int Strike,int Ball){
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

    public static void GameStart(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static boolean GameResult(List<Integer> CorrectAnswer, int UserDefinedNumber){
        int Strike, Ball = 0;

        List<Integer> UserDefinedNumber_array = new ArrayList<>();

        UserDefinedNumber_array.add(HundredsExtract(UserDefinedNumber));
        UserDefinedNumber_array.add(TensExtract(UserDefinedNumber));
        UserDefinedNumber_array.add(UnitsExtract(UserDefinedNumber));

        Strike = StrikeCount(CorrectAnswer,UserDefinedNumber_array);
        Ball = BallCount(CorrectAnswer,UserDefinedNumber_array);

        OutputResult(Strike,Ball);

        if(Strike==3){
            return true;
        }
        else{
            return false;
        }
    }
    public static int EnterANumber() throws IllegalArgumentException{
        int InputNumber;
        do{
            InputNumber = Integer.parseInt(readLine());
        } while(InputNumber<100||InputNumber>999);
        return InputNumber;
    }
    public static void GameLoop(){
        List<Integer> CorrectAnswer = AllocationOfNumber();
        int UserDefinedNumber = 0;

        do {
            System.out.print("숫자를 입력해주세요 : ");

            UserDefinedNumber = EnterANumber();
        } while(!GameResult(CorrectAnswer,UserDefinedNumber));
    }

    public static boolean GameRestart() {
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

    public static void GameOver(){
        System.out.println("게임 종료");
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        GameStart();
        do{
            GameLoop();
        }while (GameRestart());

        GameOver();

    }
}
