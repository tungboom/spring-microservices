package com.viettel.services.sso.auth.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @author TungBoom
 *
 */
@Getter
@Setter
@NoArgsConstructor
public class Datatable {
    private int total;
    private int pages;
    private List<?> data;
}
