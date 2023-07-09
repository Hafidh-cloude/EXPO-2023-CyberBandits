package DataBase;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

public class makebasesampah3 {
    public static void main(String[] args) {
        XStream xstream = new XStream(new StaxDriver());
        
        xstream.processAnnotations(KumpulanSampah.class);
        xstream.processAnnotations(AlldataSampah.class);

        AlldataSampah dataAll = new AlldataSampah();
        
        String xml = xstream.toXML(dataAll);
        FileOutputStream myFile = null;
        try {
            myFile = new FileOutputStream("penyimpanansampah3.xml");
            byte[] bytes = xml.getBytes("UTF-8");
            myFile.write(bytes);
        } catch (Exception e) {
            System.err.println("Perhatian: " + e.getMessage());
        } finally {
            if (myFile != null) {
                try {
                    myFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
