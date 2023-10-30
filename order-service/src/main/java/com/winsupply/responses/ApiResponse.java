package com.winsupply.responses;

import lombok.Data;

@Data
public class ApiResponse {
    private boolean success;
    private String successMsg;
    public ApiResponse(boolean success, String successMsg) {
        super();
        this.success = success;
        this.successMsg = successMsg;
    }
    
    
}
