package com.aat.stock.management.contact;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Type", length = 14)
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private short id;
    private String nom;
    private String telephone;
    private String email;

}
