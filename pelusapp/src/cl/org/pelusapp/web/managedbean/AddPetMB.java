package cl.org.pelusapp.web.managedbean;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.FlowEvent;

import cl.org.pelusapp.domain.AgeGroup;
import cl.org.pelusapp.domain.Case;
import cl.org.pelusapp.domain.Pet;
import cl.org.pelusapp.domain.Race;
import cl.org.pelusapp.domain.Size;
import cl.org.pelusapp.domain.Species;
import cl.org.pelusapp.persistencia.dao.AgeGroupDAO;
import cl.org.pelusapp.persistencia.dao.CaseDAO;
import cl.org.pelusapp.persistencia.dao.PetDAO;
import cl.org.pelusapp.persistencia.dao.RaceDAO;
import cl.org.pelusapp.persistencia.dao.SizeDAO;
import cl.org.pelusapp.persistencia.dao.SpeciesDAO;

@ManagedBean(name = "addPetMB")
@ViewScoped
public class AddPetMB {

    private static String DESTINATION="D:\\pelusapp\\img\\";

	// seLECIONADOS
    private Pet pet;
    private Species species;

	// VISTA
    private List<AgeGroup> lstAgeGroup;
    private List<Size> lstSize;
    private List<Species> lstSpecies;
    private List<Race> lstRace;

	public Species getSpecies() {
		return species;
	}

	public void setSpecies(Species species) {
		this.species = species;
	}

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

	public List<Race> getLstRace() {
		return lstRace;
	}

	public void setLstRace(List<Race> lstRace) {
		this.lstRace = lstRace;
	}

	public List<Species> getLstSpecies() {
		return lstSpecies;
	}

	public void setLstSpecies(List<Species> lstSpecies) {
		this.lstSpecies = lstSpecies;
	}

	public List<Species> getLstspecies() {
		return lstSpecies;
	}

	public void setLstspecies(List<Species> lstSpecies) {
		this.lstSpecies = lstSpecies;
	}

	public List<Size> getLstSize() {
		return lstSize;
	}

	public void setLstSize(List<Size> lstSize) {
		this.lstSize = lstSize;
	}

	public List<AgeGroup> getLstAgeGroup() {
		return lstAgeGroup;
	}

	public void setLstAgeGroup(List<AgeGroup> lstAgeGroup) {
		this.lstAgeGroup = lstAgeGroup;
	}

	public void init() {
		System.out.println("---------------------->INIT<-------------------------");
		clear();
		AgeGroupDAO ageGroupDAO = new AgeGroupDAO();
		SizeDAO sizeDAO = new SizeDAO();
		SpeciesDAO speciesDAO = new SpeciesDAO();

		this.lstSize = sizeDAO.selectAll();
		this.lstAgeGroup = ageGroupDAO.selectAll();
		this.lstSpecies = speciesDAO.selectAll();
	}

	private void clear() {
		this.lstAgeGroup = new ArrayList<AgeGroup>();
		this.lstRace = new ArrayList<Race>();
		this.lstSize = new ArrayList<Size>();
		this.pet =  new Pet();
		this.species = new Species();
		
	}

	public void save() {
		System.out.println(this.pet + "--------------> SAVE Pet <------------------");
		PetDAO petDAO = new PetDAO();
		CaseDAO caseDAO =  new CaseDAO();
		petDAO.insert(pet);
		System.out.println(this.pet + "--------------> SAVE Case<------------------");
		Case cases = new Case();
		cases.setIdPet(pet.getId());
		cases.setStatusCase("0");
		caseDAO.insert(cases);
	
	}

	public void getRace() {

		System.out.println(this.species.getId() + " ---------------------->getRace<-------------------------");
		RaceDAO raceDAO = new RaceDAO();
		this.lstRace = raceDAO.selectById(Integer.valueOf(this.species.getId()));

	}
	
    public void upload(FileUploadEvent event) {  
    	System.out.println("--------------------> EVENT " + event.getClass());
        FacesMessage msg = new FacesMessage("Success! ", event.getFile().getFileName() + " is uploaded.");  
        FacesContext.getCurrentInstance().addMessage(null, msg);
        // Do what you want with the file        
        try {
            copyFile(event.getFile().getFileName(), event.getFile().getInputstream());
        } catch (IOException e) {
            e.printStackTrace();
        }
 
    }  
 
    public void copyFile(String fileName, InputStream in) {
           try {
              
              
                // write the inputStream to a FileOutputStream
                OutputStream out = new FileOutputStream(new File(DESTINATION + fileName));
              
                int read = 0;
                byte[] bytes = new byte[1024];
              
                while ((read = in.read(bytes)) != -1) {
                    out.write(bytes, 0, read);
                }
              
                in.close();
                out.flush();
                out.close();
              
                System.out.println("New file created!");
                } catch (IOException e) {
                System.out.println(e.getMessage());
                }
    }
    
    public String onFlowProcess(FlowEvent event) {
            return event.getNewStep();
    }


}
