package com.ECom.model.user;

import com.ECom.model.admin.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

@Data
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer orderId;
    private LocalDateTime date;
    private String orderStatus;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    private User user;

    @Embedded
    @ElementCollection
    private List<Product> productList;
}
