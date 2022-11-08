# 기능 목록
## 1. 입력부
- 서로 다른 세자리 숫자를 입력받음(`userRandNumber`)

## 2. 연산처리
- 1. 서로 다른 세자리 숫자 생성(`correctRandNumber`)
- 2. 스트라이크 카운트 계산 
  - `userRandNumber`와 `correctRandNumber` 비교
  - index 값이 정확히 일치한다면 `strikeCount` ++
- 3. 볼 카운트 계산
  - `userRandNumber` 및 `correctRandNumber` 내 `strikeCount` 제외
  - `userRandNumber`와 `correctRandNumber` 비교
  - `correctRandNumber`의 value가 `userRandNumber`에 포함되어 있는 경우 `ballCount` ++
- 4. 연산 결과 출력

## 3. 판단
- 게임 종료
  - if `strikeCount == 3`인경우
  - 게임 종료 후 
- 게임 계속 진행
  - if `stikreCount != 3`인 경우
  - 2.연산처리 part 계속 진행

## 4. 예외 처리
- 입력 값(`userRandNumber`)이 서로 다른 세자리 숫자가 아닌 경우
- 생성된 숫자(`correctRandNumber`)가 서로 다른 세자리 숫자가 아닌경우