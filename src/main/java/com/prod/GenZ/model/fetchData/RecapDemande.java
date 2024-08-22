package com.prod.GenZ.model.fetchData;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data @Builder @AllArgsConstructor @NoArgsConstructor
public class RecapDemande {
    private MultipartFile file;
}
