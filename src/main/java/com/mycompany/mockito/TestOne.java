/*
  http://static.javadoc.io/org.mockito/mockito-core/2.23.0/org/mockito/Mockito.html

 */
package com.mycompany.mockito;

import java.util.LinkedList;
import java.util.List;
import org.mockito.InOrder;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 *
 * @author eder
 */
public class TestOne {

    public static void main(String[] args) {

        verifyInOrder();

    }

    public static void verifyInOrder() {

        List singleMock = mock(List.class);

        singleMock.add("was added first");
        singleMock.add("was added second");

        InOrder inOrder = inOrder(singleMock);
        
        inOrder.verify(singleMock).add("was added first");
        inOrder.verify(singleMock).add("was added second");
        
        //multiple mocks tha must be used in a particular order
        
        List firstMock = mock(List.class);
        List seconMock = mock(List.class);
        
        firstMock.add("was added first");
        seconMock.add("was added second");
        
        InOrder innOrder = inOrder(firstMock, seconMock);
        
        innOrder.verify(firstMock).add("was added first");
        innOrder.verify(seconMock).add("was added second");

    }

    public static void verifyRepetition() {

        LinkedList mockedList = mock(LinkedList.class);

        mockedList.add("once");

        mockedList.add("twice");
        mockedList.add("twice");

        mockedList.add("three times");
        mockedList.add("three times");
        mockedList.add("three times");

        verify(mockedList).add("once");
        verify(mockedList, times(1)).add("once");

        verify(mockedList, times(2)).add("twice");
        verify(mockedList, times(3)).add("three times");

        verify(mockedList, never()).add("Never Happened");

        verify(mockedList, atLeastOnce()).add("three times");
        verify(mockedList, atLeast(2)).add("twice");
        verify(mockedList, atMost(5)).add("three times");
    }

}
