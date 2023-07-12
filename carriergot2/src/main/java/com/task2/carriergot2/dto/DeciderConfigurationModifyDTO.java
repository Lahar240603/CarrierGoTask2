package com.task2.carriergot2.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class DeciderConfigurationModifyDTO {

    private List<AmendDeciderModifyDTO> amendList;

    private List<UpdateDeciderModifyDTO> updateList;

}
