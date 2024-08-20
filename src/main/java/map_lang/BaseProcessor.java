package map_lang;

import main_package.FileProcessor;
import main_package.Reactor;
import java.io.File;
import java.util.List;


public abstract class BaseProcessor implements FileProcessor{
    FileProcessor next;
    
    @Override
    public abstract List<Reactor> process(File file) throws Exception;
    
    @Override
    public void setNext(FileProcessor fileProcessor) {
        this.next = fileProcessor;
    }
    
}
