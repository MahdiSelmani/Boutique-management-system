package tn.elife.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
public class Facture implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idFacture;
	private float montant_remise;
	private float montant_facture;
	@Temporal(TemporalType.DATE)
	private Date date_creation_facture;
	@Temporal(TemporalType.DATE)
	private Date date_dernier_modification;
	private boolean archive;
	@ManyToOne(cascade = CascadeType.ALL)
	private Fournisseur fournisseur;
	//@ManyToOne( cascade = CascadeType.ALL)
	//private Operateur operateur;
	@OneToMany(mappedBy = "facture")
	private List<DetailFacture> detailFacture;
	@OneToMany(mappedBy = "facture")
	private List<Reglement> reglements;

	

}
