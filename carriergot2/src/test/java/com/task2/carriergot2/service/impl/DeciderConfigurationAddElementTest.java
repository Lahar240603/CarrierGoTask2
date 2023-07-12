package com.task2.carriergot2.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.task2.carriergot2.dto.DeciderConfigurationDTO;
import com.task2.carriergot2.entities.AmendDecider;
import com.task2.carriergot2.entities.UpdateDecider;
import com.task2.carriergot2.enums.AmendDeciderEnum;
import com.task2.carriergot2.enums.UpdateDeciderEnum;
import com.task2.carriergot2.repositories.AmendDeciderRepository;
import com.task2.carriergot2.repositories.UpdateDeciderRepository;
import com.task2.carriergot2.services.IDeciderConfigurationService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.*;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:application-integrationtest.properties")
//Setting up the required Data in the Database.
@Sql({ "classpath:schema.sql", "classpath:data.sql" })
public class DeciderConfigurationAddElementTest {

    @LocalServerPort
    private Integer port;

    private static final Logger logger = LoggerFactory.getLogger(DeciderConfigurationAddElementTest.class);

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UpdateDeciderRepository updateDeciderRepository;

    @Autowired
    private AmendDeciderRepository amendDeciderRepository;

    @Autowired
    private IDeciderConfigurationService deciderConfigurationService;

    private static HttpHeaders headers;

    @BeforeAll
    public static void init() {
        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization" , "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJvcmdhbml6YXRpb25UeXBlIjoiUmVjZWl2ZXIiLCJvcmdhbml6YXRpb25UeXBlcyI6WyJSZWNlaXZlciJdLCJzdWIiOiJzcGVlZHlfam9kaWUiLCJmaXJzdE5hbWUiOiJTcGVlZHkiLCJsYXN0TmFtZSI6IkpvZGllIiwiZW1haWxBZGRyZXNzIjoic3BlZWR5X2pvZGllQHlvcG1haWwuY29tLTU1NDY4Iiwib3JnYW5pemF0aW9uVXVpZCI6IjY1ZTFhN2YwLTkwMmMtNGQ2ZC1hMDMwLTNhZGE4ODQwMDc0MSIsInBob25lTnVtYmVyIjoiOTE5OTk5OTk5OTkyIiwib3JnYW5pemF0aW9uTmFtZSI6IlNwZWVkeSBUcnVja2luZyIsIm9yZ2FuaXphdGlvbkNvZGUiOiJTUERZIiwib3JnYW5pemF0aW9uRGJJZCI6MTUyOTYsImJ1c2luZXNzQWRkcmVzcyI6IiJ9.0ZjtJQnHK6sNmFnkK4yiMf_pDogodGPa6qs665slfjd3Q4uomoslJhGOJRlypCGVlo1Q5q2MEVg25056NAUv_A");
    }
    private String createURLWithPort() {
        return "http://localhost:" + port + "/decider-configuration/update/ZZZZ";
    }

    @Test
    public  void AddElementTest() throws Exception{
//        Setting up the Changes.
        UpdateDecider updateEntry = new UpdateDecider(null, "abcdefg", UpdateDeciderEnum.getEnum("O/R"),UpdateDeciderEnum.getEnum("O/R"),UpdateDeciderEnum.getEnum("O/R"),UpdateDeciderEnum.getEnum("O/R"),UpdateDeciderEnum.getEnum("O/R"),UpdateDeciderEnum.getEnum("O/R"),UpdateDeciderEnum.getEnum("O/R"),UpdateDeciderEnum.getEnum("O/R"),UpdateDeciderEnum.getEnum("O/R"),"DM",null,null,null,null,null);
        List<UpdateDecider> updateList = new ArrayList<>();
        updateList.add(updateEntry);

        AmendDecider amendEntry =new AmendDecider(null, "abcdefg", AmendDeciderEnum.getEnum("NA"),AmendDeciderEnum.getEnum("NA"),AmendDeciderEnum.getEnum("NA"),AmendDeciderEnum.getEnum("NA"),AmendDeciderEnum.getEnum("NA"),AmendDeciderEnum.getEnum("NA"),AmendDeciderEnum.getEnum("NA"),AmendDeciderEnum.getEnum("NA"),AmendDeciderEnum.getEnum("NA"),"DM",null,null,null,null,null)
        List<AmendDecider> amendList = new ArrayList<>();
        amendList.add(amendEntry);

        DeciderConfigurationDTO addElementRequest= new DeciderConfigurationDTO(amendList , updateList);

        //        Making the Call through the controller.
        HttpEntity<String> entity = new HttpEntity<>(objectMapper.writeValueAsString(addElementRequest), headers);
        ResponseEntity<DeciderConfigurationDTO> response = restTemplate.exchange(
                createURLWithPort(), HttpMethod.PUT, entity, DeciderConfigurationDTO.class);

        //Checking Response
        List<UpdateDecider> updatedList = Objects.requireNonNull(response.getBody()).getUpdateList();
        List<AmendDecider> amendedList = Objects.requireNonNull(response.getBody()).getAmendList();
        System.out.println(response.getStatusCode());
        assert response.getStatusCode().equals(HttpStatus.OK);
        assert updatedList != null;
        assert amendedList != null;


    }

}
