package yuoxi.filetool;

import java.io.Closeable;
import java.io.IOException;

public class FileTool {
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

