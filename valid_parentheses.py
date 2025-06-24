class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        paren = {"(": ")", "{": "}", "[": "]"}
        stack = []

        for ch in s:
            if ch in paren:
                stack.append(ch)
            else:
                if stack:
                    po = stack.pop()
                    if paren[po] == ch:
                        continue
                    else:
                        return False
                else:
                    return False
        if stack:
            return False
        else:
            return True
