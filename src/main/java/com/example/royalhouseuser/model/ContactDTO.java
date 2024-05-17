package com.example.royalhouseuser.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactDTO {
    private Long id;
    private String phone;
    private String viber;
    private String telegram;
    private String email;
    private String instagram;
    private String facebook;
    private String address;
    private String length;
    private String width;
}
