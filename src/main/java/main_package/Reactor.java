package main_package;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "root")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Reactor {
    
    private String name;
    private double burnup;
    private String classe;
    private double electricalCapacity;
    private double firstLoad;
    private double kpd;
    private double lifeTime;
    private double enrichment;
    private double termalCapacity;
    private String  fileType;
    

    
    @JsonCreator
    public Reactor( @JsonProperty("class")
                    @JacksonXmlProperty(localName = "class")
                    String classe,
                    @JacksonXmlProperty(localName = "burnup")
                    @JsonProperty("burnup")
                    double burnup,
                    @JacksonXmlProperty(localName = "kpd")
                    @JsonProperty("kpd")
                    double kpd,
                    @JacksonXmlProperty(localName = "enrichment")
                    @JsonProperty("enrichment")
                    double enrichment,
                    @JacksonXmlProperty(localName = "electrical_capacity")
                    @JsonProperty("electrical_capacity")
                    double electricalCapacity,
                    @JacksonXmlProperty(localName = "first_load")
                    @JsonProperty("first_load")
                    double firstLoad,
                    @JacksonXmlProperty(localName = "life_time")
                    @JsonProperty("life_time")
                    double lifeTime,
                    @JacksonXmlProperty(localName = "termal_capacity")
                    @JsonProperty("termal_capacity")
                    double termalCapacity
                    ) {
        this.burnup = burnup;
        this.classe = classe;
        this.electricalCapacity = electricalCapacity;
        this.firstLoad = firstLoad;
        this.kpd = kpd;
        this.lifeTime = lifeTime;
        this.termalCapacity = termalCapacity;
        this.enrichment = enrichment;
    }
    
    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
    
    public String getClasse(){
        return classe;
    }
    
    public String getBurnup() {
        if (burnup == 0.0) return "Отсутствует информация.";
        return String.valueOf(burnup);
    }

    public String getElectricalCapacity() {
        if (electricalCapacity == 0.0) return "Отсутствует информация.";
        return String.valueOf(electricalCapacity);
    }

    public String getFirstLoad() {
        if (firstLoad == 0.0) return "Отсутствует информация.";
        return String.valueOf(firstLoad);
    }

    public String getKpd() {
        if (kpd == 0.0) return "Отсутствует информация.";
        return String.valueOf(kpd);
    }

    public String getLifeTime() {
        if (lifeTime == 0.0) return "Отсутствует информация.";
        return String.valueOf(lifeTime);
    }

    public String getEnrichment() {
        if (enrichment == 0.0) return "Отсутствует информация.";
        return String.valueOf(enrichment);
    }

    public String getTermalCapacity() {
        if (termalCapacity == 0.0) return "Отсутствует информация.";
        return String.valueOf(termalCapacity);
    }

    public String getFileType() {
        return fileType;
    }
    
    public void setName(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }


    
}
