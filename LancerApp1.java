package package1;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import videoShowSolution.MvtCirculaire;
import videoShowSolution.Visage;
public class LancerApp1 {

	public static void main(String[] args) throws IOException {
		
		BufferedImage imgVador= ImageIO.read(new File("images/person2.png"));
		BufferedImage imgLeila= ImageIO.read(new File("images/person1.png"));
		
		// cr�ation de la fen�tre de l'application
		JFrame laFenetre= new JFrame("Animation Train, etc.");
		laFenetre.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		laFenetre.setSize(512, 512);
		
		// cr�ation de la z�ne de dessin dans la fen�tre
		Dessin d = new Dessin();
		laFenetre.getContentPane().add(d);
		
		// affiche la fen�tre
		laFenetre.setVisible(true);
		
		// les trains de cercles avec image et en couleur
		TrainCercle[] lesTrains= new TrainCercle[10];
		lesTrains[0] = new TrainCercleImage(d, 10, imgVador); d.ajouterObjet(lesTrains[0]);
		lesTrains[1] = new TrainCercleImage(d, 10, imgLeila); d.ajouterObjet(lesTrains[1]);
		for (int i = 2; i < 10; i++) {
			lesTrains[i] = new TrainCercleCouleur(new Color((float) Math.random(), (float) Math.random(),
		(float) Math.random()), d, 10, 10);
		d.ajouterObjet(lesTrains[i]);
		}
	
		Visage visage=new Visage(d);
		d.ajouterObjet(visage);	
		/////////12-une étoile de couleur verte
		Form etoile=new Etoile(200,50,50,8.f,color.GREEN,color.RED);
		/////////12-un polygone de couleur Noire
		Form polygone=new PolygoneRegulier(5,240,40,40,4.f,color.BLACK,null);
		d.ajouterObjet(etoile);
		d.ajouterObjet(polygone);
/*/////////////////////// 17--visage animés par un mouvement aléatoire
		Visage v=new Visage(d,50,100);
		v.deplacer();
		d.ajouterObjet(v);
/////////////////////// 17--TrainCercle animés par un mouvement aléatoire
		TrainCercle[] trais= new TrainCercle[15];
		for (int i = 0; i < 15; i++) {
			trains[i].deplacer() ;
		d.ajouterObjet(trains[i]);
		}
///////////////17-une étoile de couleur verte fixe
Form e=new Etoile(150,40,40,8.f,color.GREEN,color.RED);
d.ajouterObjet(e);
///////////////////un polygone de couleur noire fixe
Form p=new PolygoneRegulier(7,200,50,30,4.f,color.BLACK,null);
d.ajouterObjet(p);
//////////////17-une étoile de couleur jaune animés par un mouvement circulaire.
Form et =new Etoile(100,60,60,8.f,color.YELLOW,color.YELLOW);
MvtCirculaire em=new MvtCirculaire();
em.deplacer(et);
d.ajouterObjet(et);
///////////////17-un polygone de couleur grise animés par un mouvement circulaire.
Form po=new PolygoneRegulier(5,240,40,40,4.f,color.GRAY,null);
MvtCirculaire ep=new MvtCirculaire();
ep.deplacer(po);
d.ajouterObjet(po);*/









		
		
		while(true) {
		// la zone de dessin se r�affiche
		d.repaint();
		// un temps de pause pour avoir le temps de voir le nouveau dessin
		d.pause(50);
		//r�aliser � tous les trains un d�placement �l�mentaire
		d.animer();
		
		}

	}

}
