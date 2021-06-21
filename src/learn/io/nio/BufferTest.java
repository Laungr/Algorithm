package learn.io.nio;

import java.nio.IntBuffer;

public class BufferTest {
    public static void main(String[] args) {
        IntBuffer buffer = IntBuffer.allocate(5);

        for (int i = 0; i < 10; i++) {
            buffer.put(i * i);
        }
        // buffer 读写切换
        buffer.flip();

        while (buffer.hasRemaining()) {
            System.out.println(buffer.get());
        }
    }
}
