'''
==============================================================================================
@ Title: 시그마
@ URL: https://www.acmicpc.net/problem/2355
@ Author: jopemachine
@ Created Date: 12/8/2022, 7:41:21 PM
@ Tags: math arithmetic
@ Level: Bronze 2
@ Description:
두 정수 A와 B가 주어졌을 때, 두 정수 사이에 있는 수의 합을 구하는 프로그램을 작성하시오. 사이에 있는 수들은 A와 B도
포함한다.
@ Input: 첫째 줄에 두 정수 A, B가 주어진다. (-2,147,483,648 ≤ A, B ≤ 2,147,483,647)
@ Output: 첫째 줄에 답을 출력한다. (-2,147,483,648 ≤ 답 ≤ 2,147,483,647)
==============================================================================================
'''

A, B = map(int, input().split())

if B < A:
    A, B = B, A

x = (B * (B + 1)) // 2
y = ((A - 1) * (A)) // 2

print(x - y)