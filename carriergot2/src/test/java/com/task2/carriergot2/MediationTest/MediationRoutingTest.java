package com.task2.carriergot2.MediationTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.task2.carriergot2.dto.MediationRoutingDTO;
import com.task2.carriergot2.entities.MediationRouting;
import com.task2.carriergot2.repositories.MediationRoutingRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.TestPropertySource;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MediationRoutingTest {

    @LocalServerPort
    private int port;

    private String baseUrl="http://localhost";

    private static RestTemplate restTemplate;

    private static HttpHeaders headers;

    @Autowired
    private MediationTestRepository mediationTestRepository;

    @Autowired MediationRoutingRepository mediationRoutingRepository;

    private ObjectMapper objectMapper;

    @BeforeAll
    public static void init(){
        restTemplate = new RestTemplate();
        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization" , "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJvcmdhbml6YXRpb25UeXBlIjoiUmVjZWl2ZXIiLCJvcmdhbml6YXRpb25UeXBlcyI6WyJSZWNlaXZlciJdLCJzdWIiOiJzcGVlZHlfam9kaWUiLCJmaXJzdE5hbWUiOiJTcGVlZHkiLCJsYXN0TmFtZSI6IkpvZGllIiwiZW1haWxBZGRyZXNzIjoic3BlZWR5X2pvZGllQHlvcG1haWwuY29tLTU1NDY4Iiwib3JnYW5pemF0aW9uVXVpZCI6IjY1ZTFhN2YwLTkwMmMtNGQ2ZC1hMDMwLTNhZGE4ODQwMDc0MSIsInBob25lTnVtYmVyIjoiOTE5OTk5OTk5OTkyIiwib3JnYW5pemF0aW9uTmFtZSI6IlNwZWVkeSBUcnVja2luZyIsIm9yZ2FuaXphdGlvbkNvZGUiOiJTUERZIiwib3JnYW5pemF0aW9uRGJJZCI6MTUyOTYsImJ1c2luZXNzQWRkcmVzcyI6IiJ9.0ZjtJQnHK6sNmFnkK4yiMf_pDogodGPa6qs665slfjd3Q4uomoslJhGOJRlypCGVlo1Q5q2MEVg25056NAUv_A");
    }

    @BeforeEach
    public void setUp() {
        baseUrl = baseUrl.concat(":").concat(port+"").concat("/mediation-routing/");
    }

    @Test
    public void testAdd() throws JsonProcessingException {
        baseUrl = baseUrl.concat("add");
        MediationRoutingDTO obj = new MediationRoutingDTO("key","value");
        HttpEntity<MediationRoutingDTO> entity = new HttpEntity<>(obj, headers);
        ResponseEntity<MediationRouting> response = this.restTemplate.exchange(baseUrl, HttpMethod.POST, entity, MediationRouting.class);
        assert(response.getStatusCode()).equals(HttpStatus.OK);
        assert(response.getBody().getKeyId()).equals(obj.getKeyId());
        assert(response.getBody().getValue()).equals(obj.getValue());
        assert(response.getBody().getCreatedBy()).equals("Speedy Jodie");
    }

    @Test
    public void testUpdate() {
        baseUrl = baseUrl.concat("update");
        MediationRoutingDTO obj = new MediationRoutingDTO("key", "value_new");
        MediationRouting instance = mediationRoutingRepository.findByKeyId(obj.getKeyId());
        HttpEntity<MediationRoutingDTO> entity = new HttpEntity<>(obj, headers);
        ResponseEntity<MediationRouting> response = this.restTemplate.exchange(baseUrl, HttpMethod.PUT, entity, MediationRouting.class);
        assert(response.getStatusCode()).equals(HttpStatus.OK);
        assert(response.getBody().getKeyId()).equals(obj.getKeyId());
        assert(response.getBody().getValue()).equals(obj.getValue());
        assert(response.getBody().getVersion()).equals(instance.getVersion()+1);
    }
}
