package tn.elife.spring.services;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import tn.elife.spring.entities.DetailFacture;
import tn.elife.spring.entities.Facture;
import tn.elife.spring.entities.Fournisseur;
import tn.elife.spring.entities.Produit;
import tn.elife.spring.entities.Reglement;
import tn.elife.spring.repository.DetailFactureRepository;
import tn.elife.spring.repository.FactureRepository;
import tn.elife.spring.repository.FournisseurRepository;
import tn.elife.spring.repository.ProduitRepository;

@Service
@Slf4j
public class FactureService implements IService<Facture> {
	@Autowired
	FactureRepository fr;
	@Autowired
	FournisseurRepository fournisseurRepository;

	@Autowired
	FournisseurService fournisseurService;
	@Autowired
	ProduitRepository produitRepository;
	@Autowired
	DetailFactureRepository detailFactureRepository;

	@Override
	public List<Facture> retrieveAll() {
		return (List<Facture>) fr.findAll();
	}

	@Override
	public Facture addItem(Facture t) {
		return fr.save(t);
	}

	@Override
	public void deleteItem(long id) {
		fr.deleteById(id);

	}

	@Override
	public Facture updateItem(Facture t) {
		return fr.save(t);

	}

	@Override
	public Facture retrieveItem(long id) {
		return fr.findById(id).get();

	}

	public List<Facture> getFactureByFournisseur(Long idFournisseur) {
		Fournisseur f = fournisseurService.retrieveItem(idFournisseur);
		return f.getListFactures();

	}

	public List<Reglement> getREglementByFacture(Long idFacture) {
		return retrieveItem(idFacture).getReglements();
	}

	public Facture addFacture(Long idFacture, Long idFournisseur) {
		Fournisseur f = fournisseurService.retrieveItem(idFournisseur);
		Facture facture = fr.findById(idFournisseur).get();
		facture.setFournisseur(f);
		return addItem(facture);

	}

	@Transactional
	public Facture addFacture(Facture f, Long idFournisseur) {

		Fournisseur fournisseur = fournisseurRepository.findById(idFournisseur).orElse(null);
		log.info("fournisseur: " + fournisseur.getLibelleFournisseur());
		f.setFournisseur(fournisseur);
		f.setDate_creation_facture(new Date());
		f.setArchive(false);
		Set<DetailFacture> detailsFacture =  (Set<DetailFacture>) f.getDetailFacture();
		/*
		 * récupérer les détails de la facture et calculer le montant de la facture
		 * ainsi que les remises
		 */
		Facture fact = addDetailsFacture(f, detailsFacture);
		return fr.save(fact);
	}

	/*
	 * calculer les montants remise et le montant total d'un détail facture ainsi
	 * que les montants d'une facture
	 */
	private Facture addDetailsFacture(Facture f, Set<DetailFacture> detailsFacture) {
		float montantFacture = 0;
		float montantRemise = 0;
		for (DetailFacture detail : detailsFacture) {
			Produit produit = produitRepository.findById(detail.getProduit().getIdProduit()).orElse(null);
			float prixTotalDetail = detail.getQteCommande() * produit.getPrix();
			float montantRemiseDetail = (prixTotalDetail * detail.getPourcentageRemise()) / 100;
			float prixTotalDetailRemise = prixTotalDetail - montantRemiseDetail;
			detail.setMontantRemise(montantRemiseDetail);
			detail.setPrixTotalDetail(prixTotalDetailRemise);
			montantFacture = montantFacture + prixTotalDetailRemise;
			montantRemise = montantRemise + montantRemiseDetail;
			detail.setProduit(produit);
			detail.setFacture(f);
			detailFactureRepository.save(detail);
		}
		f.setMontant_facture(montantFacture);
		f.setMontant_remise(montantRemise);
		return f;
	}

}
