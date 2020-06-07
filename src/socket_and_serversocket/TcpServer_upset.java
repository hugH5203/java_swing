package socket_and_serversocket;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class TcpServer_upset {
    public static void main(String[] args) throws IOException {
        ServerSocket server=new ServerSocket(8849);//创建指定端口号的服务器对象
        while (true) {//让服务器一直监听请求
            Socket socket = server.accept();//获取发送了请求的客户端对象
new Thread(new Runnable(){//开启多线程让多个用户可同时在线上传，且互不影响

    @Override
    public void run() {
        try {
            String name = "你坤哥教你打球" + System.currentTimeMillis() + new Random().nextInt(9999) + ".gif"; //为了能够不覆盖原来的图片
            InputStream inputStream = socket.getInputStream();//使用该客户端的网络字节流来读取客户端发来的数据
            File file = new File("C:\\Users\\hh176\\Pictures\\上传到服务器");
            if (!file.exists()) {//如果不存在就创建这个文件夹
                file.mkdirs();
            }
            FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\hh176\\Pictures\\上传到服务器\\" + name);//吧读取到的文件写入到本地，达到上传的目的
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = inputStream.read(bytes)) != -1) {
                fileOutputStream.write(bytes, 0, len);
            }
            fileOutputStream.flush();
            socket.getOutputStream().write("已经上传，注意查看".getBytes());
            fileOutputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}).start();;
        }
    }
}
