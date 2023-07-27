package com.ECom.model.user;

import com.ECom.model.admin.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer cartId;
    private Integer product_quantity;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Product> products;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;
}
