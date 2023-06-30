package com.task2.carriergot2.service;

import com.task2.carriergot2.model.Mediation_routing;
//import com.task2.carriergot2.model.Mediation_routing_child;

import java.math.BigInteger;
import java.util.List;

public interface iMediationService {

    public List<Mediation_routing> getAllIds();

    public Mediation_routing AddId(Mediation_routing instance, String username);

    public Mediation_routing UpdateId(Mediation_routing instance, String username);

    public Mediation_routing DeleteId(BigInteger id) throws Exception;

    public List<Mediation_routing> getRevisionsById(BigInteger Id);
}