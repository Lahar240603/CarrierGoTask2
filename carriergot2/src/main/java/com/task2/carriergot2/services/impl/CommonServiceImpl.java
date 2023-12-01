package com.task2.carriergot2.services.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.task2.carriergot2.repositories.AmendDeciderRepository;
import com.task2.carriergot2.services.ICommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommonServiceImpl implements ICommonService {

    public static final String PARAMS = "/?correlationId=DM&page=1&size=1000";

    @Autowired
    private AmendDeciderRepository amendDeciderRepository;

//    @Value("${blume.services.platform.host}")
//    private String hostName;
//
//    @Value("${blume.services.platform.getAllOrganization}")
//    private String getOrganization;

//    @Autowired
//    private HttpHeaderService httpHeaderService;

//    @Autowired
//    private RestTemplate restTemplate;

    @Override
    public List<String> getAllExistingOrgCodes() {
        return amendDeciderRepository.findDistinctOrgCode();
    }

    @Override
    public List<String> findAllOrgCodes() {
        List<String> init = new ArrayList<>();

//        Getting OrgCodes from Blume API
        String uri = "https://dev-apps.blumesolutions.com/blumepfmdapi/v2/organization/?correlationId=DM&page=1&size=1000";
        RestTemplate temp = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJvcmdhbml6YXRpb25UeXBlIjoiUmVjZWl2ZXIiLCJvcmdhbml6YXRpb25UeXBlcyI6WyJSZWNlaXZlciJdLCJzdWIiOiJzcGVlZHlfam9kaWUiLCJmaXJzdE5hbWUiOiJTcGVlZHkiLCJsYXN0TmFtZSI6IkpvZGllIiwiZW1haWxBZGRyZXNzIjoic3BlZWR5X2pvZGllQHlvcG1haWwuY29tLTU1NDY4Iiwib3JnYW5pemF0aW9uVXVpZCI6IjY1ZTFhN2YwLTkwMmMtNGQ2ZC1hMDMwLTNhZGE4ODQwMDc0MSIsInBob25lTnVtYmVyIjoiOTE5OTk5OTk5OTkyIiwib3JnYW5pemF0aW9uTmFtZSI6IlNwZWVkeSBUcnVja2luZyIsIm9yZ2FuaXphdGlvbkNvZGUiOiJTUERZIiwib3JnYW5pemF0aW9uRGJJZCI6MTUyOTYsImJ1c2luZXNzQWRkcmVzcyI6IiJ9.0ZjtJQnHK6sNmFnkK4yiMf_pDogodGPa6qs665slfjd3Q4uomoslJhGOJRlypCGVlo1Q5q2MEVg25056NAUv_A");
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
                        init.add(orgCode);
                    }
                }

            });

        } catch (Exception e) {
            e.printStackTrace();
        }
        Collections.sort(init);
        return init;
    }
}