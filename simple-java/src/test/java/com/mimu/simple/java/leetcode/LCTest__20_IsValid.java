package com.mimu.simple.java.leetcode;

import java.util.Objects;
import java.util.Stack;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * An input string is valid if:
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 * Example 1:
 * **Input:** s = "()"
 * **Output:** true
 * Example 2:
 * **Input:** s = "()[]{}"
 * **Output:** true
 * Example 3:
 * **Input:** s = "(]"
 * **Output:** false
 * <p>
 * Constraints:
 * 1 <= s.length <= 104
 * s consists of parentheses only '()[]{}'.
 * <p>
 * 有效括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 */
public class LCTest__20_IsValid {
    /**
     * 使用堆栈 进行 字符串的入栈 比较操作
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        if (Objects.isNull(s)) {
            return Boolean.TRUE;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') { // 只要是 左括号 统统入栈
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') { // 如果是有括号 则进行比较
                if (stack.isEmpty()) { // 当前元素 为 右括号 堆栈却为空，则 说明 没有成对出现
                    return Boolean.FALSE;
                }
                Character pop = stack.pop();
                if (c == ')' && pop != '(') { // 对特定的右括号 进行比较
                    return Boolean.FALSE;
                } else if (c == '}' && pop != '{') { // 对特定的右括号 进行比较
                    return Boolean.FALSE;
                } else if (c == ']' && pop != '[') { // 对特定的右括号 进行比较
                    return Boolean.FALSE;
                }
            }
        }
        return stack.isEmpty(); // 最后 堆栈应该是 空的
    }
}
