package baseball;

import java.util.*;
import java.util.stream.Collectors;

public class Computer {
    /**
     * 랜덤한 수 3가지를 만들어 인트형 3칸 배열로 반환하는 메서드
     * @return int [3] answer
     */
    public int[] makeAnswer() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 10; i++) numbers.add(i);
        Collections.shuffle(numbers,new Random());
        return numbers.stream().limit(3).mapToInt(Integer::intValue).toArray();
    }

    public Map<String, Integer> checking(int[] answer, int[] swing) {
        List<Integer> list = Arrays.stream(answer).boxed().collect(Collectors.toList());
        Map<String,Integer> map =new HashMap<>();
        for(int i=0; i<3; i++){
            if(answer[i] == swing[i]){
                map.put("Strike",map.getOrDefault("스트라이크",0)+1);
            }else if(list.contains(swing[i])){
                map.put("Ball",map.getOrDefault("볼",0)+1);
            }
        }
        if(map.isEmpty()) map.put("Nothing",1);
        return map;
    }

    public boolean chkResult(Map<String, Integer> map) {
        for(String key : map.keySet()){
            if(map.get(key)>=1) {
                if(key.equals("Nothing")){
                    System.out.println("낫싱");
                    return false;
                }else if(key.equals("Strike")&map.get(key)==3){
                    System.out.println("Success!!");
                    return true;
                }
                System.out.println(key+" :: "+map.get(key));
            }
        }
        return false;
    }
}
