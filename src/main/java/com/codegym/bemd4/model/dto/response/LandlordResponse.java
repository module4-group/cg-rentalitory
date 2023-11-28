package com.codegym.bemd4.model.dto.response;

import com.codegym.bemd4.model.dto.entity.LandlordDTO;
import lombok.Data;

import java.util.List;

@Data
public class LandlordResponse {
    private List<LandlordDTO> content;
    private int pageNo;
    private int pageSize;
    private long totalElements;
    private int totalPages;
    private boolean last;
}
