package baseball;

import java.util.List;

public class Util {
    public static void listFilterPush(List<Integer> numberList, Integer randomNumber){
        if (!numberList.contains(randomNumber)) {
            numberList.add(randomNumber);
        }
    }

    public static Integer booleanToInteger(boolean boolValue){
        if(boolValue)
            return 1;
        else
            return 0;
    }

    public static String getSingleString(String origin, Integer idx){
        return origin.substring(idx, idx + 1);
    }

    public static String getSubstring(String origin, int exceptIdx){
        if(exceptIdx != origin.length() - 1)
            return origin.substring(0, exceptIdx) + origin.substring(exceptIdx + 1);
        else
            return origin.substring(0, exceptIdx);
    }
}
