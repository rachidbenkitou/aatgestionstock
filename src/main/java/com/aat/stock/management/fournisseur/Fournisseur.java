package com.aat.stock.management.fournisseur;

import com.aat.stock.management.intervenant.Intervenant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("fournisseur")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Fournisseur extends Intervenant {



}
