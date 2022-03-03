package mockito;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

public class StudentTest {

    StudentService studentService= Mockito.mock(StudentService.class);

    Student student=new Student(studentService);

    @Test//(expected = Exception.class)
    public void testGetAverage(){
        /*Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                System.out.println("anser is doing");
                return "Sharukh";
            }
        }).when(studentService).voidMethod();
        */
        //Mockito.doNothing().when(studentService).voidMethod();
        Mockito.doAnswer(invocation->{
            System.out.println("this lamda expression void");
            return "Sharukh khan";
        }).when(studentService).voidMethod();

        //Mockito.doThrow(new RuntimeException("This is RunTime Excetion")).when(studentService).voidMethod();
        //Mockito.doCallRealMethod().when(studentService).voidMethod();

        Mockito.when(studentService.getTotalStudent()).thenReturn(5000);
        //Mockito.when(studentService.getTotalMarks()).thenReturn(1000);
        Mockito.when(studentService.getTotalMarks()).thenAnswer(invocation -> {
            return 1000;
        });
        //Mockito.when(studentService.getTotalMarks()).thenThrow(new Exception("just for demo"));
        //Mockito.when(student.staticMethods()).thenReturn(15);

        Assert.assertEquals(5,student.getAverage());
        Mockito.verify(studentService,Mockito.times(1)).getTotalStudent();
        Mockito.verify(studentService,Mockito.times(1)).voidMethod();


    }
}
