package aother.transfer;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * 文件传输Client端<br>
 * 功能说明
 */
public class FileTransferClient {

    /**
     * 服务端ip
     */
    private static final String SERVER_IP = "192.168.1.102";
    /**
     * 服务端端口
     */
    private static final int SERVER_PORT = 8899;

    /**
     * socket实例
     */
    private Socket clientSocket;

    /**
     * 文件流输入流
     */
    private FileInputStream fileInputStream;

    /**
     * socket的数据输出流
     */
    private DataOutputStream dataOutputStream;

    /**
     * 构造函数<br/>
     * 与服务器建立连接
     *
     * @throws Exception
     */
    public FileTransferClient() throws Exception {
        clientSocket = new Socket(SERVER_IP, SERVER_PORT);
        System.out.println("Cliect[port:" + clientSocket.getLocalPort() + "] 成功连接服务端");
    }

    /**
     * 向服务端传输文件
     *
     * @throws Exception
     */
    public void sendFile(String filePath) throws IOException {
        try {
            File file = new File("/Users/chenyafei/Documents/视频教程/耐雪甲鱼java架构P7/正式课篇/"+filePath);
            if (file.exists()) {
                fileInputStream = new FileInputStream(file);
                dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());

                // 文件名
                dataOutputStream.writeUTF(file.getName());
                dataOutputStream.flush();

                // 长度
                dataOutputStream.writeLong(file.length());
                dataOutputStream.flush();

                // 开始传输文件
                System.out.println("======== 开始传输文件 ========");
                byte[] bytes = new byte[1024];
                int length = 0;
                long progress = 0;
                while ((length = fileInputStream.read(bytes, 0, bytes.length)) != -1) {
                    dataOutputStream.write(bytes, 0, length);
                    dataOutputStream.flush();
                    progress += length;
                    System.out.print("| " + (100 * progress / file.length()) + "% |");
                }
                System.out.println();
                System.out.println("======== 文件传输成功 ========");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null)
                fileInputStream.close();
            if (dataOutputStream != null)
                dataOutputStream.close();
            clientSocket.close();
        }
    }

    /**
     * 入口
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            List<String> filePaths = new ArrayList<>();
            filePaths.add("01-RPC核心框架深入剖析（上）__.vep");
            filePaths.add("02-RPC核心框架深入剖析（中）__.vep");
            filePaths.add("03-RPC核心框架深入剖析（下）__.vep");
            filePaths.add("04-注册中心核心框架深入剖析（上）__.vep");
            filePaths.add("05-注册中心深入剖析（下）__.vep");
            filePaths.add("06-消息队列企业级应用及原理剖析（上）__.vep");
            filePaths.add("07-消息队列企业级应用及原理剖析（下）__.vep");
            filePaths.add("08DT时代转型中的数据中台建设__.vep");
            filePaths.add("09-服务容错企业级解决方案实现__.vep");
            filePaths.add("10-基础架构企业级项目案例__.vep");


            for (String filePath : filePaths) {
                FileTransferClient client = new FileTransferClient(); // 启动客户端连接
                client.sendFile(filePath); // 传输文件
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}