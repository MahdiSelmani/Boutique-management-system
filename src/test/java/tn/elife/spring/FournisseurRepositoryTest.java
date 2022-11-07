package tn.elife.spring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.elife.spring.entities.CategorieProduit;
import tn.elife.spring.entities.DetailFacture;
import tn.elife.spring.entities.DetailFournisseur;
import tn.elife.spring.entities.Facture;
import tn.elife.spring.entities.Fournisseur;
import tn.elife.spring.entities.Operateur;
import tn.elife.spring.entities.Produit;
import tn.elife.spring.entities.Reglement;
import tn.elife.spring.entities.SecteurActivite;
import tn.elife.spring.entities.Stock;
import tn.elife.spring.services.CategorieProduitService;
import tn.elife.spring.services.DetailFactureService;
import tn.elife.spring.services.DetailFournisseurService;
import tn.elife.spring.services.FactureService;
import tn.elife.spring.services.FournisseurService;
import tn.elife.spring.services.OperateurService;
import tn.elife.spring.services.ProduitService;
import tn.elife.spring.services.ReglementService;
import tn.elife.spring.services.SecteurActiviteService;
import tn.elife.spring.services.StockService;

@SpringBootTest
class FournisseurRepositoryTest {
	@Autowired
	FournisseurService fournisseurService;
	@Autowired
	DetailFournisseurService detailFournisseurService;
	@Autowired
	CategorieProduitService categorieProduitService;
	@Autowired
	DetailFactureService detailFactureService;
	@Autowired
	FactureService factureService;
	@Autowired
	OperateurService operateurService;
	@Autowired
	ProduitService produitService;
	@Autowired
	ReglementService reglementService;
	@Autowired
	SecteurActiviteService secteurActiviteService;
	@Autowired
	StockService stockService;
	
	

	@Test
	void test() {

		Fournisseur f = new Fournisseur();
		fournisseurService.addItem(f);
		
		DetailFournisseur d = new DetailFournisseur();
		detailFournisseurService.addItem(d);
		
		CategorieProduit categorieProduit = new CategorieProduit();
		categorieProduitService.addItem(categorieProduit);
		
		DetailFacture detailFacture = new DetailFacture();
		detailFactureService.addItem(detailFacture);
		
		Facture facture = new Facture();
		factureService.addItem(facture);
		
		Operateur operateur = new Operateur();
		operateurService.addItem(operateur);
		
		Produit produit = new Produit();
		produitService.addItem(produit);
		
		
		Reglement reglement = new Reglement();
		reglementService.addItem(reglement);
		
		SecteurActivite secteurActivite = new SecteurActivite();
		secteurActiviteService.addItem(secteurActivite);
		
		Stock stock = new Stock();
		stockService.addItem(stock);
		
		
		
	}

}
