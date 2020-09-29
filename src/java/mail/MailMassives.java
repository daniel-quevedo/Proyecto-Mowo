/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mail;

/**
 *
 * @author Daniel
 */
public class MailMassives implements Runnable{
    
    private String mail;
    
    public MailMassives(String mail){
        this.mail = mail;
    }

    @Override
    public void run() {
        
        Mail mail = new Mail(this.mail);
        mail.sendMail();
    
    }
}
