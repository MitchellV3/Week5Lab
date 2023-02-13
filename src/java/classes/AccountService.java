/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author Mitchell
 */
public class AccountService {
    
    private static final String USER_ABE = "abe";
    private static final String USER_BARB = "barb";
    private static final String PASSWORD = "password";
    
    /**
     *
     * @param username
     * @param password
     * @return
     */
    public User login(String username, String password) {
        if((USER_ABE.equals(username) || USER_BARB.equals(username)) && PASSWORD.equals(password)) {
            User user = new User();
            user.setUsername(username);
            user.setPassword(null);
            return user;
        } else {
            return null;
        }
    }
    
}





