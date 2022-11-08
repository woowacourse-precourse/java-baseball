# 게임 시나리오

- 컴퓨터는 타자, 유저는 투수
- 한번의 타석에서 3번의 투구에서 3 스트라이크를 잡아야 한다.
- 스트라이크 존 : 은 아래와 같이 9개 영역으로 나뉜다.
  <br>│1│2│3│
  <br>│4│5│6│
  <br>│7│8│9│
- 투구 결과
    - 스트라이크 : 타자가 배트를 휘두를 곳을 정확히 예측한 경우 (숫자가 완전히 동일한 경우)
    - 볼 : 타자가 배트를 휘두를 곳을 예측했지만, 순서가 다른 경우 (동일한 숫자가 있지만, 위치가 다른 경우)
    - 낫싱 : 타자의 스윙을 전혀 예측하지 못한 경우 (일치하는 숫자가 아무 것도 없는 경우)
- 3 스트라이크가 될 때까지 게임을 반복한다.
- 3 스트라이크가 된 경우 유저 승리, 게임 종료

# 프로그램 시나리오

1. 게임 시작 안내
2. 타자 스윙존 생성 : 세 자리 랜덤 숫자 생성
3. 투구(pitch) : 세 자리 숫자 입력
    - (조건) 1-9 세 자리 숫자가 아닌 경우 IllegalArgumentException 후 프로그램 완전 종료
4. 게임 결과 출력 (낫싱, 1스트라이크)
    - (조건) 정답이 아닌 경우 2번으로 돌아감.
    - (조건) 정답인 경우 게임 종료 메세지 출력
5. 종료 이후 게임 진행
    - (조건) 사용자 1번 입력 -> 다시 시작
    - (조건) 사용자 2번 입력 -> 프로그램 완전 종료

# 기능 목록

1. StrikeZone : 문자열 포장
    - Zone: get threeNumbers
    - validate : String "[1-9]{3}" 형식 체크
2. Hitter : (컴퓨터) 타자 스윙존 생성
    - private Zone swingZone;
    - swing : pickNumberInRange, 3자리 랜덤 숫자 생성
3. Pitcher : (유저) 투수 피치존 입력
    - private Zone pitchZone;
    - pitch : 새로운 피치존 입력(readLine) -> validate
    - playGameAgainOrNot : 다시 시작(1), 종료(2)
4. Referee : 콘솔에 게임 진행 상황을 출력 (GameGuider 상속)
    - startGame : 게임 시작, System.out.println
    - startPitch : 유저 정답 입력, System.out.println
    - judge(pitch, swing) : 판별 결과 출력, return
    - endGame : 게임 종료 문구 출력
5. GameGuider : 프로그램 시작, 종료 안내
    - guideGameProcess : 게임 시나리오 설명 출력
    - terminateProgram : 프로그램 종료 문구 출력, System.out.println

# 테스트 목록

1. 문자열 입력값 예외 테스트(Zone)
    - "" : IllegalArgumentException -> 프로그램 완전 종료
    - "1" : IllegalArgumentException -> 프로그램 완전 종료
    - "12" : IllegalArgumentException -> 프로그램 완전 종료
    - "123" : 프로그램 정상 진행
    - "1234" : IllegalArgumentException -> 프로그램 완전 종료
2. Referee.decide 출력 테스트
    - 234 vs 222 : 1 스트라이크
    - 222 vs 234 : 1 스트라이크
    - 232 vs 224 : 1볼 1스트라이크
    - 233 vs 332 : 2볼 1스트라이크
    - 561 vs 232 : 낫싱
    - 561 vs 156 : 3볼
    - 232 vs 232 : "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료"
3. 정답, 정답 아닌 경우 프로세스 테스트
    - 232 vs 232 : 게임 종료
    - 232 vs 156 : 다음 입력
4. 게임 종료 이후 스텝 테스트
    - 다시 시작 테스트
    - 프로그램 완전 종료 테스트
