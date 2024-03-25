package template;//import org.junit.Test;

/**
 * @author Yancey
 * @version 1.0
 * @className date
 * @date 2024-03-22-10:41
 * @description 判断 8 位日期是否合法的模板
 */

public class Date {
    public static void main(String[] args) {
        boolean check = check(12340608);
        System.out.println("check = " + check);
    }

    public static boolean check(int date) {
        // 检查日期是否符合要求
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        // 检查年份是否是闰年
        int year = (int) (date / 10E4);
        boolean lunarYear = false;
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            lunarYear = true;
        }
        // 检查月份是否符合要求
        int month = date / 100 % 100;
        if (month > 12 || month < 1) {
            return false;
        }

        // 针对闰年处理
        if (lunarYear && month == 2) {
            days[1] = 29;
        }
        int day = date % 100;
        return day <= days[month - 1] && day >= 1;
    }

}
