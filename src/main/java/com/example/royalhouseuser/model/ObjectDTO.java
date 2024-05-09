package com.example.royalhouseuser.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ObjectDTO {
    private Long id;
    private String name;
    private String address;
    private String rooms;
    private String storey;
    private String area;
    private String priceSquareMeter;
    private String totalPrice;

    private String image1;
    private String image2;
    private String image3;


}
