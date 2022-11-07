7. 컬렉션 프레임워크
    1. List
        - ArrayList

            ```java
            // 생성
            List<String> list = new ArrayList<>();
            
            // 배열 => List
            List<String> 새리스트이름 = Arrays.asList(배열이름);
            
            // 메소드
            list.add("은기");
            list.add(0, "지훈"); // 주어진 인덱스에 객체 추가
            list.set(0, "현기"); // 인덱스에 저장된 객체를 주어진 객체로 바꿈
            
            list.contains("은기") // true
            list.get(1) // return 은기
            list.size() // 객체 수 리턴
            list.isEmpty()
            
            // 객체 삭제
            list.clear();
            list.remove(1) // 인덱스 1 삭제
            list.remove("현기") // 객체를 직접 지정해서 삭제
            ```

            - 초기에는 내부에 10개 객체를 저장할 수 있는 초기 용량을 가짐
            - 객체 수에 따라 용량은 자동으로 증가
            - 객체를 추가하면 0번부터 차례대로 저장
            - 특정 객체를 제거하면 바로 뒤 인덱스부터 마지막까지 모두 1씩 앞으로
            - 객체 추가, 제거가 빈번하다면 LinkedList를 사용하는 것이 좋음
            - 인덱스로 객체를 찾거나(검색), 맨 마지막에 객체를 추가하는 데에는 ArrayList가 좋음
    2. Set
        - 객체 저장 순서 X
        - 중복 허용하지 않음
        - HashSet, LinkedHashSet, TreeSet
        - 메소드 중 add, contains, isEmpty, size, clear, remove 모두 list와 동일

        ```java
        Set<String> set = new HashSet<>();
        
        // 반복자 Iterator 제공
        Iterator<String> iterator = set.iterator();
        while(iterator.hasNext()) {
        	String str = iterator.next();
        }
        
        // for문으로도 반복 가능
        for(String str: set){ }
        ```

    3. Map
        - key, value로 구성된 Map.Entry 객체를 저장하는 구조
        - Entry: Map 인터페이스 내부에 선언된 중첩 인터페이스

        ```java
        // 선언
        Map<String, Integer> map = new HashMap<>();
        
        // 객체 추가
        map.put("은기", 158); 
        
        // 객체 검색
        map.containsKey("은기") // true
        map.containsValue(158) // true
        map.get("은기") // 158
        
        map.isEmpty();
        map.size();
        map.keySet(); // key를 set에 담아서 리턴
        
        map.clear();
        map.remove("은기");
        
        // 반복
        
        // 1. keySet() 메소드로 모든 키를 얻은 다음, 반복을 통해 키와 값을 얻는 방법
        Set<String> keySet = map.keySet();
        Iterator<String> keyIterator = keySet.iterator();
        while(keyIterator.hasNext()) {
        	String key = keyIterator.next();
        	Integer value = map.get(key);
        }
        
        // 2. entrySet() 메소드로 모든 Map.Entry를 얻은 다음, 
        // getKey(), getValue() 메소드 사용
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        Iterator<Map.Entry<String, Integer>> entryIterator = entrySet.iterator();
        while(entryIterator.hasNext()){
        	Map.Entry<String, Inteeger> entry = entryIterator.next();
        	String key = entry.getKey();
        	Integer value = entry.getValue();
        }
        ```