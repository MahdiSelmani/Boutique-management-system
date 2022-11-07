package tn.elife.spring.entities;

import java.io.Serializable;
import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
@FieldDefaults(level = AccessLevel.PRIVATE
)
public class Fournisseur implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idFournisseur;
	private String codeFournisseur;
	private String libelleFournisseur;
	@Temporal(TemporalType.DATE)
	private Date dateDebut;
	@Enumerated(EnumType.STRING)
	private CategorieFournisseur categorieFournisseur;
	@OneToOne
	private DetailFournisseur detailFournisseur;
	@OneToMany(mappedBy = "fournisseur")
	private List<Facture> listFactures;
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<SecteurActivite> secteursActivite;

}
