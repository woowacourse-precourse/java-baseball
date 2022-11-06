# 숫자 야구 게임

---

## 구현할 기능 목록


- [x] 3자리의 랜덤 숫자 생성 기능
- [x] 숫자 입력 기능
- [x] 입력 받은 문자 검증 기능
- [ ] 생성 된 랜덤 숫자와 입력 받은 숫자 비교 기능
- [x] 정답 시 종료/재시작 탐색 기능

---

## 수정 사항


### 3자리의 랜덤 숫자 생성 기능
- 요구사항에 맞게 3자리 랜덤 숫자 생성 메서드 변경
    

    //변경 전
    > Return Randoms.pickUniqueNumbersInRange(1, 9, 3); 
    
    // 변경 후 
    > List<Integer> list = new ArrayList<>();

        while (list.size() < 3) {
            int number = Randoms.pickNumberInRange(1, 9);

            // 숫자 중복 검사
            if(isNotDuplicatedNumber(list , number)){
                list.add(number);
            }
        }
    Return list;


---
