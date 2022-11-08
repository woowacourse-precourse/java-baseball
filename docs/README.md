# 숫자 야구 - 기능 목록

## 개요

- 프리코스 2주차 미션인 숫자 야구의 기능 목록을 정리한다.
- 정리된 기능 목록을 기준으로 기능별 커밋을 진행한다.

---

## 기능 목록

1. 실행 시, 게임 시작 문구 출력
2. 컴퓨터의 임의의 수 3개 선택
   - amp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용
     - Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용
3. 사용자에게 3개 숫자를 입력 받기
   - camp.nextstep.edu.missionutils.Console의 readLine()을 활용
4. 사용자가 잘못된 값을 입력하는 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료
   - 사용자가 잘못된 값을 입력하는 경우
     
     (1) 입력 글자 수가 3개 이상일 때
     
     (2) 각각의 수가 1~9사이의 값이 아닐 때
     
     (3) 수의 중복이 있을 때
5. 사용자의 세자리 수에 대한 결과 출력
   - 3개의 숫자 모두 맞추는 경우
     - 3스트라이크
       3개의 숫자를 모두 맞히셨습니다! 게임 종료
   - 하나도 없는 경우
     - 낫싱
   - n볼 r스트라이크 (n과 r은 숫자)
   - 모두 맞추지 못한다면 계속 진행
6. 게임 종료 후, 사용자에게 1개의 숫자를 입력 받기
    - camp.nextstep.edu.missionutils.Console의 readLine()을 활용
    - 1 또는 2 (재시작 또는 종료)
       - "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."
       - 1을 입력시 서로 다른 3자리의 수 입력 받기
       - 2 입력 시 프로그램 종료