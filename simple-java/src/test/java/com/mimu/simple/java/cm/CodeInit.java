package com.mimu.simple.java.cm;

import com.mysql.cj.util.LRUCache;
import org.junit.Test;

import java.lang.invoke.VarHandle;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

/**
 * author: mimu
 * date: 2019/9/3
 */
public class CodeInit {
    public static void main(String[] args) {
        System.out.println(Integer.toString(16, 16));
    }

    /**
     * attention the follow sout is different
     */
    @Test
    public void info() {
        BigDecimal divided = new BigDecimal(3);
        BigDecimal divisor = new BigDecimal(10);
        BigDecimal divide = divided.divide(divisor, 2, RoundingMode.HALF_DOWN);
        System.out.println(divide);
        System.out.println(divide.multiply(new BigDecimal(100)));

        BigDecimal divided1 = new BigDecimal(3 * 100);
        BigDecimal divisor1 = new BigDecimal(10);
        System.out.println(divided1.divide(divisor1, 2, RoundingMode.HALF_DOWN));

        System.out.println(new BigDecimal(0.125));
        System.out.println(new BigDecimal(0.125).multiply(new BigDecimal(0.008)));
        System.out.println(new BigDecimal(0.125).divide(new BigDecimal(0.05),2,RoundingMode.HALF_UP));
        System.out.println(new BigDecimal("0.125"));
        System.out.println(new BigDecimal("0.125").multiply(new BigDecimal("0.008")));
        System.out.println(new BigDecimal("0.125").divide(new BigDecimal("0.05")));
    }

    public int[] sortArray(int[] nums) {
        if (Objects.isNull(nums) || nums.length <= 1) {
            return nums;
        }
        int[][] split = split(nums);
        int[] first = sortArray(split[0]);
        int[] last = sortArray(split[1]);
        return merge(first, last);
    }

    private int[][] split(int[] nums) {
        if (Objects.isNull(nums) || nums.length <= 1) {
            return new int[][]{nums};
        }
        int left = 0, right = nums.length - 1;
        int mid = left + (left + (right - left) >> 1);
        int fl = mid - left + 1, ll = right - mid;
        int[] first = new int[fl];
        int[] last = new int[ll];
        System.arraycopy(nums, left, first, 0, fl);
        System.arraycopy(nums, mid + 1, last, 0, ll);
        return new int[][]{first, last};
    }

    private int[] merge(int[] first, int[] last) {
        if (Objects.isNull(first) && Objects.isNull(last)) {
            return null;
        }
        int fl = Objects.isNull(first) ? 0 : first.length;
        int ll = Objects.isNull(last) ? 0 : last.length;
        int length = fl + ll;
        int[] result = new int[length];
        int idx = 0, fIdx = 0, lIdx = 0;
        while (fIdx < fl && lIdx < ll) {
            if (first[fIdx] < last[lIdx]) {
                result[idx++] = first[fIdx];
                fIdx++;
            } else {
                result[idx++] = last[lIdx];
                lIdx++;
            }
        }
        while (fIdx < fl) {
            result[idx++] = first[fIdx];
            fIdx++;
        }
        while (lIdx < ll) {
            result[idx++] = last[lIdx];
            lIdx++;
        }
        return result;
    }

    @Test
    public void sortTest() {
        int[] ints = sortArray(new int[]{2});
        int[] ints1 = sortArray(new int[]{5, 2});
        int[] ints2 = sortArray(new int[]{2, 5, 3});
    }
}
