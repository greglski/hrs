package com.hrs;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MyStructureTestSuite {

    private Node n1 = new Node("C1", "R1");
    private Node n2 = new Node("C2", "R2");
    private Node n3 = new Node("C3", "R3");
    private Node n4 = new Node("C4", "R4");
    private Node n5 = new Node("C5", "R5");
    private Node n6 = new Node("C6", "R6");
    private Node n7 = new Node("C7", "R7");
    private List<INode> iNodes = new ArrayList<>();

    @Before
    public void addingINodes() {
        n1.addNode(n2);
        n1.addNode(n3);
        n3.addNode(n4);
        n3.addNode(n5);
        n5.addNode(n6);
        n5.addNode(n7);
        iNodes.add(n1);
        iNodes.add(n2);
        iNodes.add(n3);
        iNodes.add(n4);
        iNodes.add(n5);
        iNodes.add(n6);
        iNodes.add(n7);

        /*n4.addNode(n1);
        n4.addNode(n2);
        n3.addNode(n1);
        n3.addNode(n2);
        n3.addNode(n4);
        iNodes.add(n1);
        iNodes.add(n2);
        iNodes.add(n3);
        iNodes.add(n4);*/
    }

    @Test
    public void testFindByCode() {
        //Given
        MyStructure myStructure = new MyStructure(iNodes);
        //When
        INode node = myStructure.findByCode("C3");
        //Then
        System.out.println(node);
        Assert.assertEquals(n3, node);
    }

    @Test
    public void testFindByRenderer() {
        //Given
        MyStructure myStructure = new MyStructure(iNodes);
        //When
        INode node = myStructure.findByRenderer("R7");
        //Then
        System.out.println(node);
        Assert.assertEquals(n7, node);
    }

    @Test
    public void testCount() {
        //Given
        MyStructure myStructure = new MyStructure(iNodes);
        //When
        int nodesCount = myStructure.count();
        //Then
        Assert.assertEquals(7, nodesCount);
    }
}
