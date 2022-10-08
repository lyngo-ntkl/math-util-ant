package com.lyngo.mathutil.core;

import org.junit.Assert;
import org.junit.Test;

public class MathUtilTest {
    
    //Kiểm thử tình huống cà chớn, đưa dâta vào cà chớn
    //thì nhận về cú tát EXCEPTION
    //hàm getFactorial() được thiết kế để:
    //- nếu đưa vào n tử tế 0..20 -> sure phải ra 1 con n! đúng đắn
    //- nếu đưa vào n cà chớn n<0 || n>20
    //CHỬI CHỬI VÀ CHỬI - NÉM RA EXCEPTION/ILLEGALARGUMENTEXCEPTION
    //Bây giờ, nếu tui đưa -5 cho hàm, tui nhận về gì??? ngoại lệ
    //thấy ngoại lệ mừng rơi nước mắt
    //THẤY NGOẠI LỆ NHƯ KÌ VỌNG Ở -5! -> VIẾT CODE ĐÚNG RỒI
    
    @Test(expected = Exception.class)
    public void testFactorialGivenWrongArgumentThrowsException(){
        //Test case #6:
        //n = -5; -5!, expected: exception
        //              actual: ?
        //k xài assertEquals() vì nó dùng cho các giá trị cụ thể
        //còn ngoại lệ là 1 thứ đo lường - cách mày có xuất hiện hay k
        //mày k là 1 giá trị kiểu 5 10 15 20
        MathUtil.getFactorial(-5);//ngoại lệ cầm chắc trong tay
        //nhưng phải đo/dòm xem mày có hiện nguyên hình k
        
    }
    
    @Test
    public void testFactorialGivenRightArgumentReturnsWell2() {
        //Test case #4
        //n = 3, 3! expected: 6
        Assert.assertEquals(6, MathUtil.getFactorial(3));
        
        //Test case #5
        //n = 4, 4! expected: 24
        Assert.assertEquals(24, MathUtil.getFactorial(4));
        
        //Test case #6
        //n = 5, 5! expected: 120
        Assert.assertEquals(120, MathUtil.getFactorial(5));
    }
    
    @Test
    public void tryAssertion(){
        Assert.assertEquals(200, 200);
    }

    @Test //quy tắc đặt tên hàm kiểm thử phải mang ý nghĩa của các test case mình muốn test hàm
    public void testFactorialGivenRightArgumentReturnsWell() {
        //Test case #1 - tình huống kiểm thử xài hàm đầu tiên
        //n=0, 0! expected = 1; actual: chạy hàm mới biết được
        //expected == actual, hàm đúng, MÀU XANH
        //expected != actual, hàm sai, MÀU ĐỎ
        long expected = 1;
        long actual = MathUtil.getFactorial(0);
        //phải so sánh 2 giá trị này!!! dùng Framework, k xài sout
        Assert.assertEquals(expected, actual);
        //compare whether 0! return value is 1
        
        //Test case #2
        //n = 1; 1! expected = 1, actual =?
        expected = 1;
        actual = MathUtil.getFactorial(1);
        Assert.assertEquals(expected, actual);
        
        //Test case #3
        //n = 2, 2! expected: 2
        Assert.assertEquals(2, MathUtil.getFactorial(2));
    }

    //TRONG CLASS NÀY CHỨA CÁI GÌ???
    //CLASS NÀY CHỨA CÁC ĐOẠN CODE DÙNG ĐỂ TEST CODE CHÍNH BÊN THƯ MỤC
    //SOURCE PACKAGES
    //CÁC ĐOẠN CODE Ở ĐÂY SẼ DÙNG ĐỂ TEST HÀM GETFACTORIAL ĐỂ XEM CHẠY CÓ ĐÚNG KHÔNG
    //VIẾT CODE ĐỂ TEST CODE
    //NHỮNG ĐOẠN CODE TRONG NÀY DO DEVELOPER VIẾT RA DÙNG ĐỂ TEST CHÍNH
    //CÁI CODE BÊN THƯ MỤC SOURCE ĐỂ ĐẢM BẢO RẰNG HÀM
    //PHẢI CHẠY ĐÚNG
    //ĐOẠN CODE DÙNG ĐỂ TEST CODE THÌ ĐƯỢC GỌI LÀ TEST SCRIPT
    //CÁC TEST SCRI[T NÀY SẼ CÓ LỆNH CƠ BẢN: SO SÁNH GIỮA EXPECTED & ACTUAL
    //NHƯ BÊN HÀM MAIN() ĐÃ LÀM THỬ!!!
    //NHỮNG ĐOẠN CODE NÀY K DÙNG LỆNH SOUT() TRUYỀN THỐNG MÀ DÙNG NHỮNG THƯ VIỆN ĐẶC BIỆT
    //Khi hàm sai, expected != actual => NÉM RA MÀU ĐỎ
    //Khi hàm chạy đúng => NÉM RA MÀU XANH
    //Các thư viện giúp thảy ra màu xanh đỏ, tự so sánh giùm expected & actual
    //để kết luận hàm đúng sai, mắt lúc này chỉ cần nhìn đúng 2 MÀU XANH ĐỎ
    //K CẦN XEM CHI TIẾT CÁC DÒNG SO SÁNH BÊN MAIN()
    //BỘ THƯ VIỆN NÀY CÒN GỌI LÀ UNIT TEST FRAMEWORK
    //MỖI NGÔN NGỮ LẬP TRÌNH ĐỀU CÓ VÀI BỘ THƯ VIỆN THẢY RA MÀU XANH ĐỎ
    //GIÚP CÁC DEV TEST HÀM CỦA MÌNH
    //VD:
    //Java: JUnit, TestNG
    //C#: xUnit, NUnit, MSTest
    //PHP: phpUnit
    //JavaScript:...
    //Python:
    //Google gõ: Unit Test framework for... NNLT ra tên
    
    //@Test is an ANNOTATION, cờ đánh dấu
    //báo hiệu cho JUnit biết cần GENERATE HÀM MAIN()
    //BIẾN HÀM NÀY THÀNH HÀM MAIN() & GỬI MAIN() NÀY CHO JVM BIẾT ĐỂ CHẠY,KHI CHẠY THÌ SO SÁNH
    //EXPECTED vs ACTUAL, IF == => XANH, ELSE => ĐỎ
    //NẾU K CÓ @TEST, CHẢ CÓ HÀM MAIN() NÀO ĐƯỢC GENERATE, NO RUNNABLE METHODS
    //VIỆC XÀI THƯ VIỆN MÀ BỊ ÉP PHẢI LÀM GÌ ĐÓ, THEO QUY TẮC NÀO ĐÓ
    //GỌI LÀ FRAMEWORK
    
    
    //CHỐT DEAL XANH ĐỎ
    //NẾU VIỆC CHẠY BỘ TEST CASE RA MÀU XANH, KHI VÀ CHỈ KHI TẤT CẢ ĐỀU XANH
    //XANH: KHI CÁC TEST CASE CÙNG XANH
    //XANH: KHI TẤT CẢ CÁC VIỆC SO SÁNH EXPECTED == ACTUAL
    
    //ĐỎ: CHỈ CẦN 1 THẰNG TRONG ĐÁM TEST CASE MÀU ĐỎ, TẤT CẢ MÀU ĐỎ
    //ĐỎ: CHỈ CẦN 1 VIỆC SO SÁNH EXPECTED != ACTUAL, MÀU ĐỎ FOR ALL
    
    //LOGIC: HÀM NẾU ĐÃ ĐÚNG, THÌ PHẢI ĐÚNG VỚI TẤT CẢ CÁC TEST CASE ĐƯỢC LIỆT KÊ RA
    //HÀM NGON VỚI CÁC CASE ĐÃ TEST
    //CỐ GẮNG LIỆT KÊ ĐC ĐỦ CASE LÀ TỐT NHẤT!!!
    //NGUYÊN LÝ SỐ 2
    
    //CHỐT DEAL 2:
    //KHI RA MÀU XANH TỔNG, HÀM ỔN VỚI CÁC TEST CASE
    //KHI RA MÀU ĐỎ, NGHĨA LÀ CÓ ÍT NHẤT 1 VIỆC SO SÁNH EXPECTED != ACTUAL
    //MÀU ĐỎ VÌ LÍ DO GÌ PHÍA SAU
    //- DO ACTUAL TRẢ VỀ KHÔNG ĐÚNG NHƯ KÌ VỌNG => BUG
    //- DO EXPECTED TÍNH TOÁN K ĐÚNG LUÔN!!! QC BỊ NGÁO
}
