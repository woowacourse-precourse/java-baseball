# 구현할 기능 목록

- 게임 규칙에 맞는 난수 발생 - 완료
- 사용자의 입력값 검증 - 완료
- 사용자의 입력값에 대한 볼, 스트라이크 판별 - 완료
- 상위 컴포넌트들을 결합해 게임 완성 -완료
    - 사용자 입력값에 대한 예외 처리 - 완료
    - 종료 조건에 따른 반복 종료 조건 - 완료
    - 추측 결과에 따른 결과 문장 출력 - 완료

### 특이사항

주어진 Console.readline() 메서드를 2번 이상 사용시 다음과 같은 주의 발생

> WARNING: An illegal reflective access operation has occurred
> WARNING: Illegal reflective access by camp.nextstep.edu.missionutils.Console (file:/Users/antk7894/.gradle/caches/modules-2/files-2.1/com.github.woowacourse-projects/mission-utils/1.0.0/dad5230ec970560465a42a1cade24166e6a424f4/mission-utils-1.0.0.jar) to field java.util.Scanner.sourceClosed
> WARNING: Please consider reporting this to the maintainers of camp.nextstep.edu.missionutils.Console
> WARNING: Use --illegal-access=warn to enable warnings of further illegal reflective access operations
> WARNING: All illegal access operations will be denied in a future release

원인은 jdk와 라이브러리의 버전 차이로 추측되는데,  
실행에는 문제가 전혀 없음   
