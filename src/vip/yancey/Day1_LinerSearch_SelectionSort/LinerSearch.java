/**
 * @author Yancey
 * @version 1.0
 * @className LinerSearch
 * @date 2023/11/22-17:40
 * @description 线性查找，顾名思义。
 */
package vip.yancey.Day1_LinerSearch_SelectionSort;

public class LinerSearch {
    // 不希望外部创建该类的实例化对象，所以私有化该类的构造器
    private LinerSearch(){};

    public static int search(int[] data, int target) {
        if (data == null || data.length == 0){
            return -1;
        }
        for (int i = 0; i < data.length; i++) {
            if (data[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
