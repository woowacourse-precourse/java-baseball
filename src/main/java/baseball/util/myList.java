package baseball.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class myList {
    public static List<Integer> stringToIntegerList(String input){
        List<Integer> list = new ArrayList<>();
        for ( int i = 0 ; i < input.length() ; i ++){
            list.add(input.charAt(i) - '0');
        }
        return list;
    }
    public static int countDiffLocationValues(List<Integer> l1, List<Integer> l2){
        int answer = 0;
        for ( int i = 0 ; i < l1.size() ; i ++ ){
            for ( int j = 0 ; j < l2.size() ; j ++ ){
                if ( i == j ) continue;
                if ( l1.get(i) == l2.get(j) ) answer++;
            }
        }
        return answer;
    }
    public static int countSameLocationValues(List<Integer> l1, List<Integer> l2){
        return (int) IntStream.range(0, 3)
                .filter(index -> l1.get(index) == l2.get(index))
                .count();
    }
}

