/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exception;

/**
 *
 * @author Bobby Pratama
 */
public class ExceptionPassword extends Exception{
    
     public String showMessageError()
    {
        return "Password Tidak boleh kurang dari 6 digit";
    }
    
}
