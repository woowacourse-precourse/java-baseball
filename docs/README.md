# 구현 기능 목록

## 난수 생성기 (Random Generator)
1. 1 ~ 9 범위의 난수 생성 기능
2. 1번 기능을 활용한 N개의 중복 없는 난수를 리스트로 반환하는 메소드

## 비교 결과 타입 (Comparison Result Type)
1. 볼, 스트라이크 Enum 타입으로 구현

## 비교 결과 (Comparison Result)
1. 비교 결과 타입을 리스트로 갖는 모델
2. 비교 결과 리스트의 타입별 빈도수를 갖는 해시맵 반환

## 심판 (Referee)
1. 숫자, 인덱스, 상대 숫자 리스트를 입력으로 받는다.
   1. 상대 숫자 리스트와 인덱스와 값이 모두 같으면 스트라이크를 반환
   2. 리스트에 포함되어 있으면 볼(Comparison Result Type)을 반환
   3. 없으면 Optional.empty 반환

## 숫자판 (Number Board)
1. Referee로 유저 숫자들과 상대방 숫자을과 비교하여 볼, 스트라이크의 빈도수 해시맵 반환
2. 비교한 결과를 Formatter로 String으로 변환하는 기능

## 사용자 입력 컨트롤러 (Input Controller)
1. N자리 숫자를 입력받아 리스트로 반환
   1. N자리 숫자인지 검증
      1. 길이가 N인지 검증
      2. Integer로 parse 가능한지 검증
   2. 아니면 IllegalArgumentException 발생시키기
2. 한자리 숫자 입력받아 반환
   1. 숫자가 맞는지 검증


## 베이스볼 게임 (Baseball Game)
1. 성공 조건 체크 기능
2. 상대방 숫자 입력 받아 저장
3. 유저의 숫자 추측 기능
   1. 입력 메시지 출력 및 입력 받기
      1. 1 ~ 9의 숫자가 아니면 IllegalArgumentException 발생시키기
      2. 중복 숫자가 있으면 IllegalArgumentException 발생시키기
   2. Number board 인스턴스 생성
   3. Number board compareNumbers 메소드 실행
   4. 비교 결과 빈도수 계산하고 출력
   5. 성공 조건 체크
      1. 성공 했을 경우
         1. 3개의 숫자를 모두 맞히셨습니다! 출력
         2. 게임 종료
      2. 실패 했을 경우
         1. 이 기능 반복
   

## 어플리케이샨 (Application)
1. 어플리케이션 시작 시
   1. Logger로 시작 메시지 출력하기
   2. Baseball 인스턴스 생성 후 시작
   3. 게임이 끝나면
      1. 재시작, 종료 선택 여부 메시지 출력
      2. 재시작, 종료 여부 입력받기
         1. 1과 2중에 하나인지 검증 아니면 IllegalArgumentException 발생시키기
         2. 1이면 새로운 Baseball Game 인스턴스 생성 후 시작
         3. 2면 어플리케이션 종료

## 로거 (Logger)
1. 출력할 메시지를 받아서 출력