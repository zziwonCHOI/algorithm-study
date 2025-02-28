
def is_palindrome(s):
    #문자열을 뒤집은 값과 원래 문자열이 같은지 확인
    return s==s[::-1]

for case in range(10):
    num=int(input())
    grid=[input().strip() for _ in range(100)]
    max_len=0

    for row in grid:
        for length in range(100,1,-1): #회문의 길이가 100부터 2까지
            for start in range(101-length): #가능한 문자열의 시작 위치
                substring=row[start:start+length]
                if is_palindrome(substring):
                    max_len=max(max_len,length)  
                    break #더 작은 길이로는 더 긴 회문이 나올 수 없으므로 종료

    for col in range(100):
        for length in range(100,1,-1):
            for start in range(101-length):
                substring=''.join(grid[start + i][col] for i in range(length)) #현재 열에서 start부터 start+length 까지의 세로 부분 문자열을 만든다.
                if is_palindrome(substring):
                    max_len=max(max_len,length)
                    break

    print(f"#{num} {max_len}")


