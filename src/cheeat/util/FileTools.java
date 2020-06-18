package cheeat.util;

import java.io.Closeable;
import java.io.IOException;

public class FileTools {
    public static void close(Closeable closeable){
        if (closeable!=null){
            try {
                closeable.close();
            }catch (IOException e){
                e.printStackTrace();
                throw new RuntimeException();
            }
        }
    }
}
