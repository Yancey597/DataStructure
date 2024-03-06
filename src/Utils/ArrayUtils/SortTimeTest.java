package Utils.ArrayUtils;
/**
 * ClassName: SortTest
 * Package: vip.yancey.Day1
 * Description: 排序方法测试类
 *
 * @Author Yancey
 * @Create 2023/11/22 21:09
 * @Version 1.0
 */
//import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;


public class SortTimeTest<E extends Comparable<E>> {
    private SortTimeTest() {
    }

    /**
     * @param clazz: 含有实现排序的 sort 静态方法的 class
     * @param print: 是否输出数组
     * @param arr:   给定的数据
     * @return void
     * @author Yancey
     * @description 对给定的数据执行 特定的排序，整个测试类的实现方法
     * @date 2024/2/5 21:03
     */
    public static <E extends Comparable<E>> boolean testArray(Class clazz, boolean print, E[] arr) {

        var name = clazz.getSimpleName();
        long startTime = 0;
        try {
            Method sort = clazz.getDeclaredMethod("sort", Comparable[].class);
            sort.setAccessible(true);
            Object[] params = {arr};

            if (print) {
                System.out.println("[start " + name + "!]");
                ArrayHelper.printArray(arr);
            }

            startTime = System.nanoTime(); // 计时开始
            sort.invoke(null, params);

        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        long endTime = System.nanoTime();
        double spendTime = (endTime - startTime) / 1000000000.0; //计时结束

        ArrayHelper.printLine(1);

        boolean sorted = ArrayHelper.isSorted(arr, name, spendTime);// 检查是否为有序数组，可遍历数组
        return sorted;
    }

    /**
     * @param clazz:  含有静态 sort 方法的 .class
     * @param n:      数据规模：数组长度
     * @param times:  排序执行的次数(不同的数组)
     * @param repeat: 生成的数组是否允许重复值
     * @param print:  是否输出数组
     * @return void
     * @author Yancey
     * @description 多次执行排序操作, 使用 testArray 具体实现
     * @date 2024/2/5 21:00
     */
    public static <E extends Comparable<E>> void testMulti(Class clazz, int n, int times, boolean repeat, boolean random, boolean print) {
        E el = null;
        ArrayList<E[]> dataList = new ArrayList<>();
        E[] data = null;

        // 生成待排序的数据
        if (print) {
            System.out.println("Prepare Array: ");
        }

        for (int i = 0; i < times; i++) {
            data = ArrayGenerator.arrayGeneratorRandom(n, el, repeat, random);
            dataList.add(i, data);
            if (print) {
                ArrayHelper.printArray(data, "No" + (n + 1) + " : ");
            }
        }
        if (print) {
            System.out.println("[Array generate " + times + " times successful!]\n");
            ArrayHelper.printLine(1);//输出横线
        }
        int num = 0;
        //循环调用执行排序
        for (int i = 0; i < times; i++) {
            boolean res = true;
            System.out.println("第 " + (i + 1) + " 次执行：" + clazz.getSimpleName());
            res = testArray(clazz, print, dataList.get(i));
            num = !res ? num++ : num;
        }

        ArrayHelper.printLine(2);
        System.out.println("执行 "+clazz.getSimpleName()+" "+ times + " 次, 成功排序: "+ (times-num)+" 次");
    }


    /**
     * @param clazz:  含有实现排序的 sort 静态方法 .class
     * @param n:      希望的数据规模
     * @param repeat: 数据是否允许重复
     * @param print:  是否输出数组
     * @return void
     * @author Yancey
     * @description 测试单个排序
     * @date 2024/2/5 21:23
     */
    public static <E extends Comparable<E>> void test(Class clazz, int n, boolean repeat, boolean print) {
        E el = null;
        E[] data = ArrayGenerator.arrayGeneratorRandom(n, el, repeat);
        testArray(clazz, print, data);
    }

    /**
     * @param clazz:  存放多个含有实现 sort 静态方法的 .class 数组
     * @param n:      数据规模
     * @param repeat: 是否允许数组出现重复值
     * @param print:  是否输出数组
     * @return void
     * @author Yancey
     * @description 比较多种排序之间的效率值
     * @date 2024/2/5 21:17
     */
    public static <E extends Comparable<E>> void testCompare(Class[] clazz, int n, boolean repeat, boolean print) {
        // 提取 排序的方法名称
        ArrayList<String> name = new ArrayList<>();
        for (int i = 0; i < clazz.length; i++) {
            name.add(clazz[i].getSimpleName());
        }

        E el = null;
        for (int i = 0; i < clazz.length; i++) {
            testArray(clazz[i], print, ArrayGenerator.arrayGeneratorRandom(n, el, repeat, false));
        }
    }
}
