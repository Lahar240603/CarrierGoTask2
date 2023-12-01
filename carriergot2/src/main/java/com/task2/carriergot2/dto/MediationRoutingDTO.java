package com.task2.carriergot2.dto;

import com.task2.carriergot2.entities.MediationRouting;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class MediationRoutingDTO {

    @NotNull
    @NotBlank
    @NotEmpty
    private String keyId;

    @NotNull
    @NotBlank
    @NotEmpty
    private String value;

//    private Long version;

    public MediationRouting buildEntity(Long version, Long id, String createdBy, LocalDateTime creationTime) {
        return MediationRouting.builder().keyId(this.keyId)
                .value(this.value)
                .version(version)
                .id(id)
                .createdBy(createdBy)
                .creationTime(creationTime)
                .build();
    }

}
