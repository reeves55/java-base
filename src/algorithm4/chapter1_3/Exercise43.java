package algorithm4.chapter1_3;

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: xiao
 * @date: 2020/4/16
 */
public class Exercise43 {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("please specify one path at least");
            return;
        }

        String path = args[0];
        Queue<String> filesPath = new LinkedList<>();
        System.out.println("📂视图: ");
        logFiles(path, 0, filesPath);


//        while (!filesPath.isEmpty()) {
//            System.out.println(filesPath.poll());
//        }
    }

    public static void logFiles(String path, int depth, Queue<String> queue) {
        File file = new File(path);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<depth; i++) {
            sb.append("   ");
        }

        for (File item : file.listFiles()) {
            System.out.println(sb.toString() + item.getName());
            if (item.isDirectory()) {
                logFiles(item.getAbsolutePath(), depth + 1, queue);
            }
        }
    }
}
