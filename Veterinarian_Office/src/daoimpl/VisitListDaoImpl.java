package daoimpl;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.VisitListDao;
import pojo.Visit;

public class VisitListDaoImpl implements VisitListDao {

	@Override
    public void saveVisit(Visit visitDetails) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(visitDetails);
        transaction.commit();
        session.close();
    }
	
	@Override
    public List<Visit> getAllVisits() {
        List<Visit> visitList = new ArrayList();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("From Visit");
        visitList = query.list();
        return visitList;
    }
	
	public List<Visit> getDateVisits(Date visitDate){
		List<Visit> visitList = new ArrayList();
        Session session = HibernateUtil.getSessionFactory().openSession();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");  
        String date = sdf.format(visitDate);
        String test = "From Visit where Date= " + date;
        //String hql="Select * from visit where log.username=:username and log.password=:password";
        Query query = session.createQuery("From Visit where Date= \'" + date +"\'");
        //query.setParameter("date", date);
        visitList = query.list();
        return visitList;
	}
 
    @Override
    public void updateVisit(int VisitID, int PetID, String Date, int Weight, String SymptomDescription, String Diagnosis, String Treatment) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Visit visitDetails = (Visit)session.load(Visit.class, VisitID);
        visitDetails.setVisitId(VisitID);
        visitDetails.setPetId(PetID);
        visitDetails.setDate(Date);
        visitDetails.setWeight(Weight); 
        visitDetails.setSymptomDescription(SymptomDescription);
        visitDetails.setDiagnosis(Diagnosis);
        visitDetails.setTreatment(Treatment);
        session.update(visitDetails);
        transaction.commit();
        session.close();  
    }
 
    @Override
    public void deleteVisit(Visit visitDetails) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(visitDetails);
        transaction.commit();
        session.close();
    }
	
}
