package com.prod.GenZ.model.fetchData;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class FileBase64 {
    private String base64File;
    private String name;
}
