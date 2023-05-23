package com.task2.carriergot2.utils;

import com.task2.carriergot2.model.AmendWorkOrderStateDecider;
import com.task2.carriergot2.model.UpdateWorkOrderStateDecider;

import java.util.List;

public class WorkOrderStateDeciderRequest {
    private List<AmendWorkOrderStateDecider> amendList;

    private List<UpdateWorkOrderStateDecider> updateList;

    public WorkOrderStateDeciderRequest(List<AmendWorkOrderStateDecider> amendList, List<UpdateWorkOrderStateDecider> updateList) {
        this.updateList = updateList;
        this.amendList = amendList;
    }

    public List<AmendWorkOrderStateDecider> getAmendList() {
        return amendList;
    }

    public void setAmendList(List<AmendWorkOrderStateDecider> amendList) {
        this.amendList = amendList;
    }

    public List<UpdateWorkOrderStateDecider> getUpdateList() {
        return updateList;
    }

    public void setUpdateList(List<UpdateWorkOrderStateDecider> updateList) {
        this.updateList = updateList;
    }
}
