package com.task2.carriergot2.dto;

import com.task2.carriergot2.entities.AmendDecider;
import com.task2.carriergot2.entities.UpdateDecider;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeciderConfigurationAddElementRequest {

    private AmendDecider amendDecider;

    private UpdateDecider updateDecider;
}
