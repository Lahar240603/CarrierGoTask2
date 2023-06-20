package com.task2.carriergot2.service;

import com.task2.carriergot2.model.AmendWorkOrderStateDecider;
import com.task2.carriergot2.model.UpdateWorkOrderStateDecider;
import com.task2.carriergot2.utils.WorkOrderStateDeciderRequest;

public interface iWorkOrderStateDeciderModifyService {

//<<<<<<< Updated upstream
    public WorkOrderStateDeciderRequest updateRequest(WorkOrderStateDeciderRequest request, String orgCode, String username);
//=======
//    public WorkOrderStateDeciderRequest updateRequest(WorkOrderStateDeciderRequest request, String orgCode);

    public WorkOrderStateDeciderRequest addRequest(AmendWorkOrderStateDecider newAmend, UpdateWorkOrderStateDecider newUpdate, String username, String token);
//>>>>>>> Stashed changes
}
