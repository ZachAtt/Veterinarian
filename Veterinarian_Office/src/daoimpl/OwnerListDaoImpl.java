package daoimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.OwnerListDao;
import pojo.Owner;

import org.hibernate.Query;
 
/**
 *
 * @author zqwoo
 */
public class OwnerListDaoImpl implements OwnerListDao {
	 
    @Override
    public void saveOwner(Owner ownerDetails) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(ownerDetails);
        transaction.commit();
        session.close();
    }
 
    @Override
    public List<Owner> getAllOwners() {
        List<Owner> ownerList = new ArrayList();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("From Owner");
        ownerList = query.list();
        return ownerList;
    }
 
    @Override
    public void updateOwner(int ownerId, String firstName, String lastName, String phoneNumber, String homeAddress, String emailAddress) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Owner ownerDetails = (Owner)session.load(Owner.class, ownerId);
        ownerDetails.setOwnerId(ownerId);
        ownerDetails.setFirstName(firstName);
        ownerDetails.setLastName(lastName);
        ownerDetails.setPhoneNumber(phoneNumber); 
        ownerDetails.setHomeAddress(homeAddress);
        ownerDetails.setEmailAddress(emailAddress);
        session.update(ownerDetails);
        transaction.commit();
        session.close();  
    }
 
    @Override
    public void deleteOwner(Owner ownerDetails) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(ownerDetails);
        transaction.commit();
        session.close();
    }
    
}