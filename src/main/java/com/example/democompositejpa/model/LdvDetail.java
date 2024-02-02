package com.example.democompositejpa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@IdClass(LdvDetailId.class)
public class LdvDetail {

    @Id
    private String ldvNo;
    @Id
    private String contractNo;

    private String custName;
}
