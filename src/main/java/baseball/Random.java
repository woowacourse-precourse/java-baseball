package baseball;
import camp.nextstep.edu.missionutils.Randoms;

public class Random {
    public String pick(){
        String randomString= "";
        int randomNum;
        while (randomString.length() !=3){
            randomNum=Randoms.pickNumberInRange(1, 9);
            if(!contains(randomString,randomNum)){
                randomString=randomString+randomNum;
            }
        }
        return  randomString;
    }
    private Boolean contains(String randomString,int randomNum){
        return randomString.contains(Integer.toString(randomNum));
    }

}
