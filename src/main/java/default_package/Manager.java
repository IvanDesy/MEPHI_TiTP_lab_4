
package default_package;

import type.JSONProcessor;
import type.XMLProcessor;
import type.YAMLProcessor;
import data_base.DatabaseConfigurer;
import data_base.StatementManager;
import java.io.File;
import java.sql.SQLException;
import java.util.List;


public class Manager {
    private DatabaseConfigurer configurer = new DatabaseConfigurer();
    private YAMLProcessor yamlProcessor = new YAMLProcessor();
    private JSONProcessor jsonProcessor = new JSONProcessor();
    private XMLProcessor xmlProcessor = new XMLProcessor();
    private Storage storage = new Storage();
    private StatementManager statementManager ;
    
    public void connectToDatabase() throws SQLException, ClassNotFoundException {
        statementManager = new StatementManager(configurer);
        
    }
    
    
    public void processingFile(File file) throws Exception{
        List<Reactor> reactorList = yamlProcessor.process(file);
        
        storage.addToStorage(reactorList);
        
    }
    
    public Manager() {
        setUpProcessors();
    }
    
    public void setUpProcessors() {
        yamlProcessor.setNext(jsonProcessor);
        jsonProcessor.setNext(xmlProcessor);
    }
    
    public Storage getStorage(){
        return storage;
    }
    
 public StatementManager getStatementManager() {
     return statementManager;
 }
    
    
}
