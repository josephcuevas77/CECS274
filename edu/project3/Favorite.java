package edu.project3;

import java.util.ArrayList;

public class Favorite {
	
	/**
	 * Constructs a private Array List for the contact frame of the specific Favorite contact
	 */

	private ArrayList<FavoriteContactFrame> favorites = new ArrayList<FavoriteContactFrame>(); 
	
	public Favorite() {
		favorites = new ArrayList<FavoriteContactFrame>();
	}
	
	/**
	 * Adds desired contact to the Favorites list and assigns their info to a contact frame
	 * @param f the favorite contact frame to be added
	 */

	public void addFavorite(FavoriteContactFrame f) {
		favorites.add(f);
	}
	
	/**
	 * gives the user the option to remove a contact from the Favorites list
	 * @param f the favorite contact frame that is in the list
	 * @param name the name from the contact that wants to be removed
	 * @return boolean values whether or not fav removed
	 */

	public boolean removeFav(FavoriteContactFrame f, String name) {
		for (int i=0; i<favorites.size(); i++) {
			FavoriteContactFrame contactInfo = favorites.get(i);
			String contactName = contactInfo.getContactName();
			if (contactName.equals(f.getContactName())) {
				favorites.remove(f);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * gets the size of the favorites list
	 * @return size
	 */

	public int getSize() {
		return favorites.size();
	}
	/**
	 * gives the user the option to replace the order of the favorites
	 * @param index the place of the favorite
	 * @param change the new place of the favorite
	 */
	public void replaceFav(int index, FavoriteContactFrame change) {
		favorites.set(index, change);
	}
	
	/**
	 * creates an object that retrieves the favorite contact
	 * @param name of the contact
	 * @return contact
	 */
	public FavoriteContactFrame getFavorite(String name) {
		for (FavoriteContactFrame f: favorites) {
			if (f.getContactName().equals(name)) {
				return f;
			}
		}
		return null;
	}
	
	/**
	 * gets the index of the contact
	 * @param index the place of the contact
	 * @return index
	 */
	public FavoriteContactFrame getFavoriteAt(int index) {
		return favorites.get(index);
	}
	
	/**
	 * inserts the favorite into favorites list
	 * @param index - placememet of contact
	 * @param insert - creates contact frame/ picture for contact
	 */
	public void insertFav(int index, FavoriteContactFrame insert) {
		favorites.add(index, insert);
	}
	
	/**
	 * Displays the favorite as contact frame with an image plus its contact info
	 */
	public void showFavs() {
		for (FavoriteContactFrame f: favorites) {
			f.displayContactFrame();
		}
	}
}
