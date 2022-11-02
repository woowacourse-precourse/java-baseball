구현할 기능 목록
============
saturnone1
----------

## 1. Random Number 생성
```java
List<Integer> computer = new ArrayList<>();
    while (computer.size() < 3){
    int randomNumber=Randoms.pickNumberInRange(1,9);
    if(!computer.contains(randomNumber)){
    computer.add(randomNumber);
    }
}
```

## 2. 숫자 입력 
## 3. 입력 정답 유무 판단
- 입력값의 적합성 판단
> 숫자가 아니거나, 3자리가 아니거나, 0이 제일 앞에 있는 경우
- 같은 부분의 판단
- 정답 시 재시작 or 종료