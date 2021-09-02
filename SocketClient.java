package socket粘包半包;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @Author Aqinn
 * @Date 2021/9/2 1:42 下午
 */
public class SocketClient {
    public static void main(String[] args) throws IOException {
        // 创建 Socket 客户端并尝试连接服务器端
        Socket socket = new Socket("127.0.0.1", 9999);
        // 发送的消息内容
        final String message = "Hi,Java.";
        // 使用输出流发送消息
        try (DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream())) {
            // 给服务器端发送 10 次消息
            for (int i = 0; i < 10; i++) {
                // 发送消息
                outputStream.writeUTF(message);
            }
        }
    }
}
