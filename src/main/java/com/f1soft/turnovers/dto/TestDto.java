package com.f1soft.turnovers.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TestDto {
    private String factoyCode;

    public TestDto () {

    }
    public TestDto (String factoyCode) {
        this.factoyCode = factoyCode;
    }
}
