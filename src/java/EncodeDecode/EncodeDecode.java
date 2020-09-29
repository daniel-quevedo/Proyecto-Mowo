/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EncodeDecode;

import java.util.Base64;

/**
 *
 * @author Daniel
 */
public class EncodeDecode {
    
    private String text;
    
    public EncodeDecode(){
        
    }
    
    public EncodeDecode(String text){
        
        this.text = text;
        
    }
    
    public String encode(){
  
        //Codificar el parametro en base64
        String textEncoded = Base64.getEncoder().encodeToString(this.text.getBytes());
        
        return textEncoded;
        
    }
    
    public String decode(String textEcoded){
        
        //decodificar en cadena el formato codificado
        byte[] decByte = Base64.getDecoder().decode(textEcoded); 
        
        //pasar de bytes a String 
        
        String textDecode = new String(decByte);
        
        return textDecode;
        
    }
    
//    public static void main(String[] args) 
//    { 
//  
//        EncodeDecode obj = new EncodeDecode("juanRRamirez159753@gmail.com");
//        
//        String res = obj.encode();
//        
//        System.out.println(obj.encode());
//        
//        System.out.println(obj.decode(res));
//        
//    } 
    
}