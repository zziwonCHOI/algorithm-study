t=int(input())

for case in range(1,t+1):
    results=list(map(str,input()))
    count=0
    result=''
    for i in range(len(results)):
        if results[i]=='o':
            count+=1

    if (15-len(results)+count)>7:
        result="YES"
    else:
        result="NO"
    print(f"#{case} {result}")