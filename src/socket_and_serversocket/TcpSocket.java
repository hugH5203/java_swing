package socket_and_serversocket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TcpSocket {//客户端
    public static void main(String[] args) throws IOException {
        Socket socket=new Socket("127.0.0.1",8848);//创建一个指定Ip与端口号的客户端对象
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("你好，本机服务器".getBytes());
        outputStream.flush();
        InputStream inputStream = socket.getInputStream();
        byte[] bytes=new byte[1024];
        int len=inputStream.read(bytes);
        System.out.println(new String(bytes,0,len));
        outputStream.close();
        inputStream.close();

    }
}
