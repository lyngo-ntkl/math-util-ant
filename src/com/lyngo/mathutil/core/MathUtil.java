/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lyngo.mathutil.core;

/**
 *
 * @author Dell
 */
//clone math library của JDK
//giả lập các hàm math of jdk
//những gì là công cụ cho hàm/class khác đc thiết kế là static
//class level, nên k có new keyword
public class MathUtil {
    public static final double E = 2.7182818284590452354;
    public static final double PI = 3.14159265358979323846;
    
    //hàm tính n! = 1.2.3...n
    //Quy ước
    //Không có giai thừa cho số âm
    //0! = 1! = 1
    //21! vượt 18 số 0, vượt kiểu long
    //hàm của chúng ta design là chỉ chấp nhận tính giai thừa của n từ 0..20
    //<0 || >20 chửi, m đưa data cà chớn
    public static long getFactorial(int n){
        if(n<0 || n>20)
            throw new IllegalArgumentException("Invalid n. n must be between 0 to 20");
        if(n == 0 || n == 1)
            return 1;
        //sống sót đến đây, sure n từ
        long product = 1; //acc = accumulation, biến con heo đất góp dần, nhân tích lũy
        for (int i = 2; i <= n; i++) 
            product *= i;
        return product;
    }
}

//KĨ THUẬT LẬP TRÌNH KIỂU MỚI (VẪN GIỮ NGUYÊN NHỮNG KIẾN THỨC LẬP TRÌNH ĐÃ CÓ)
//1 PLUGIN MỚI CHO TRÌNH ĐỘ CỦA DEV - VIẾT CODE CÓ CHẤT LƯỢNG
//CHẤT LƯỢNG KHÔNG NÓI = MIỆNG, CHẤT LƯỢNG NÓI = CODE
//KĨ THUẬT TDD - TEST DRIVEN DEVELOPMENT
//VIẾT CODE VÀ VIẾT CODE ĐỂ TEST CODE SONG SONG VỚI NHAU
//MỖI HÀM DEVELOPER VIẾT RA PHẢI VIẾT NGAY TEST CASE
//HÀNH ĐỘNG ĐỂ KIỂM THỬ HÀM, ĐỂ BIẾT RẰNG HÀM CHẠY SAI HAY ĐÚNG
//NẾU TA XÀI TDD, NÓ GIÚP TA ĐI VÀO QUY TRÌNH CI

/*
 * Để làm TDD ta:
 * 1. Phác thảo prototype of hàm, method, class
 * 2. Viết các bộ kiểm thử/test cases là các đoạn code bổ sung thêm
      nhưng là để xài hàm vừa viết, để check xem hàm vừa viết ổn không
 * 3. Chạy thử hàm vừa viết với bộ test case vừa tạo, xem tình hình hàm
      đúng sai ra sao. SAI -> refactor, sửa code
                       ĐÚNG -> hoàn thiện hết code khác
 * Liên tục như vậy
*/
