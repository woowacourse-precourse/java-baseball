기능 구현 목록(2주차 과제 : 숫자 야구 게임)
===
---
## ✨설계 계획
>1. 1회성 게임으로 기능을 구현 및 검증 
>2. 1회성 게임이 기능을 충족시킬 경우 다회성 게임으로 구현
>3. 다회성 게임으로 구현된 기능을 최종 테스트 검증 and 리팩토링


## 🍀1회성 게임 기능 구현 목록
>### Class field
> - [ ] `static Map<String, Integer> strikeAndBallCounter;`
>   - {"Strike" : StrikeCounts, "Ball" : BallCounts}  의 형태로 저장
>   - 출력을 하여 확인할 경우, key&value 값을 확인하기에 용이한 Map 자료구조를 선택
>   - Map의 객체는 저장 순서를 유지하는 `LinkedHashMap` 으로 생성
>   - 객체의 생성과 초기화를 위한 메서드를 구현
>   - 구현된 메서드를 `main` 메서드에서 호출

>### 1. Class 변수 초기화 메서드
>  -[ ] `void initializerOfStrikeAndBallCounter()`

>### 2. 컴퓨터가 1~9로 구성된 서로 다른 임의의 3자리수를 생성
>  - [ ] `List<Integer> createRandomThreeDigitNum()`
>  - [ ] Test code 작성 및 검증

>### 3. 사용자의 입력을 요청하는 메서드
>  - [ ] `List<Integer> enterNum()`

>### 4. 사용자의 입력이 올바른지 판단, 아닐 경우 예외를 발생
> - [ ] `boolean isCorrectedNum(List<Integer> inputNum)`
> - [ ] 2,3 을 Test 하기 위한 Test code 작성 및 검증

>### 5.  Strike 개수와 Ball 개수를 세고, 이를 `strikeAndBallCounter`에 저장
> - [ ] `void countAndSave( List<Integer> computer, List<Integer> user )`
>>#### 6. 사용자가 입력한 값애서 Strike 개수를 세는 메서드
>> - [ ] `int countStrike( List<Integer> computer, List<Integer> user )`
>>#### 7. 사용자가 입력한 값에서 Ball 개수를 세는 메서드
>> - [ ] `int countBall( List<Integer> computer, List<Integer> user )`

>### 8. 야구게임 결과를 출력하는 메서드
> - [ ] `String printResult()`
> - [ ] Test code 작성 및 검증

## 🍀다회성 게임으로 리팩토링 및 최종 Test
## 🍀추가 개선 가능성 여부 판단 및 리팩토링