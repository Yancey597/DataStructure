package Utils.ArrayUtils;/**
 * ClassName: ArrayGenerator
 * Package: Utils.recursionUtils.ArrayUtils
 * Description: 生成排序用的数组
 *
 * @Author Yancey
 * @Create 2023/11/22 22:09
 * @Version 1.0
 */
//import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class ArrayGenerator {
    private ArrayGenerator() {
    }

    public static int[] arrayGeneratorOrder(int n) {
        if (n <= 0) {
            throw new RuntimeException("创建的数组长度异常。");
        }
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i;
        }
        return array;
    }


    public static <E> E[] arrayGeneratorRandom(int n, E e, boolean repeat, int... args) {
        if (n <= 0) {
            throw new RuntimeException("创建的数组长度异常。");
        }

        if (args.length > 1 && args[0] < n) {
            throw new IllegalArgumentException("n must be less than or equal to m");
        }

        int bound = args.length == 1 ? args[0] : n;

        if (repeat) {
            Random rand = new Random();
            Integer[] array = new Integer[n];
            for (int i = 0; i < n; i++) {
                array[i] = rand.nextInt(bound) + 1;
            }
            return (E[]) array;
        } else {
            List<Integer> list = new ArrayList<>();

            //生成限定最大值的数组
            for (int i = 1; i <= bound; i++) {
                list.add(i);
            }
            Collections.shuffle(list);
            return (E[]) list.subList(0, n).toArray(new Integer[0]);
        }
    }

    public static Integer[] arrayGeneratorRandom(int n, boolean repeat, int... args) {
        if (n <= 0) {
            throw new RuntimeException("创建的数组长度异常。");
        }

        if (args.length > 1 && args[0] < n) {
            throw new IllegalArgumentException("n must be less than or equal to m");
        }

        int bound = args.length == 1 ? args[0] : n;

        if (repeat) {
            //生成可以重复的数组元素
            Random rand = new Random();
            Integer[] array = new Integer[n];
            for (int i = 0; i < n; i++) {
                array[i] = rand.nextInt(bound) + 1;
            }
            return array;
        } else {
            // 生成不能重复的数组
            List<Integer> list = new ArrayList<>();
            //生成限定最大值的数组
            for (int i = 1; i <= bound; i++) {
                list.add(i);
            }
            Collections.shuffle(list);
            return list.subList(0, n).toArray(new Integer[0]);
        }
    }

    /**
     * @param n: 数据规模
     * @param e:
     * @param repeat: 元素是否可以重复
     * @param random: true: 序列每次都不一样
     * @param args:
      * @return E
     * @author Yancey
     * @description TODO
     * @date 2024/2/6 0:31
     */
    public static <E> E[] arrayGeneratorRandom(int n, E e, boolean repeat, boolean random, int... args) {
        if (n <= 0) {
            throw new RuntimeException("创建的数组长度异常。");
        }

        if (args.length > 1 && args[0] < n) {
            throw new IllegalArgumentException("n must be less than or equal to m");
        }

        int bound = args.length == 1 ? args[0] : n;
        Random rand = random ? new Random() : new Random(40);

        if (repeat) {
            Integer[] array = new Integer[n];
            for (int i = 0; i < n; i++) {
                array[i] = rand.nextInt(bound) + 1;
            }
            return (E[]) array;
        } else {
            List<Integer> list = new ArrayList<>();

            //生成限定最大值的数组
            for (int i = 1; i <= bound; i++) {
                list.add(i);
            }
            Collections.shuffle(list, rand);
            return (E[]) list.subList(0, n).toArray(new Integer[0]);
        }
    }
}