구현할 기능 목록
============
saturnone1
----------
### 테스트 실행 시 유의사항
<br>
Junit API를 이용하여 @Test 코드를 기능 단위(구현한 메소드 하나씩) 로 사용하게 되면, 빌드 시 테스트 옵션을 Junit으로 잡아야 한다.
Junit으로 테스트 속성이 설정되지 않은 경우에는, 다음과 같은 실행 시 오류가 발생한다.
<br>
<br>
<span style="color:red">
11월 03, 2022 3:05:23 오후 org.junit.platform.launcher.core.EngineDiscoveryOrchestrator lambda$logTestDescriptorExclusionReasons$7
정보: 0 containers and 1 tests were Method or class mismatch
</span>
<br>
<br>
예상되는 원인으로는, ApplicationTest의 부모 Class인 NsTest에 있다는 생각이 드는데,
Junit, AssertJ와 NsTest 코드를 뜯어볼 필요가 있다. 일단 위의 해결 방법은 다음과 같다.
<br>
<br>
파일 -> 설정 -> 빌드 도구 -> Gradle -> 다음을 이용하여 테스트 및 실행 : Gradle -> Intellij IDEA로 변경
<br>
<br>

 
## 1. Random Number 생성
### createNum
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
### startGame
### getInputNum

## 3. 입력 정답 유무 판단
- 입력값의 적합성 판단
> 숫자가 아니거나, 3자리가 아니거나, 0이 제일 앞에 있는 경우
- 같은 부분의 판단
- 정답 시 재시작 or 종료
