/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helper;


/**
 *
 * @author User
 */
public class Helper {
    public static int getEndp(int total){
        int endPage=total/6;
        if(total % 6 !=0){
            endPage++;
        }
        return endPage;
    }
    
}
