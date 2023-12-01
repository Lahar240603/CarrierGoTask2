package com.task2.carriergot2.dto;

import com.task2.carriergot2.entities.AmendDecider;
import com.task2.carriergot2.entities.UpdateDecider;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class DeciderConfigurationCreateDTO {
    private List<AmendDeciderCreateDTO> amendList;

    private List<UpdateDeciderCreateDTO> updateList;

    public DeciderConfigurationDTO buildEntity() {
        List<AmendDecider> amendEntityList = new ArrayList<>();
        List<UpdateDecider> updateEntityList = new ArrayList<>();
        for(AmendDeciderCreateDTO amendDTO : amendList) {
            amendEntityList.add(amendDTO.buildEntity());
        }
        for(UpdateDeciderCreateDTO updateDTO: updateList) {
            updateEntityList.add(updateDTO.buildEntity());
        }

        return new DeciderConfigurationDTO(amendEntityList, updateEntityList);
    }
}
