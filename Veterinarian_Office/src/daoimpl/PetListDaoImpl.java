package daoimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.PetListDao;
import pojo.Pet;

import org.hibernate.Query;
 
/**
 *
 * @author zqwoo
 */
public class PetListDaoImpl implements PetListDao {
	 
    @Override
    public void savePet(Pet petDetails) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(petDetails);
        transaction.commit();
        session.close();
    }
 
    @Override
    public List<Pet> getAllPets() {
        List<Pet> ownerList = new ArrayList();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("From Pet");
        ownerList = query.list();
        return ownerList;
    }
 
    @Override
    public void updatePet(int PetID, String Name, String PetType, String Breed, String Gender, String Size, int OwnerID) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Pet petDetails = (Pet)session.load(Pet.class, PetID);
        petDetails.setPetId(PetID);
        petDetails.setName(Name);
        petDetails.setPetType(PetType);
        petDetails.setBreed(Breed); 
        petDetails.setGender(Gender);
        petDetails.setSize(Size);
        petDetails.setOwnerId(OwnerID);
        session.update(petDetails);
        transaction.commit();
        session.close();  
    }
 
    @Override
    public void deletePet(Pet petDetails) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(petDetails);
        transaction.commit();
        session.close();
    }
    
}