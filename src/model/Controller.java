package model;
import java.util.Calendar;
public class Controller {

	private User[] users;

	public Controller() {

		users = new User[10];
	}
	public String getUserList() {

		String msg = "";

		for (int i = 0; i < users.length; i++) {

			if (users[i] != null) {
				msg += "\n" + (i + 1) + ". " + users[i].getId() + " - " + users[i].getName();
			}

		}

		return msg;

	}

	public boolean registerUser(String id, String name, String nickname,int optionUser, int optionCA, Calendar signUpDate) {

		Category categorys = Category.SILVER;
		if(optionCA==2){
			categorys = Category.GOLD;
		} else if (optionCA == 3) {
			categorys = Category.DIAMOND;
		}


		User newUser = null;

		if(optionUser==1){
			newUser = new Regular(id,name,nickname, signUpDate);
		} else if (optionUser == 2){
			newUser = new Premium(id,name,nickname,categorys, signUpDate);
		}

		if (newUser != null) {
            for (int i = 0; i < users.length; i++) {
                if (users[i] == null) {
                    users[i] = newUser;
                    return true;
                }
            }
        }
		return false;
	}
	public boolean checkUser(int optionUser){
		
		if(users[optionUser] instanceof Regular){
			return false;
		}
		return true;
	}
	public boolean editUser(int userPosition, String newName, int newCategory) {
		
		Category categorys = Category.SILVER;
		if(newCategory==2){
			categorys = Category.GOLD;
		} else if (newCategory == 3) {
			categorys = Category.DIAMOND;
		}

		for(int i = 0; i<users.length; i++){
			if(users[i]!=null){
				if(checkUser(userPosition)){
					((Premium) users[i]).setName(newName);
					((Premium) users[i]).setCategory(categorys);
				} else {
					((Regular) users[i]).setName(newName);
				}
				return true;
			}
		}

		return false;
	}

	public boolean deleteUser(int userPosition) {
	
		if (users[userPosition] != null) {
			users[userPosition] = null;
			return true;
		}
		return false;
	}

	public String getUserInfo(int option) {

		String msg = "";

		if (users[option - 1] != null) {
			User user = users[option - 1];
			msg += "ID: " + user.getId() + "\n";
			msg += "Nombre: " + user.getName() + "\n";
			msg += "Nickname: " + user.getNickname() + "\n";
			msg += "Fecha de registro: " + user.getSignUpDateFormated() + "\n";
			
			if (user instanceof Premium) {
				Premium premiumUser = (Premium) user;
				msg += "Categoría: " + premiumUser.getCategory() + "\n";
			}
			

		}
		
		return msg;
	}

	public String getAllUserInfo() {
		
		String msg = "";
	
		for (int i = 0; i < users.length; i++) {
			User user = users[i];
			if (user != null) {
				msg += "ID: " + user.getId() + "\n";
				msg += "Nombre: " + user.getName() + "\n";
				msg += "Nickname: " + user.getNickname() + "\n";
				msg += "Fecha de registro: " + user.getSignUpDateFormated()+ "\n";
	
				if (user instanceof Premium) {
					Premium premiumUser = (Premium) user;
					msg += "Categoría: " + premiumUser.getCategory() + "\n";
				}
	
				msg += "--------------------------\n";
			}
		}
	
		return msg;
	}


	public String userReport() {
		
		String msg = "";

		int regularReport = 0;
		int premiumReport = 0;
		int silverReport = 0;
		int goldReport = 0;
		int diamondReport = 0;
	
		for (int i = 0; i < users.length; i++) {
			if (users[i] instanceof Regular) {
				regularReport++;
			} else if (users[i] instanceof Premium) {
				premiumReport++;
				Category category = ((Premium) users[i]).getCategory();
				if(category==Category.SILVER){
					silverReport++;
				} else if (category==Category.GOLD){
					goldReport++;
				} else if (category==Category.DIAMOND){
					diamondReport++;
				}
			}
			
		}
		
	
		msg += "Total de Usuarios: " + (regularReport + premiumReport) + "\n";
		msg += "Usuarios Regulares: " + regularReport + "\n";
		msg += "Usuarios Premium: " + premiumReport + "\n";
		msg += "Usuarios Silver: " + silverReport + "\n";
		msg += "Usuarios Gold: " + goldReport + "\n";
		msg += "Usuarios Diamond: " + diamondReport + "\n";
	
		return msg;
	}

	// New method

	public boolean changeUserCategory(int userPosition, int newCategory) {
		Category category = Category.SILVER;
		if (newCategory == 2) {
			category = Category.GOLD;
		} else if (newCategory == 3) {
			category = Category.DIAMOND;
		}

		User user = users[userPosition];
		if (user != null && user instanceof Premium) {
			((Premium) user).setCategory(category);
			return true;
		}
		return false;
	}


	//correcion de errores
	public String getUsersPerCategory() {
		int silverUsers = 0;
		int goldUsers = 0;
		int diamondUsers = 0;
	
		for (User user : users) {
			if (user instanceof Premium) {
				Category category = ((Premium) user).getCategory();
				switch (category) {
					case SILVER:
						silverUsers++;
						break;
					case GOLD:
						goldUsers++;
						break;
					case DIAMOND:
						diamondUsers++;
						break;
				}
			}
		}
	
		String msg = "Usuarios en cada categoría:\n";
		msg += "Silver: " + silverUsers + "\n";
		msg += "Gold: " + goldUsers + "\n";
		msg += "Diamond: " + diamondUsers + "\n";
		return msg;
	}



	//new method #3
	public boolean deleteUserAccount(int userPosition) {
		User userToDelete = users[userPosition];
		
		if (userToDelete != null) {
			users[userPosition] = null;  
			return true;
		}
		
		return false;  
	}


}
