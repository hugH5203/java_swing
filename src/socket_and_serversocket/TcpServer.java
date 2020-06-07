package socket_and_serversocket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {//服务器端
    public static void main(String[] args) throws IOException {
        ServerSocket server=new ServerSocket(8848);//创建指定端口号的服务器对象
        Socket socket = server.accept();//获取发送了请求的客户端对象
        InputStream inputStream = socket.getInputStream();//使用该客户端的网络字节流来读取客户端发来的数据
        byte[] bytes=new byte[1024];
        int len=inputStream.read(bytes);
        System.out.println(new String (bytes,0,len));
        OutputStream outputStream = socket.getOutputStream();//用客户端的网络字节流来写返回给客户端的信息
        outputStream.write("我已经收到，谢谢".getBytes());
        outputStream.flush();//刷新
        outputStream.close();//关闭写的
        inputStream.close();//关闭读的


    }
}
