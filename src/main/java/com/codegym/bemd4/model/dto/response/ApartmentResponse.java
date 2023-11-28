package com.codegym.bemd4.model.dto.response;

import com.codegym.bemd4.model.dto.entity.ApartmentDTO;
import lombok.Data;

import java.util.List;

@Data
public class ApartmentResponse {
    private List<ApartmentDTO> content;
    private int pageNo;
    private int pageSize;
    private long totalElements;
    private int totalPages;
    private boolean last;
}