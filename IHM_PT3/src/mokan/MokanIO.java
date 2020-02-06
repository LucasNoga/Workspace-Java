package mokan;

import java.io.BufferedWriter;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

/**Gestion des flux d'entrees sorties*/
public class MokanIO{
	public MokanPrincipale principale;
	
	public FileWriter fw = null;
	BufferedWriter bw;
	PrintWriter pw;
	
	public File fileModule = new File("./data/module");
	
	public String debut, fin = "";
	public String mod = "";

	public MokanIO(){}

	public void sauvegarde(){ 
		int option = JOptionPane.showConfirmDialog(null, "Voulez-vous sauvegarder ?", "Confirmation de la sauvegarde", 
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if(option == JOptionPane.OK_OPTION){ 
			//Dossier data
			File dirdata = new File("./data");

			if(!dirdata.exists())
				dirdata.mkdir();

			//Creation du dossier semestre
			String annee = Integer.toString(principale.dateDebut[2]).substring(2);
			String rep = "";
			
			if(principale.semestre.equals("S1") || principale.semestre.equals("S3"))
				rep = "S1";
			else
				rep = "S2";

			rep = rep+annee;
			File dirSemestreInfo = new File("./data/"+rep);

			File dirSemestre = new File(dirSemestreInfo, ""+principale.semestre);

			//Creation des repertoires
			File dirAffect = new File(dirSemestre, "affect");
			File dirModule = new File(dirSemestre,"module");
			File dirSchedule = new File(dirSemestre,"schedule");
			File dirOldSchedule = new File(dirSemestre,"oldschedule");

			String str = principale.nomModule;
			//Nom du module dans le dossier Affect
			File moduleAffect = new File(dirAffect, str);

			//Nom du module dans le dossier Module
			File moduleModule = new File(dirModule,  str);

			//Nom du module dans le dossier Schedule
			File moduleSchedule = new File(dirSchedule,  str);

			//UNIQUEMENT SI Le fichier existe dans le dirSchedule
			File moduleOldSchedule = new File(dirOldSchedule,  str);

			//Creation des dossier
			if(!dirSemestreInfo.exists())
				dirSemestreInfo.mkdir();
			
			if(!dirSemestre.exists())
				dirSemestre.mkdir();

			if(!dirAffect.exists())
				dirAffect.mkdir();

			if(!dirModule.exists())
				dirModule.mkdir();

			if(!dirSchedule.exists())
				dirSchedule.mkdir();

			if(!dirOldSchedule.exists())
				dirOldSchedule.mkdir();
			
			//le fichier affect
			if(moduleAffect.exists()){
				moduleAffect.delete();
			}
			else{
				try{
					moduleAffect.createNewFile();
				}catch (IOException e){
					e.printStackTrace();
				}
				try{
					fw = new FileWriter(moduleAffect);
				} catch (IOException e){
					e.printStackTrace();
				}

				bw = new BufferedWriter(fw);
				pw = new PrintWriter(bw);
				
				//Ajout du prof de cm
				System.out.println(principale.professeurCM);
				pw.println("AffectCM " + principale.professeurCM);
				
				//ajout du TD
				pw.println("AffectTD 2 " + principale.professeurTD);
				
				//ajout du TP
				pw.println("AffectTP 4 " + principale.professeurTP4);
				pw.close();
			}
			//Fichier Module
			if(moduleModule.exists()){
				moduleModule.delete();
			}
			else{
				try{
					moduleModule.createNewFile();
				}catch (IOException e){
					e.printStackTrace();
				}
				try{
					fw = new FileWriter(moduleModule);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				bw = new BufferedWriter(fw);
				pw = new PrintWriter(bw);
				
				//Recupere la semaine de debut et de fin de module
				pw.println("StartsOn " + debut);
				pw.println("EndsOn " + fin);
				for(int i = 0; i < principale.coursModule.size(); i++)
					pw.println(principale.coursModule.get(i));
				pw.close();
			}

			//Fichier Schedule
			//Si il existe on le deplace dans old schedule
			if(moduleSchedule.exists()){
				
				//si oldSchedule existe on le supprime et on ecrase
				if(moduleOldSchedule.exists()){
					moduleOldSchedule.delete();
					moduleSchedule.renameTo(moduleOldSchedule);
				}
				//sinon en ecrase direct
				else
					moduleSchedule.renameTo(moduleOldSchedule);	
				try{
					moduleSchedule.createNewFile();
				}catch (IOException e){
					e.printStackTrace();
				}
				
				//Creation des donnees
				try {
					fw = new FileWriter(moduleSchedule);
				} catch (IOException e) {
					e.printStackTrace();
				}
				bw = new BufferedWriter(fw);
				pw = new PrintWriter(bw);

				for(int i = 0; i < principale.numerosSemaine.size(); i++)
					pw.println(principale.numerosSemaine.get(i));

				pw.close();
			}
			else{
				try{
					moduleSchedule.createNewFile();
				}catch (IOException e){
					e.printStackTrace();
				}
				
				//Creation des donnees
				try {
					fw = new FileWriter(moduleSchedule);
				} catch (IOException e) {
					e.printStackTrace();
				}
				bw = new BufferedWriter(fw);
				pw = new PrintWriter(bw);

				for(int i = 0; i < principale.numerosSemaine.size(); i++)
					pw.println(principale.numerosSemaine.get(i));

				pw.close();
			}
		}
		principale.memoire.setText("Module sauvegardé");
	}
}