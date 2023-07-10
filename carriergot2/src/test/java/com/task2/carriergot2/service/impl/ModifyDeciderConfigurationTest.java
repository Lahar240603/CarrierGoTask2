package com.task2.carriergot2.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.task2.carriergot2.enums.AmendWorkOrderStateDeciderEnum;
import com.task2.carriergot2.enums.UpdateWorkOrderStateDeciderEnum;
import com.task2.carriergot2.model.AmendWorkOrderStateDecider;
import com.task2.carriergot2.model.UpdateWorkOrderStateDecider;
import com.task2.carriergot2.repository.AmendRepository;
import com.task2.carriergot2.repository.UpdateRepository;
import com.task2.carriergot2.utils.WorkOrderStateDeciderRequest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:application-integrationtest.properties")
//Setting up the required Data in the Database.
@Sql({ "classpath:schema.sql", "classpath:data.sql" })
public class ModifyDeciderConfigurationTest {

    @LocalServerPort
    private Integer port;

    private static final Logger logger = LoggerFactory.getLogger(ModifyDeciderConfigurationTest.class);

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UpdateRepository updateRepository;

    @Autowired
    private AmendRepository amendRepository;

    @Autowired
    private WorkOrderStateDeciderGetOrg workOrderStateDeciderGetOrg;

    private static HttpHeaders headers;

    @BeforeAll
    public static void init() {
        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization" , "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJvcmdhbml6YXRpb25UeXBlIjoiUmVjZWl2ZXIiLCJvcmdhbml6YXRpb25UeXBlcyI6WyJSZWNlaXZlciJdLCJzdWIiOiJzcGVlZHlfam9kaWUiLCJmaXJzdE5hbWUiOiJTcGVlZHkiLCJsYXN0TmFtZSI6IkpvZGllIiwiZW1haWxBZGRyZXNzIjoic3BlZWR5X2pvZGllQHlvcG1haWwuY29tLTU1NDY4Iiwib3JnYW5pemF0aW9uVXVpZCI6IjY1ZTFhN2YwLTkwMmMtNGQ2ZC1hMDMwLTNhZGE4ODQwMDc0MSIsInBob25lTnVtYmVyIjoiOTE5OTk5OTk5OTkyIiwib3JnYW5pemF0aW9uTmFtZSI6IlNwZWVkeSBUcnVja2luZyIsIm9yZ2FuaXphdGlvbkNvZGUiOiJTUERZIiwib3JnYW5pemF0aW9uRGJJZCI6MTUyOTYsImJ1c2luZXNzQWRkcmVzcyI6IiJ9.0ZjtJQnHK6sNmFnkK4yiMf_pDogodGPa6qs665slfjd3Q4uomoslJhGOJRlypCGVlo1Q5q2MEVg25056NAUv_A");
    }

    private String createURLWithPort() {
        return "http://localhost:" + port + "/workorderstate/update/ZZZZ";
    }


    @Test
    public void UpdateEndpointTest() throws Exception{
//        Setting up the Changes.
        UpdateWorkOrderStateDecider updateWorkOrderStateDecider = new UpdateWorkOrderStateDecider();
        updateWorkOrderStateDecider.setDbId(1L);
        updateWorkOrderStateDecider.setAccepted(UpdateWorkOrderStateDeciderEnum.getEnum("O"));
        List<UpdateWorkOrderStateDecider> updateList = new ArrayList<>();
        updateList.add(updateWorkOrderStateDecider);

        AmendWorkOrderStateDecider amendWorkOrderStateDecider = new AmendWorkOrderStateDecider();
        amendWorkOrderStateDecider.setDbId(1L);
        amendWorkOrderStateDecider.setAccepted(AmendWorkOrderStateDeciderEnum.getEnum("R"));
        List<AmendWorkOrderStateDecider> amendList = new ArrayList<>();
        amendList.add(amendWorkOrderStateDecider);

        WorkOrderStateDeciderRequest workOrderStateDeciderRequest = new WorkOrderStateDeciderRequest(amendList, updateList);

//        Storing old values.
        List<UpdateWorkOrderStateDecider> oldUpdateList = updateRepository.findAll();
        List<AmendWorkOrderStateDecider> oldAmendList = amendRepository.findAll();


//        Making the Call through the controller.
        HttpEntity<String> entity = new HttpEntity<>(objectMapper.writeValueAsString(workOrderStateDeciderRequest), headers);
        ResponseEntity<WorkOrderStateDeciderRequest> response = restTemplate.exchange(
                createURLWithPort(), HttpMethod.PUT, entity, WorkOrderStateDeciderRequest.class);

//        Checking the Response.
        List<UpdateWorkOrderStateDecider> updatedList = Objects.requireNonNull(response.getBody()).getUpdateList();
        List<AmendWorkOrderStateDecider> amendedList = Objects.requireNonNull(response.getBody()).getAmendList();
        System.out.println(response.getStatusCode());
        assert response.getStatusCode().equals(HttpStatus.OK);
        assert updatedList != null;
        assert amendedList != null;
        assert updatedList.get(0).getAccepted().equals(UpdateWorkOrderStateDeciderEnum.getEnum("O"));
        assert updatedList.get(0).getUpdatedBy().equals("Speedy Jodie");
        assert amendedList.get(0).getAccepted().equals(AmendWorkOrderStateDeciderEnum.getEnum("R"));
        assert amendedList.get(0).getUpdatedBy().equals("Speedy Jodie");

    }
}
