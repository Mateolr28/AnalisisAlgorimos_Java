package com.packages.linked_list;

public class LinkedSimpleList 
{
    private Node head;

    public LinkedSimpleList()
    {
        head = null;
    }

    
    public void setHead(Node head) 
    {
        this.head = head;
    }
    
    public Node getHead() 
    {
        return head;
    }

    public void CreateBeginLSL(int datum)
    {
        Node mem = new Node();
        mem.info = datum;
        mem.link = head;
        head = mem;
    }


    public void showLSL()
    {
        Node p = head;
        while (p != null) {
            System.out.println("Información nodo: " + p.info);
            System.out.println("Liga nodo: " + p.link);
            System.out.println("Dirección del nodo: " + p);
            p = p.link;
            System.out.println("----------------------------------------");
        }
    }
}
