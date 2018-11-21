import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;


@RunWith(MockitoJUnitRunner.class)
public class SimpleClassTest {

    @Mock
    private List<String> mockedList;

    @Spy
    List<String> spiedList = new ArrayList<String>();

    @Test
    public void simpleTest(){
        mockedList.add("some text");
        Mockito.verify(mockedList).add("some text");
        assertEquals(0, mockedList.size());


        Mockito.when(mockedList.size()).thenReturn(99);
        assertEquals(99, mockedList.size());
    }

    @Test
    public void simpleTest2(){
        spiedList.add("one");
        spiedList.add("two");

        Mockito.verify(spiedList).add("one");
        Mockito.verify(spiedList).add("two");

        assertEquals(2, spiedList.size());

        Mockito.doReturn(100).when(spiedList).size();
        assertEquals(100, spiedList.size());

    }


}
