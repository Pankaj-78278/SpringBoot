package com.ECom.model.admin;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer catId;
    private String categoryName;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "category")
    private List<Product> productList;
}
