package socket_and_serversocket;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TcpSocket_upset {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream=new FileInputStream("C:\\Users\\hh176\\Pictures\\Camera Roll\\蔡徐坤运球.gif");
        Socket socket=new Socket("127.0.0.1",8849);//创建一个指定Ip与端口号的客户端对象
        OutputStream outputStream = socket.getOutputStream();
        byte[] bytes=new byte[1024];
        int len=0;
        while ((len=fileInputStream.read(bytes))!=-1){
            outputStream.write(bytes, 0, len);//吧读取的文件上传到服务器上去

        }
        socket.shutdownOutput();//添加一个结束标记
        InputStream inputStream = socket.getInputStream();
while ((len=inputStream.read(bytes))!=-1){
    System.out.println(new String(bytes,0,len));//读取服务器传输回来的数据
        }
fileInputStream.close();
socket.close();
    }
}
