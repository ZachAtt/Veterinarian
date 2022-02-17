package dao;

import java.util.List;

import pojo.Owner;

public interface OwnerListDao {

	public void saveOwner(Owner ownerDetails);
	public List<Owner> getAllOwners();
	public void updateOwner(int ownerId, String firstName, String lastName, String phoneNumber, String homeAddress, String emailAddress);
	public void deleteOwner(Owner ownerDetails);
	
}
