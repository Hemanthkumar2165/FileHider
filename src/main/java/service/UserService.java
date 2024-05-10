package service;

import Model.User;
import dao.userDAO;

public class UserService {
	public static Integer saveUser(User user) {
		try {
			if(userDAO.isExists(user.getEmail())) {
				return 0;
			}
			else {
				return userDAO.saveUser(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
