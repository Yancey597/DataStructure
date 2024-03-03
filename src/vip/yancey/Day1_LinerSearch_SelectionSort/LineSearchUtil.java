package vip.yancey.Day1_LinerSearch_SelectionSort;/**
 * ClassName: LineSearchUtil
 * Package: vip.yancey.Day1
 * Description:
 *
 * @Author Yancey
 * @Create 2023/11/22 17:45
 * @Version 1.0
 */
//import org.junit.Test;

/**
 * @author Yancey
 * @version 1.0
 * @className LineSearchUtil
 * @date 2023/11/22-17:45
 * @description 完成基于泛型类的通用线性查找方法
 */

public class LineSearchUtil {
    private LineSearchUtil() {
    }

    public static <E> int search(E[] data, E target) {
        if (data == null || data.length == 0) {
            return -1;
        }

        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }
}
