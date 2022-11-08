package baseball;

public class CheckNumber {
    //볼과 스트라이크의 갯수를 구한다음 출력하는 함수
    public static int CheckNum(String num, String computerNum){
        int scount = 0;
        int bcount = 0;
        int result;

        for (int i = 0; i < computerNum.length(); i++){
            for (int j = 0; j < num.length(); j++){
                if (ballStrike(num, computerNum, i, j) == 1)
                    scount++;
                else if (ballStrike(num, computerNum, i, j) == 2)
                    bcount++;
            }
        }
        result = checkBallcount(scount, bcount);
        return result;
    }

    //수를 하나하나 검사하면서 볼인지 스트라이크인지 판단
    public static int ballStrike(String num, String computerNum, int i, int j){
        if (num.charAt(i) == computerNum.charAt(j)){
            if (i == j)
                return (1);
            else
                return (2);
        }
        return (0);
    }

    //볼과 스트라이크의 갯수에 맞게 메세지 출력
    public static int checkBallcount(int scount, int bcount){
        if (scount == 0 && bcount == 0){
            System.out.println("낫싱");
        }
        else if (scount == 3){
            System.out.println(scount + "스트라이크");
            return (1);
        }
        else if (scount == 0){
            System.out.println(bcount + "볼");
        }
        else if (bcount == 0){
            System.out.println(scount + "스트라이크");
        }
        else
            System.out.println(bcount + "볼 " + scount + "스트라이크");
        return (0);
    }
}
