package com.task2.carriergot2.controller;

import com.task2.carriergot2.model.Mediation_routing;
//import com.task2.carriergot2.model.Mediation_routing_child;
import com.task2.carriergot2.repository.Mediation_Repository;
import com.task2.carriergot2.service.iMediationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/ids")
@CrossOrigin("http://localhost:3000/")
public class MediationController {

    @Autowired
    private iMediationService routerService;

    @Autowired
    private Mediation_Repository routerRepository;

    @GetMapping("/allIds")
    public ResponseEntity<List<Mediation_routing>> getAllIds(){
        List<Mediation_routing> instance = null;
        try{
            instance = routerService.getAllIds();
        }
        catch(Exception ex){
            ex.getMessage();
        }
        return new ResponseEntity<List<Mediation_routing>>(instance, HttpStatus.OK);
    }

    @PostMapping("/addId")
    public ResponseEntity<Mediation_routing> AddId(@RequestBody Mediation_routing instance, @RequestAttribute("username") String username){
        Mediation_routing obj = routerService.AddId(instance, username);
//        try{
//            obj = routerService.AddId(instance);
//        }
//        catch (Exception ex){
//            ex.getMessage();
//        }
        return new ResponseEntity<Mediation_routing>(obj, HttpStatus.OK);
    }

//    @PostMapping("/addId")
//    Mediation_routing instance(@RequestBody Mediation_routing instance){
//        return routerRepository.save(instance);
//    }

    @PutMapping("/updateId")
    public ResponseEntity<Mediation_routing> UpdateId(@RequestBody Mediation_routing instance, @RequestAttribute("username") String username){
        Mediation_routing obj = routerService.UpdateId(instance, username);
//        try{
//            obj = routerService.UpdateId(instance);
//        }
//        catch (Exception ex){
//            ex.getMessage();
//        }
        //return routerService.UpdateId(instance, id);
        return new ResponseEntity<Mediation_routing>(obj, HttpStatus.OK);

    }

    @DeleteMapping("/deleteId/{id}")
    public ResponseEntity<Mediation_routing> DeleteId(@PathVariable("id") BigInteger Id){
        Mediation_routing obj = null;
        try{
            obj = routerService.DeleteId(Id);
        }
        catch(Exception ex){
            ex.getMessage();
        }
        return new ResponseEntity<Mediation_routing>(obj, HttpStatus.OK);
    }

//    @GetMapping("/getAllChilds/{id}")
//    public ResponseEntity<List<Mediation_routing_child>> getChilds(@PathVariable("id") BigInteger Id){
//        List<Mediation_routing_child> instance = new ArrayList<Mediation_routing_child>();
//        try{
//            instance = routerService.getChilds(Id);
//        }
//        catch(Exception ex){
//            ex.getMessage();
//        }
//        return new ResponseEntity<List<Mediation_routing_child>>(instance, HttpStatus.OK);
//    }

    @GetMapping("/getAllChilds/{id}")
    public ResponseEntity<List<Mediation_routing>> getRevisionsById(@PathVariable("id") BigInteger Id){
        List<Mediation_routing> obj = routerService.getRevisionsById(Id);
        return new ResponseEntity<List<Mediation_routing>>(obj, HttpStatus.OK);
    }
}