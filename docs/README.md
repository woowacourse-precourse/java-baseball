구현할 기능 목록
============
saturnone1
----------
### 테스트 실행 시 유의사항
~~
<br>
~~Junit API를 이용하여 @Test 코드를 기능 단위(구현한 메소드 하나씩) 로 사용하게 되면, 빌드 시 테스트 옵션을 Junit으로 잡아야 한다.
Junit으로 테스트 속성이 설정되지 않은 경우에는, 다음과 같은 실행 시 오류가 발생한다.~~
<br>
<br>
<span style="color:red">
~~11월 03, 2022 3:05:23 오후 org.junit.platform.launcher.core.EngineDiscoveryOrchestrator lambda$logTestDescriptorExclusionReasons$7
정보: 0 containers and 1 tests were Method or class mismatch~~
</span>
<br>
<br>
~~예상되는 원인으로는, ApplicationTest의 부모 Class인 NsTest에 있다는 생각이 드는데,
Junit, AssertJ와 NsTest 코드를 뜯어볼 필요가 있다. 일단 위의 해결 방법은 다음과 같다.~~
<br>
<br>
~~파일 -> 설정 -> 빌드 도구 -> Gradle -> 다음을 이용하여 테스트 및 실행 : Gradle -> Intellij IDEA로 변경~~
<br>
> 위의 문제는 Test Class의 각 Method를 구분하여 메소드 별로 실행했을 시 생기는 문제로서, 
> runmain()메소드 없이 실행하여 발생한 문제이다. 따라서 프로젝트의 의존성, Java 버전, 코드상의
> 오류는 없다고 판단하고 취소선 처리하였다.
<br>
## 0. Application Constructor
> createNum, startGame 메소드 호출, IllegalArgumentException을
> Main으로 Throw

## 1. Random Number 생성
+ createNum
> List의 Size가 3이 될 때까지 이미 가지고 있는 숫자를 제외한 난수를 저장
+ startGame
> 숫자 야구 게임 시작. 예외 발생 시, answer = False로 초기화하여 정지

## 2. 숫자 입력
+ getInputNum
> 숫자 입력을 받는 부분. 길이가 3이 아니면 IllegalArgumentException 예외 생성
> <br> Readline을 통해 받은 input을 List<>에 저장
+ setAnswer
> Strike와 Ball의 수를 체크
+ showResult
> SetAnswer에서 체크된 결과 출력
+ checkAnswer
> Strike가 3일 시, startOrNot, 아닐 시 다음 입력
+ resetStrikeBall
> Strike와 Ball의 숫자 초기화 (매 input 입력 시마다 호출하여 다음 입력 받음)
+ startOrNot
> 게임을 새로 시작할지, 종료할 지 결정
+ resetAll
> 모든 변수 초기화(게임 재실행 시 호출)