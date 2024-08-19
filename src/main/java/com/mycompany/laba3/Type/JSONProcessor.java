package com.mycompany.laba3.Type;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.laba3.Reactor;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class JSONProcessor extends BaseProcessor {

    @Override
    public List<Reactor> process(File file) throws Exception {
        List<Reactor> reactors = new ArrayList<>();
        
        if("json".equals(file.getName().substring(file.getName().indexOf(".")+1))){
            Map<String, Reactor> map;
            ObjectMapper mapper = new ObjectMapper();
            map = mapper.readValue(file, new TypeReference<Map<String, Reactor>>(){});
            for(Map.Entry<String, Reactor> entry: map.entrySet()) {
                Reactor reactor = entry.getValue();
                reactor.setFileType(file.getName());
                reactor.setName(entry.getKey());
                reactors.add(reactor);
            }
            
        }
        else{
            reactors = next.process(file);
        }

        return reactors;
    }
    
    }
