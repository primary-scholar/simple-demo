package com.mimu.simple.java.cm;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class TimeRelevantTest {

    @Test
    public void test() {
        String time = "2024-10";
        String registerTime = StringUtils.isEmpty(time) ? "1971-1-1" : time;
        String[] split = registerTime.split("-");
        if (split.length < 3
                || LocalDateTime.now().isAfter(LocalDateTime.of(NumberUtils.toInt(split[0], 1971),
                NumberUtils.toInt(split[1], 11), NumberUtils.toInt(split[2],
                        1), 0, 0).plusDays(9))) {
            System.out.println(true);
        }
    }


    @Test
    public void test5() {
        int loop = 10000, size = 3, adIntervalNum = 4, skipNum = 8;
        Optional<List<Integer>> integers = calculateAndAddAd(size, adIntervalNum, 6, skipNum);
        System.out.println(integers.get());
        Optional<List<Integer>> integers1 = calculateAndAddAdOptimized(size, adIntervalNum, 6, skipNum);
        System.out.println(integers1.get());
    }

    private Optional<List<Integer>> calculateAndAddAd(int batchSize, int markerInterval,
                                                      int currentBatch, Integer skipNum) {
        //总数量，和第一个插入的位置
        Integer totalData = currentBatch * batchSize, insertIndex = skipNum;
        while (insertIndex <= totalData) {
            //计算第几刷
            Integer batch = (insertIndex + batchSize - 1) / batchSize;
            //计算位置
            Integer position = insertIndex % batchSize;
            if (position.equals(NumberUtils.INTEGER_ZERO)) {
                position = batchSize;
            }
            // 当前批次
            if (batch.equals(currentBatch)) {
                return Optional.of(Arrays.asList(batch, position));
            }
            insertIndex += markerInterval;
        }
        return Optional.empty();
    }

    /**
     * 这里算法 有误
     *
     * @param batchSize
     * @param markerInterval
     * @param currentBatch
     * @param skipNum
     * @return
     */
    private Optional<List<Integer>> calculateAndAddAdOptimized(int batchSize, int markerInterval,
                                                               int currentBatch, Integer skipNum) {
        if (batchSize <= 0 || markerInterval <= 0 || currentBatch <= 0 || skipNum == null || skipNum < 0) {
            throw new IllegalArgumentException("Invalid input parameters");
        }
        int totalData = currentBatch * batchSize;
        // 如果 skipNum 已经超过 totalData，直接返回空
        if (skipNum > totalData) {
            return Optional.empty();
        }
        // 计算第一个满足条件的 insertIndex
        int firstInsertIndex = skipNum;
        if (firstInsertIndex % markerInterval != 0) {
            firstInsertIndex += markerInterval - (firstInsertIndex % markerInterval);
        }
        // 如果第一个 insertIndex 超过 totalData，直接返回空
        if (firstInsertIndex > totalData) {
            return Optional.empty();
        }
        // 计算 batch 和 position
        int batch = (firstInsertIndex + batchSize - 1) / batchSize;
        int position = firstInsertIndex % batchSize;
        if (position == 0) {
            position = batchSize;
        }
        // 检查是否在当前批次
        if (batch == currentBatch) {
            return Optional.of(Arrays.asList(batch, position));
        }
        return Optional.empty();
    }

}
