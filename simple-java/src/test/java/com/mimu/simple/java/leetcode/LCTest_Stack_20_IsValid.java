package com.mimu.simple.java.leetcode;

import org.junit.Test;

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
public class LCTest_Stack_20_IsValid {

    private LC_Stack_20_IsValid isValid = new LC_Stack_20_IsValid();

    @Test
    public void quotaValid() {
        String quota = "()[]{}";
        System.out.println(isValid.isValid(quota));
        System.out.println(isValid.isValid("(}"));
    }
}
