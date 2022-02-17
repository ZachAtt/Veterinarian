package dao;

import java.util.List;

import pojo.Pet;

public interface PetListDao {

	public void savePet(Pet petDetails);
	public List<Pet> getAllPets();
	public void updatePet(int PetID, String Name, String PetType, String Breed, String Gender, String Size, int OwnerID);
	public void deletePet(Pet petDetails);
	
}
