package com.example.royalhouseuser.model;

import com.example.royalhouseuser.enums.InfographicsType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InfographicProjectDTO {
    private Long id;
    private InfographicsType type;
    private String file;
    private String description;

    public String linkFile(){
        return "/uploads/project/infographics/"+type+"/"+id+"/"+file;
    }
}
