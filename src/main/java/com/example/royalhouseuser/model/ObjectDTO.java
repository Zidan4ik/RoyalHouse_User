package com.example.royalhouseuser.model;

import com.example.royalhouseuser.enums.Building;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.nio.file.Path;
import java.nio.file.Paths;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ObjectDTO {
    private Long id;
    private String name;
    private String type;
    private String address;
    private String rooms;
    private String storey;
    private String area;
    private String priceSquareMeter;
    private String totalPrice;

    private String image1;
    private String image2;
    private String image3;

    public String linkToImage1() {
        return "/uploads/objects/" + id + "/" + image1;
    }

    public String linkToImage2() {
        return "/uploads/objects/" + id + "/" + image2;
    }

    public String linkToImage3() {
        return "/uploads/objects/" + id + "/" + image3;
    }

}
