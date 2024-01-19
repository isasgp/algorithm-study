# 유효한 팰린드롬
import collections
import re

class Soultion:
    def isPalindrome1(self, s: str) -> bool:
        strs =[]
        for char in s:
            if char.isalnum():
                strs.append(char.lower())

        while len(strs) > 1:
            if strs.pop(0) != strs.pop():
                return False
        return True

    def isPalindrome2(self, s: str) -> bool:
        strs: Deque = collections.deque()

        for char in s:
            if char.isalnum():
                strs.append(char.lower())
        while len(strs) > 1:
            if strs.popleft() != strs.pop():
                return False
        return True

    def isPalindrome3(self, s: str) -> bool:
        s = s.lower()
        s = re.sub('[^a-z0-9]', '', s)  # a-z and 0-9이 아닌 값 필터링

        return s == s[::-1]

solution = Soultion()
print(solution.isPalindrome1('aaaa'))
print(solution.isPalindrome2('aaaa'))
print(solution.isPalindrome3('aaaa'))
