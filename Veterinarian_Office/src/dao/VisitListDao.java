package dao;

import java.util.Date;
import java.util.List;

import pojo.Visit;

public interface VisitListDao {

	public void saveVisit(Visit visitDetails);
	public List<Visit> getAllVisits();
	public List<Visit> getDateVisits(Date visitDate);
	public void updateVisit(int VisitID, int PetID, String Date, int Weight, String SymptomDescription, String Diagnosis, String Treatment);
	public void deleteVisit(Visit visitDetails);
}
