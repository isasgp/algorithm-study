def reverseString(s: list[str]) -> None:
    left, right = 0, len(s)-1
    while left < right:
        s[left], s[right] = s[right], s[left]
        left += 1
        right -= 1

def reverseString2(s: list[str]) -> None:
    s[:] = s[::-1]
    # s.reverse()

s = ["h", "e", "l", "l", "o"]
reverseString2(s)
print(s)