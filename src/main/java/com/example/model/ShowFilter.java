package com.example.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ShowFilter {
    String movieName;
    String theatreName;
}
