package com.example.Projeto_0.controllers;

import java.util.ArrayList;

import com.example.Projeto_0.models.CurricularUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/api/java/tester")
public class JavaTesterController {
  
    private static double[] grades=new double[3];



    private String[] ucs;



    double maximum=0;
    int average=0;
    int i=0;
    String name;
    int number;
    double height; 
    boolean football;
    String f;
    String letter;
    private Logger logger = LoggerFactory.getLogger(JavaTesterController.class);
  
   
    @GetMapping(path = "/access/{student}/{covid}",
    produces= MediaType.APPLICATION_JSON_VALUE)
    public boolean getGreeting(@PathVariable("student") boolean isStudent, @PathVariable("covid") boolean hasCovid) {
        if(isStudent&&hasCovid==false) return true;
        else return false;
    }
    @GetMapping(path = "/required/{student}/{temperature}/{classType}",
    produces= MediaType.APPLICATION_JSON_VALUE)
    public boolean getRequired(@PathVariable("student") boolean isStudent, @PathVariable("temperature") double hasCovid, @PathVariable("classType") String type) {
        if(isStudent&&type=="presencial"&&(34.4<hasCovid&&hasCovid<37.5)) return true;
        else return false;
    }

    @GetMapping(path = "/evacuation/{fire}/{numberOfCovids}/{powerShutdown}/{comeBackTime}/",
    produces= MediaType.APPLICATION_JSON_VALUE)
    public boolean getRequired(@PathVariable("Covids") double numberOfCovids, @PathVariable("powerShutdown") boolean powerShutdown, @PathVariable("comeBackTime") double comeBackTime) {
        if(numberOfCovids>5||powerShutdown&&comeBackTime>15)return true; else return false;
    }

    @GetMapping(path = "/average",
    produces= MediaType.APPLICATION_JSON_VALUE)
    public double averageR(double grades[], double average, int i) {
    
        for(i=0;i<3;i++){
                
            average=grades[i]+average;
        }
        average=average/3;
        return average;
    }
    @GetMapping(path = "/maximumG",
    produces= MediaType.APPLICATION_JSON_VALUE)
    public double maximumG(double grades[], double maximum, int i) {
        JavaTesterController.grades = grades;
      
      
        while(i<3){
            
        if(maximum<grades[i]){   
        maximum=grades[i];
        i++;
        }
     else i++;
    }
        return maximum;
    }
    @GetMapping(path = "/Grade",
    produces= MediaType.APPLICATION_JSON_VALUE)
    public double returnG(double grades[], String ucs[], int i) {
       // if (ucs)
      
       
       return i ;
    }
    @GetMapping(path = "/howManyUC",
    produces= MediaType.APPLICATION_JSON_VALUE)
    public double howManyUC(double grades[], double average, int i) {
    
        for(i=0;i<3;i++){
                
            average=grades[i]+average;
        }
        average=average/3;
        return average;
    }
    @GetMapping(path = "/returnString",
    produces= MediaType.APPLICATION_JSON_VALUE)
    public double returnString(double grades[], double average, int i) {
    
        for(i=0;i<3;i++){
                
            average=grades[i]+average;
        }
        average=average/3;
        return average;
    }
 


    private ArrayList<CurricularUnit> units = new ArrayList<CurricularUnit>();

    @PostMapping(path = "/units",produces= MediaType.APPLICATION_JSON_VALUE) 
    public CurricularUnit saveUnit(@RequestBody CurricularUnit unit) {
    logger.info("Added unit "+unit.getName());
    units.add(unit);
    return unit;
    }
    @GetMapping(path = "/units",
    produces= MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<CurricularUnit> getUnits() {
    logger.info("Get "+units.size()+" Units");
    return units;
    } 

   
}
