/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package price.registrationtest.customclasess;

/**
 *
 * @author Konst
 */
public class User {

    private final String email;
    private final String password;
    private final String name;

    public User() {
        this.email = UserVariables.getInstance().getUserEmail();
        this.password = UserVariables.getInstance().getUserPassword();
        this.name = UserVariables.getInstance().getUserName();
        
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    
    
}
