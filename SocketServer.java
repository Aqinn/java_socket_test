package socket粘包半包;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author Aqinn
 * @Date 2021/9/2 1:41 下午
 */
public class SocketServer {
    // 字节数组的长度
    private static final int BYTE_LENGTH = 20;

    public static void main(String[] args) throws IOException {
        // 创建 Socket 服务器
        ServerSocket serverSocket = new ServerSocket(9999);
        // 获取客户端连接
        Socket clientSocket = serverSocket.accept();
        // 得到客户端发送的流对象
        try (DataInputStream inputStream = new DataInputStream(clientSocket.getInputStream())) {
            while (true) {
                // 循环获取客户端发送的信息
                String receive = inputStream.readUTF();
                System.out.println("接收到客户端的信息是:" + receive);
            }
        }
    }
}
