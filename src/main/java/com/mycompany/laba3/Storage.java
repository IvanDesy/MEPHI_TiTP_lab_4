package com.mycompany.laba3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Storage {
    private final List<Reactor> reactorStorage = new ArrayList<>();
    
    public void addToStorage(List<Reactor> list) {
        for(Reactor reactor: list) {
            if(isStoraged(reactor)) {
                Collections.replaceAll(reactorStorage,   findReactorByName(reactor.getName()), reactor);
            }
            else{
                reactorStorage.add(reactor);
            }
           
        }
        
    }
    
    public Boolean isStoraged(Reactor reactor) {
        for(Reactor anotherReactor: reactorStorage){
            if (anotherReactor.getName().equals(reactor.getName())){
                return true;
            }
        }
        return false;
    }
    
    public List<Reactor> getReactorStorage() {
        return reactorStorage;
    }
    
    public Reactor findReactorByName(String name) {
        for(Reactor reactor: reactorStorage) {
            if (reactor.getName().equals(name)) {
                return reactor;
            }
        }
        return null;
        
    }
}
