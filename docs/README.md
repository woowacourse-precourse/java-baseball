### 기능 요구 사항
1. 랜덤 숫자 생성
2. 입력값과 정답 문자열 비교
3. 입력값에 대한 결과 출력
4. 게임 재시작 / 종료 선택

### 예외 처리
1-a) 중복된 숫자의 허용을 제한<br>
1-b) 전체 길이를 3으로 고정<br>
2-a) 중복된 숫자가 존재할 경우 `IllegalArgumentException`<br>
2-b) 전체 길이가 3과 동일하지 않을 경우 `IllegalArgumentException`<br>
2-c) 1~9 숫자가 아닌 다른 문자가 포함되어 경우 `IllegalArgumentException`<br>
4-a) 1 or 2가 아닌 다른 문자를 입력받을 경우 `IllegalArgumentException`<br>

### 기타 유의 사항
- JDK 11 버전에서 실행 가능
- `build.gradle` 변경 불가
- 외부 라이브러리 사용 불가
- `System.exit()` 호출 불가
- 패키지 이름 수정 불가
- indent 2까지만 허용
- 3항 연산자 사용 불가
- 유닛 테스트 필수
- 랜덤 숫자 생성 및 사용자 문자열 입력을 위해 `camp.nextstep.edu.missionutils`를 사용
- Java 코드 컨벤션 가이드 준수
- 커밋 메시지 컨벤션 가이드 준수