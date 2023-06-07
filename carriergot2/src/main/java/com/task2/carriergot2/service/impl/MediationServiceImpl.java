package com.task2.carriergot2.service.impl;

import com.task2.carriergot2.model.Mediation_routing;
import com.task2.carriergot2.repository.Mediation_Repository;
import com.task2.carriergot2.service.iMediationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Objects;

@Service
public class MediationServiceImpl implements iMediationService {

    @Autowired
    private Mediation_Repository routerRepository;

    @Override
    public List<Mediation_routing> getAllIds(){
        return (List<Mediation_routing>) routerRepository.findAll();
    }

    @Override
    public Mediation_routing AddId(Mediation_routing instance){
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
        return routerRepository.save(instance);
    }

    @Override
    public Mediation_routing UpdateId(Mediation_routing instance){
        Mediation_routing obj = null;
        try{
            obj = routerRepository.findById(instance.getId()).orElse(null);
            if(Objects.equals(obj.getKey_id(), instance.getKey_id()) && Objects.equals(obj.getValue(), instance.getValue())){
                obj.setId(instance.getId());
                obj.setKey_id(instance.getKey_id());
                obj.setValue(instance.getValue());
                obj.setVersion(instance.getVersion());
            }
            else{
                obj.setId(instance.getId());
                obj.setKey_id(instance.getKey_id());
                obj.setValue(instance.getValue());
                BigInteger ver = instance.getVersion();
                BigInteger inc = BigInteger.valueOf(1);
                BigInteger ans = ver.add(inc);
                obj.setVersion(ans);
            }
        }
        catch (Exception ex){
            ex.getMessage();
        }
        return routerRepository.save(obj);
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
}
