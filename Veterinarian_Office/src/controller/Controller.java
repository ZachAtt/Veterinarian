package controller;

import java.io.IOException;
import java.text.*;
import java.time.LocalDateTime;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import daoimpl.*;
import pojo.*;
 
public class Controller extends HttpServlet {
 
        Owner ownerDetails = new Owner();
        OwnerListDaoImpl ownerDaoImpl = new OwnerListDaoImpl();
        Map<Integer, Owner> ownerMap = new HashMap<Integer, Owner>();
        int ownerId;
        Pet petDetails = new Pet();
        PetListDaoImpl petDaoImpl = new PetListDaoImpl();
        Map<Integer, Pet> petMap = new HashMap<Integer, Pet>();
        int petId;
        Visit visitDetails = new Visit();
        VisitListDaoImpl visitDaoImpl = new VisitListDaoImpl();
        Map<Integer, Visit> visitMap = new HashMap<Integer, Visit>();
        int visitId;
       

    protected void showAllOwners(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	List<Owner> ownerList = new ArrayList();
    	ownerMap.clear();
    	ownerList = ownerDaoImpl.getAllOwners();
    	for(int i = 0; i < ownerList.size(); i++) {
    		Owner owner = ownerList.get(i);
    		ownerMap.put(owner.getOwnerId(), owner);
    	}
        request.setAttribute("ownerMap", ownerMap);
        RequestDispatcher rd = request.getRequestDispatcher("OwnerList.jsp");
        rd.forward(request, response);
    }
    
    protected void showAllPets(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	List<Pet> petList = new ArrayList();
    	petMap.clear();
    	petList = petDaoImpl.getAllPets();
    	for(int i = 0; i < petList.size(); i++) {
    		Pet pet = petList.get(i);
    		petMap.put(pet.getPetId(), pet);
    	}
        request.setAttribute("petMap", petMap);
        RequestDispatcher rd = request.getRequestDispatcher("PetList.jsp");
        rd.forward(request, response);
    }
    
    protected void showAllVisits(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	List<Visit> visitList = new ArrayList();
    	visitMap.clear();
     	visitList = visitDaoImpl.getAllVisits();
     	for(int i = 0; i < visitList.size(); i++) {
     		Visit visit = visitList.get(i);
     		visitMap.put(visit.getVisitId(), visit);
     	}
     	request.setAttribute("visitMap", visitMap);
        RequestDispatcher rd = request.getRequestDispatcher("VisitList.jsp");
        rd.forward(request, response);
    }
    
    protected void showDateVisits(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	List<Visit> visitList = new ArrayList();
    	visitMap.clear();
    	Boolean isGood =true;
    	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy"); 
    	String dateText = request.getParameter("Date");
    	Date date = new Date();
     	try {
			date = sdf.parse(dateText);
		} catch (ParseException e) {
			isGood = false;
		}
     	
     	if(isGood) {
     		visitList = visitDaoImpl.getDateVisits(date);
     	}
     	else {
     		visitList = visitDaoImpl.getAllVisits();
     	}
     	
     	for(int i = 0; i < visitList.size(); i++) {
     		Visit visit = visitList.get(i);
     		visitMap.put(visit.getVisitId(), visit);
     	}
     	request.setAttribute("visitMap", visitMap);
        RequestDispatcher rd = request.getRequestDispatcher("VisitList.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getParameter("addOwner")!=null){
        	int ownerId = Integer.parseInt(request.getParameter("OwnerID"));
        	String firstName = request.getParameter("FirstName");
        	String lastName = request.getParameter("LastName");
        	String phoneNumber = request.getParameter("PhoneNumber");
        	String homeAddress = request.getParameter("HomeAddress");
        	String emailAddress = request.getParameter("EmailAddress");
            ownerDetails.setOwnerId(ownerId);
            ownerDetails.setFirstName(firstName);
            ownerDetails.setLastName(lastName);
            ownerDetails.setPhoneNumber(phoneNumber); 
            ownerDetails.setHomeAddress(homeAddress);
            ownerDetails.setEmailAddress(emailAddress);
            ownerDaoImpl.saveOwner(ownerDetails);
            showAllOwners(request, response);
        }
        
        if(request.getParameter("addPet")!=null){
        	int petId = Integer.parseInt(request.getParameter("PetID"));
        	String Name = request.getParameter("Name");
        	String PetType = request.getParameter("PetType");
        	String Breed = request.getParameter("Breed");
        	String Gender = request.getParameter("Gender");
        	String Size = request.getParameter("Size");
        	int ownerId = Integer.parseInt(request.getParameter("OwnerID"));
        	petDetails.setPetId(petId);
            petDetails.setName(Name);
            petDetails.setPetType(PetType);
            petDetails.setBreed(Breed); 
            petDetails.setGender(Gender);
            petDetails.setSize(Size);
            petDetails.setOwnerId(ownerId);
            petDaoImpl.savePet(petDetails);
            showAllPets(request, response);
        }
        
        if(request.getParameter("addVisit")!=null){
        	int visitId = Integer.parseInt(request.getParameter("VisitID"));
        	int petId = Integer.parseInt(request.getParameter("PetID"));
        	String Date = request.getParameter("Date");
        	int Weight = Integer.parseInt(request.getParameter("Weight"));
        	String SymptomDescription = request.getParameter("SymptomDescription");
        	String Diagnosis = request.getParameter("Diagnosis");
        	String Treatment = request.getParameter("Treatment");
        	visitDetails.setVisitId(visitId);
            visitDetails.setPetId(petId);
            visitDetails.setDate(Date);
            visitDetails.setWeight(Weight);
            visitDetails.setSymptomDescription(SymptomDescription); 
            visitDetails.setDiagnosis(Diagnosis);
            visitDetails.setTreatment(Treatment);
            visitDaoImpl.saveVisit(visitDetails);
            showAllVisits(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	if(request.getParameter("mainMenu")!=null){
            RequestDispatcher rd = request.getRequestDispatcher("MainMenu.jsp");
            rd.forward(request, response);
        }
    	
    	if(request.getParameter("showAllOwners")!=null){
            showAllOwners(request, response);
        }
    	
    	if(request.getParameter("doUpdateOwner")!=null){
    		ownerId = Integer.parseInt(request.getParameter("OwnerID"));
    		request.setAttribute("owner", ownerMap.get(ownerId));
            RequestDispatcher rd = request.getRequestDispatcher("OwnerUpdate.jsp");
            rd.forward(request, response);
        }
         
        if(request.getParameter("updateOwner")!=null){
         	String firstName = request.getParameter("FirstName");
         	String lastName = request.getParameter("LastName");
         	String phoneNumber = request.getParameter("PhoneNumber");
         	String homeAddress = request.getParameter("HomeAddress");
         	String emailAddress = request.getParameter("EmailAddress");             
            ownerDaoImpl.updateOwner(ownerId, firstName, lastName, phoneNumber, homeAddress, emailAddress);
            showAllOwners(request, response);
        }
          
         if(request.getParameter("deleteOwner")!=null){
             ownerId = Integer.parseInt(request.getParameter("OwnerID"));
             ownerDetails.setOwnerId(ownerId);
             ownerDaoImpl.deleteOwner(ownerDetails);
             showAllOwners(request, response);
         }
         
         if(request.getParameter("addOwner")!=null){
            RequestDispatcher rd = request.getRequestDispatcher("OwnerAdd.jsp");
            rd.forward(request, response);
         }
         
         if(request.getParameter("showAllPets")!=null){
             showAllPets(request, response);
         }
         
         if(request.getParameter("doUpdatePet")!=null){
     		petId = Integer.parseInt(request.getParameter("PetID"));
     		request.setAttribute("pet", petMap.get(petId));
             RequestDispatcher rd = request.getRequestDispatcher("PetUpdate.jsp");
             rd.forward(request, response);
         }
          
         if(request.getParameter("updatePet")!=null){
           	String Name = request.getParameter("Name");
           	String PetType = request.getParameter("PetType");
           	String Breed = request.getParameter("Breed");
           	String Gender = request.getParameter("Gender");
           	String Size = request.getParameter("Size");
           	ownerId = Integer.parseInt(request.getParameter("OwnerID"));
            petDaoImpl.updatePet(petId, Name, PetType, Breed, Gender, Size, ownerId);
            showAllPets(request, response);
         }
           
          if(request.getParameter("deletePet")!=null){
              petId = Integer.parseInt(request.getParameter("PetID"));
              petDetails.setPetId(petId);
              petDaoImpl.deletePet(petDetails);
              RequestDispatcher rd = request.getRequestDispatcher("PetAdd.jsp");
             rd.forward(request, response);
          }
          
          if(request.getParameter("addPet")!=null){
              RequestDispatcher rd = request.getRequestDispatcher("PetAdd.jsp");
              rd.forward(request, response);
          }
          
          if(request.getParameter("showAllVisits")!=null){
              showAllVisits(request, response);
          }
          
          if(request.getParameter("dateFilter")!=null){
              showDateVisits(request, response);
          }
          
          if(request.getParameter("doUpdateVisit")!=null){
       		visitId = Integer.parseInt(request.getParameter("VisitID"));
       		request.setAttribute("visit", visitMap.get(visitId));
               RequestDispatcher rd = request.getRequestDispatcher("VisitUpdate.jsp");
               rd.forward(request, response);
           }
           
          if(request.getParameter("updateVisit")!=null){
          	int petId = Integer.parseInt(request.getParameter("PetID"));
          	String date = request.getParameter("Date");
          	int weight = Integer.parseInt(request.getParameter("Weight"));
          	String symptomDescription = request.getParameter("SymptomDescription");
          	String diagnosis = request.getParameter("Diagnosis");
          	String treatment = request.getParameter("Treatment");
            visitDaoImpl.updateVisit(visitId, petId, date, weight, symptomDescription, diagnosis, treatment);
            showAllVisits(request, response);
          }
          if(request.getParameter("deleteVisit")!=null){
             int id = Integer.parseInt(request.getParameter("VisitID"));
             visitDetails.setVisitId(id);
             visitDaoImpl.deleteVisit(visitDetails);
             RequestDispatcher rd = request.getRequestDispatcher("VisitAdd.jsp");
             rd.forward(request, response);
          }
          if(request.getParameter("addVisit")!=null){
              RequestDispatcher rd = request.getRequestDispatcher("VisitAdd.jsp");
              rd.forward(request, response);
          }
      
    }
 
 
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
 
}