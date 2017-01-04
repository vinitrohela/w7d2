package com.allstate;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by localadmin on 03/01/17.
 */
public class Main {
    public static void main(String[] args){
        int[] nums1 ={-8, -5, 2, 4, 5, 99, 100};
        IntStream stream1 = Arrays.stream(nums1);
        List<Integer> nums2 =new ArrayList<>();
        for(int i=0; i<nums1.length; i++){
            nums2.add(nums1[i]);
        }

        Predicate<Integer> isPositive = n -> n > 0;
        List<Integer> evens = nums2
                .stream()
                .filter(MyMath::isEven)
                .filter(n -> n <100)
                .filter(isPositive)
                .collect(Collectors.toList());

        int sum = evens.stream().reduce(0, (acc, val) -> acc+val);
        System.out.println(sum);


        Stream<Integer> nums3 = Stream.iterate(10, n -> n+3);
        int sum1 = nums3.limit(20)
                .reduce(0, (m, n) -> m+n);
        System.out.println(sum1);
    }
}
