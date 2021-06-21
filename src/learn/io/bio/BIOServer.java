package learn.io.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class BIOServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(2333);
        System.out.println("服务器启动");
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 5, 1, TimeUnit.SECONDS, new ArrayBlockingQueue<>(1, true));
        System.out.println("等待连接");
        for (int i = 0; i < 5; i++) {
            // 客户端的连接会阻塞线程
            Socket accept = serverSocket.accept();
            System.out.println("客户端启动");
            threadPoolExecutor.execute(() -> handler(accept));
        }
    }

    public static void handler(Socket socket) {
        System.out.println(Thread.currentThread().getName());
        try (InputStream inputStream = socket.getInputStream()) {
            byte[] bytes = new byte[1024];
            while (true) {
                // read() 方法会阻塞线程，读不到数据就阻塞
                int read = inputStream.read(bytes);
                if (read == -1) {
                    break;
                }
                System.out.println(Thread.currentThread().getName());
                System.out.println(new String(bytes, 0, read));
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
