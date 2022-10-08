package com.lyngo.mathutil.core;

//Khi mình import static thì k cần ClassName.StaticMethodName nữa

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static com.lyngo.mathutil.core.MathUtil.*;

@RunWith(value = Parameterized.class)
public class MathUtilDDTTest {
    //chuẩn bị data, mảng 2 chiều vì nó có n đưa vào 
    //và có nhiều cặp như thế[7]
    //mảng 2 chiều [7][2]
    
    @Parameterized.Parameters
    public static Object[][] initData(){
        int a[] = {5,10,15,20,25};
        int b[][] = {{1,0}, {1,1}, {2,2}, {6,3}, {24,4}, {120,5}, {720,6}};
        int c[][] = {{1,0},
                     {1,1},
                     {2,2},
                     {6,3},
                     {24,4},
                     {120,5},
                     {720,6}};
        return new Integer[][] {{1,0},
                                {1,1},
                                {2,2},
                                {6,3},
                                {24,4},
                                {120,5},
                                {720,6}
                                };
    } //xài Wrapper class nếu chơi số, ví dụ Integer (int) Long (long)
    
    //sau khi có bộ data qua mảng 2 chiều, JUnit sẽ tự lặp for
    //để lôi ra từng cặp data (1,0) (1,1)
    //nhồi cặp này vào trong hàm so sánh
    //nhưng nhồi bằng cách nào, gán value này vào biến
    //gán vào biến - THAM SỐ HÓA PARAMETERIZED
    //TA SẼ MAP/ÁNH XẠ 2 CỘT ỨNG VỚI 2 BIẾN: CỘT 0 - EXPECTED
    //                                       CỘT 1 - N ĐƯA VÀO HÀM GETF()
    
    @Parameterized.Parameter(value = 0)
    public long expected;
    @Parameterized.Parameter(value = 1)
    public int n;
    
    //test hoy vì đã có test case & data
    @Test
    public void testFactorialGivenRightArgumentReturnsWell(){
        Assert.assertEquals(expected, getFactorial(n));
    }
}

//CLASS NÀY SẼ CHỨA CODE DÙNG ĐỂ TEST CODE CHÍNH BÊN CLASS MATHUTIL
//CLASS NÀY SẼ CHỨA CODE DÙNG ĐỂ TEST HÀM getFactorial() coi hàm chạy đúng hay không
//Code viết ra dùng để test code khác (hàm/class) gọi là: TEST SCRIPT
//Trong test script sẽ có những tình huống xài app, đưa data cụ thể vào
//chờ xem hàm xử lí kết quả có như kì vọng hay không?
//Một test script sẽ chứa nhiều TEST CASES
//                          mỗi test case ứng với 1 tình huống xài hàm

//Phân tích Test Script cũ - hôm qua kia
//Trong test script cũ xuất hiện bad smell, sự trùng lặp về câu lệnh dưới đây
//Assert.assertEquals(6, MathUtil.getFactorial(3));
//lệnh so sánh giá trị, lệnh gọi hàm đc lặp đi lặp lại cho các bộ data sau:

//Expected              n
//1                     0
//1                     1
//2                     2
//6                     3
//24                    4
//120                   5
//720                   6

//Có cách nào thay 2 con số trong lệnh so sánh thành 2 ? nào đó
//Assert.assertEquals(?, MathUtil.getFactorial(?));

//Nếu ta tách đc toàn bộ data trong các câu lệnh so sánh ở trên
//ra 1 chỗ riêng biệt như hàng cột ở trên, sau đó
//ta chỉ việc pick/lấy/tỉa data này nạp dần vào/nhồi vào lệnh gọi hàm, thì ta sẽ đạt đc:
//- Code gọn gàng hơn k bị trùng lặp
//- Nhìn tổng quan biết có bao nhiêu test case và liệu rằng chúng đã đủ hay chưa

//Kĩ thuật viết test script (câu lệnh test) mà tách biệt data ra khỏi các
//lệnh so sánh đc gọi bằng những tên sau:

//- PARAMETERIZED - THAM SỐ HÓA, BIẾN DATA RA 1 CHỖ, ĐẶT CHO CHÚNG TÊN BIẾN, 
//LÁT HỒI NHỒI CHÚNG TRỞ LẠI LỆNH SO SÁNH

//- DDT - DATA DRIVEN TESTING, VIẾT CODE KIỂM THỬ THEO STYLE TÁCH DATA
//JUNIT FW HỖ TRỢ SẴN TA VỤ TÁCH DATA, DUYỆT VÒNG FOR TRÊN DATA