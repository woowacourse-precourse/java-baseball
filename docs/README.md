# 구현 기능 목록

## 난수 생성기 (Random Generator)
1. 1 ~ 9 범위의 난수 생성 기능
2. 1번 기능을 활용한 N개의 중복 없는 난수를 리스트로 반환하는 메소드

## 비교 결과 타입 (Comparison Result Type)
1. 볼, 스트라이크 Enum 타입으로 구현

## 비교 결과 (Comparison Result)
1. 비교 결과 타입을 리스트로 갖는 모델

## 심판 (Referee)
1. 숫자 비교하여 같으면 스트라이크, 다르면 볼(Comparison Result Type)을 반환

## 비교 결과 변환기 (Comparison Result Formatter)
1. 비교 결과를 String 상태로 반환

## 숫자판 (Number Board)
1. Referee로 다른 숫자판과 비교하여 볼, 스트라이크 개수 계산 기능
2. 비교한 결과를 Comparison Result Formatter로 변환 후 출력하기

## 사용자 입력 컨트롤러 (Input Controller)
1. 3자리 숫자를 입력받아 리스트로 반환
2. 재시작, 종료 입력받기

## 베이스볼 게임 (Baseball Game)
