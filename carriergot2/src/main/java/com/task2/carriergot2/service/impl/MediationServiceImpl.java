package com.task2.carriergot2.service.impl;

import com.task2.carriergot2.model.Mediation_routing;
import com.task2.carriergot2.model.Mediation_routing_child;
import com.task2.carriergot2.repository.Mediation_Repository;
import com.task2.carriergot2.repository.Mediation_Repository_child;
import com.task2.carriergot2.service.iMediationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
public class MediationServiceImpl implements iMediationService {

    @Autowired
    private Mediation_Repository routerRepository;

    @Autowired
    private Mediation_Repository_child childRepository;

    @Override
    public List<Mediation_routing> getAllIds(){
        return (List<Mediation_routing>) routerRepository.findAll();
    }

    @Override
    public Mediation_routing AddId(Mediation_routing instance, String username){
        Mediation_routing obj = new Mediation_routing();
        obj.setCreatedBy(username);
        obj.setKey_id(instance.getKey_id());
        obj.setValue(instance.getValue());
        obj.setVersion(instance.getVersion());
        obj.setCreatedDateTime(LocalDateTime.now());
//        Mediation_routing obj = null;
//        try{
//            obj = routerRepository.findById(instance.getId()).orElse(null);
//            obj.setId(instance.getId());
//            obj.setKey_id(instance.getKey_id());
//            obj.setValue(instance.getValue());
//            obj.setVersion(instance.getVersion());
//        }
//        catch (Exception ex){
//            ex.getMessage();
//        }
        return routerRepository.save(obj);
    }

    @Override
    public Mediation_routing UpdateId(Mediation_routing instance, String username){
//        Mediation_routing obj = null;
//        Mediation_routing_child child_obj = new Mediation_routing_child();
        try{
            Mediation_routing obj = routerRepository.findById(instance.getId()).orElseThrow(() -> new EntityNotFoundException("Entity not found"));
            Mediation_routing_child child_obj = new Mediation_routing_child();
//            obj = routerRepository.findById(instance.getId()).orElse(null);
            child_obj.setKey_id(obj.getKey_id());
            child_obj.setValue(obj.getValue());
            child_obj.setVersion(obj.getVersion());
            child_obj.setCreatedBy(obj.getCreatedBy());
            child_obj.setCreatedDateTime(obj.getCreatedDateTime());
            child_obj.setUpdatedBy(obj.getUpdatedBy());
            child_obj.setUpdatedDateTime(obj.getUpdatedDateTime());
            child_obj.setMediationRouting(obj);
//            if(Objects.equals(obj.getKey_id(), instance.getKey_id()) && Objects.equals(obj.getValue(), instance.getValue())){
//                obj.setId(instance.getId());
//                obj.setKey_id(instance.getKey_id());
//                obj.setValue(instance.getValue());
//                obj.setVersion(instance.getVersion());
//            }
//            else{
            obj.setId(instance.getId());
            obj.setKey_id(instance.getKey_id());
            obj.setValue(instance.getValue());
            BigInteger ver = instance.getVersion();
            BigInteger inc = BigInteger.valueOf(1);
            BigInteger ans = ver.add(inc);
            obj.setVersion(ans);
            obj.setUpdatedBy(username);
            obj.setUpdatedDateTime(LocalDateTime.now());
            childRepository.save(child_obj);
            return routerRepository.save(obj);
            //}
        }
        catch (EntityNotFoundException ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
        catch (Exception ex){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to update entity");
        }
//        return routerRepository.save(obj);
    }

    @Override
    public Mediation_routing DeleteId(BigInteger Id) throws Exception {
        Mediation_routing deleted_id = null;
        try{
            deleted_id = routerRepository.findById(Id).orElse(null);
            if(deleted_id == null){
                throw new Exception("Id not available");
            }
            else{
                routerRepository.deleteById(Id);
            }
        }
        catch(Exception ex){
            throw ex;
        }
        return deleted_id;
    }

    @Override
    public List<Mediation_routing_child> getChilds(BigInteger Id){
//        Parent obj = new Parent();
//        Parent obj = routerRepository.findById(Id).orElse(null);
        Mediation_routing obj = routerRepository.findById(Id).get();
        return (List<Mediation_routing_child>) obj.getChilds();
    }
}