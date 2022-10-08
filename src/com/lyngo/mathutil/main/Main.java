/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.lyngo.mathutil.main;

import com.lyngo.mathutil.core.MathUtil;


/**
 *
 * @author Dell
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("This message comes from the main() method");
        tryTDDFirst();
    }
    
    public static void tryTDDFirst(){
        //test case 1
        //n = 0 => expected = 1
        long expected = 1;
        long actual = MathUtil.getFactorial(0);//xài hàm vừa viết
        //so sánh 2 giá trị để biết hàm viết đúng or not
        //3 thứ này tổ hợp nên 1 thứ gọi là test case
        System.out.println("0! Status | Expected = " + expected + 
                                    " | Actual = " + actual);
        
        //Test case 2: n = 1, expected n! = 1
        expected = 1;
        actual = MathUtil.getFactorial(1);
        System.out.println("1! Status | Expected = " + expected + 
                                    " | Actual = " + actual);
        
        //Test case 3: n = 2, expected n! = 2
        expected = 2;
        actual = MathUtil.getFactorial(2);
        System.out.println("2! Status | Expected = " + expected + 
                                    " | Actual = " + actual);
        
    }
    
}
