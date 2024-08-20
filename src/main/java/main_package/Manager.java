
package main_package;

import map_lang.JSONProcessor;
import map_lang.XMLProcessor;
import map_lang.YAMLProcessor;
import database.DatabaseConfigurer;
import database.StatementManager;
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
        statementManager.createAndFillReactorTypesTable(reactorList);
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
    
    public DatabaseConfigurer getDatabaseConfigurer (){
        return configurer;
    }
    
}
