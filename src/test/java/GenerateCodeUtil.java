import java.io.*;

/**
 * @author feigeswjtu.cyf
 * @version $Id: GenerateCodeUtil.java, v 0.1 2021-02-26 11:51 feigeswjtu.cyf Exp $$
 */
public class GenerateCodeUtil {
    public static void main(String[] args) throws IOException {

        for(int i = 1; i< 1772; i++){
            String path = "/Users/chenyafei/workspace/project/java/leetcode/src/test/java/" + "code" + i;
            File file = new File(path);
            if(file.exists()){
                continue;
            }
            String packageName = "package code"+ i + ";";

            file.mkdir();

            file = new File(path + "/Solution.java");
            file.createNewFile();


            InputStream in = null;
            OutputStream out = null;
            try {
                in = new FileInputStream(new File("/Users/chenyafei/workspace/project/java/leetcode/src/main/java/Solution.java"));
                out = new FileOutputStream(file);
                out.write(packageName.getBytes());
                out.write("\n".getBytes());
                out.write("\n".getBytes());

                byte[] buffer = new byte[1024];
                int len;

                while ((len = in.read(buffer)) > 0) {
                    out.write(buffer, 0, len);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (in != null){
                    in.close();
                }
                if (out!= null){
                    out.close();
                }
            }




        }
    }
}
