package com.mycompany.laba3.Type;

import com.mycompany.laba3.FileProcessor;
import com.mycompany.laba3.Reactor;
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
