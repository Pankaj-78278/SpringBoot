package com.ECom.model.admin;

import com.ECom.model.user.Cart;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer productID;
    @Size(min = 1, message = "Product name cannot be null")
    private String productName;
    private Integer productPrice;
    private String specification;

    @ManyToOne(cascade = CascadeType.ALL)
    private Category category;

}
