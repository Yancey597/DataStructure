package Utils.ArrayUtils;//import org.junit.Test;

import java.io.*;

/**
 * @author Yancey
 * @version 1.0
 * @className DeepCopy
 * @date 2024/2/5-23:08
 * @description TODO
 */




public class DeepCopy {
    public static <E extends Serializable & Comparable<E>> E[] deepCopyArray(E[] original) {
        try {
            // 将原始数组写入字节数组输出流
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(original);

            // 从字节数组输入流读取深拷贝后的数组
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            return (E[]) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("Deep copy failed", e);
        }
    }
}