/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techbiosis;

/**
 *
 * @author nelsonalmeida
 */
public class TechbiosisTest {

    int num = 0;

    public int number(){
        
        num = 20000010 % 1000;
        
        return num;
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TechbiosisTest obj = new TechbiosisTest();
         System.out.println("Numero: " + obj.number());
    }
    
}
