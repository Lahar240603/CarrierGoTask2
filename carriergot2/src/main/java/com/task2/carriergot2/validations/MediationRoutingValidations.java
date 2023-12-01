//package com.task2.carriergot2.validations;
//
//import com.task2.carriergot2.dto.MediationRoutingDTO;
//import com.task2.carriergot2.entities.MediationRouting;
//import com.task2.carriergot2.repositories.MediationRoutingRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//
//public class MediationRoutingValidations {
//
//    @Autowired
//    private MediationRoutingRepository mediationRoutingRepository;
//
//    public MediationRouting checkAdd(MediationRoutingDTO mediationRoutingDTO){
//        MediationRouting existingMediationRouting = mediationRoutingRepository.findByKeyId(mediationRoutingDTO.getKeyId())
//        if(mediationRoutingRepository.findByKeyId(mediationRoutingDTO.getKeyId())!=null){
//            return null;
//        }
//        else{
//            return
//        }
//    }
//}
