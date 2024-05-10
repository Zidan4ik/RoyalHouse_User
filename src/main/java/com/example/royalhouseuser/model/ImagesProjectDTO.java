package com.example.royalhouseuser.model;

import com.example.royalhouseuser.enums.ImageType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImagesProjectDTO {
    private Long id;
    private ImageType type;
    private String image1;
    private String image2;
    private String image3;

    public String linkImages(int index) {
        if (type.equals(ImageType.aboutProject)) {
            if (index == 1) {
                return "/uploads/project/images/about/" + id + "/" + image1;
            } else if (index == 2) {
                return "/uploads/project/images/about/" + id + "/" + image2;
            } else if (index == 3) {
                return "/uploads/project/images/about/" + id + "/" + image3;
            } else {
                return null;
            }
        } else {

            if (index == 1) {
                return "/uploads/project/images/" + type + "/" + id + "/" + image1;
            } else if (index == 2) {
                return "/uploads/project/images/" + type + "/" + id + "/" + image2;
            } else if (index == 3) {
                return "/uploads/project/images/" + type + "/" + id + "/" + image3;
            } else {
                return null;
            }
        }
    }
}
