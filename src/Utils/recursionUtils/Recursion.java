package Utils.recursionUtils;//import org.junit.Test;

/**
 * @author Yancey
 * @version 1.0
 * @className GenerateDepthString
 * @date 2023/12/9-16:59
 * @description 方便理解递归调用的工具类
 */

public class Recursion {
    public static String GenerateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            for (int j = 0; j < 2; j++) {//j < 2控制打印的次数
                res.append("- ");
            }
        }
        return res.toString();
    }

    public static void GenerateDepthString(int depth, String str, boolean newline) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            for (int j = 0; j < 2; j++) {//j < 2控制打印的次数
                res.append("- ");
            }
        }
        res.append(str);

        if (newline) {
            System.out.println(res);
        }else{
            System.out.print(res);
        }


    }
}
