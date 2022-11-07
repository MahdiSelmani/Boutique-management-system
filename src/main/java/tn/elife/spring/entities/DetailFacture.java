package tn.elife.spring.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@FieldDefaults (level = AccessLevel.PRIVATE)

public class DetailFacture implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idDetailFacture;
	private int qteCommande;
	private float prixTotalDetail;
	private int pourcentageRemise;
	private float montantRemise;
	@ManyToOne
	private Facture facture;
	@ManyToOne
	private Produit produit;

}
