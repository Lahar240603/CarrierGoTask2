package com.task2.carriergot2.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.task2.carriergot2.model.AmendWorkOrderStateDecider;
import com.task2.carriergot2.repository.AmendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.task2.carriergot2.service.iAmendServiceGetOrg;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class AmendServiceGetOrgImpl implements iAmendServiceGetOrg {

    @Autowired
    private AmendRepository amendRepository;

    @Override
    public List<AmendWorkOrderStateDecider> findByOrgCode(String orgCode) {
        return amendRepository.findAllByOrgCode(orgCode, Sort.by(Sort.Direction.ASC, "elementName"));
    }

    @Override
    public List<String> findAllOrgCodes(String token) {
        List<String> init =  amendRepository.findDistinctOrgCode();

        init.add("APIS");

//        Getting OrgCodes from Blume API
        String uri = "https://dev-apps.blumesolutions.com/blumepfmdapi/v2/organization/?correlationId=DM&page=1&size=1000";
        RestTemplate temp = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        String result = null;
        try {
            ResponseEntity<String> response = temp.exchange(
                uri,
                HttpMethod.GET,
                entity,
                String.class
        );
            result = response.getBody();
        }
        catch (Exception e) { e.printStackTrace(); }
        try {
            JsonNode jsonNode = new ObjectMapper().readTree(result);
            JsonNode res = jsonNode.get("results");
            res.forEach((node) -> {
                String orgCode = "";
                Optional<JsonNode> code = Optional.ofNullable(node.get("scac"));
                if (code.isPresent()) {
                    orgCode = code.get().asText();

                    if(!init.contains(orgCode) && !orgCode.isEmpty()) {
                        System.out.println(orgCode);
                        init.add(orgCode);
                    }
                }

            });

        } catch (Exception e) {
            e.printStackTrace();
        }
        return init;
    }

    
}
