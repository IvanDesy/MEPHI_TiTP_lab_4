package default_package;

import java.io.File;
import java.util.List;


public interface FileProcessor {

    List<Reactor> process(File file) throws Exception;
    
    public void setNext(FileProcessor fileProcessor);
}
