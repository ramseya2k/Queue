import java.util.*;
import java.io.*;
class Main 
{
  public static void main(String[] args) throws FileNotFoundException
  {
    Queuez q = new Queuez();
    q.finalizer("Numbers.txt");
  }
}

class Node
{
  private int value;
  private Node next;
 /**
 * This function is a constructor to create a node with its own number
 * @param value number to be inserted
 */
  Node(int value) 
  {
    this.value=value;
  }
 /**
 * this function returns a number associated with the node
 * @return value associated with the node
 */
  public int getValue()
  {
    return this.value;
  }
 /**
 * This function allows the user to update the value
 * @param value number to update the value of the node associated
 */
  public void setValue(int value)
  {
    this.value=value;
  }
 /**
 * this function returns a node 
 * @return next is the node linked to the other node
 */
  public Node getNext()
  {
    return next;
  }
 /**
 * This function allows the user to point to a node 
 * @param n is the object type of node 
 */
  public void setNext(Node n)
  {
    next=n;
  }
}

class Queuez
{
  private Node front;
  private Node rear;
  private int num;
  
  public void finalizer(String fileName) throws FileNotFoundException
  {
    importer(fileName);
    Node curr=front;
    int count=1;
    while(curr!=null)
    {
      count++;
      curr=curr.getNext();
    }
    curr=front;
    for(int i=0;i<count;i++)
    {
      if(curr.getValue()<0)
      {
        dequeue();
      }
      else
      {
        dequeue();
        enqueue(curr.getValue());
      }
      curr=curr.getNext();
    }
    traverse();
  }
  public void importer(String fileName) throws FileNotFoundException
  {
    Scanner file = new Scanner(new File(fileName));
    while(file.hasNext())
    {
      int num = Integer.parseInt(file.next());
      enqueue(num);
    }
  }
  public void enqueue(int value)
  {
    Node newNode = new Node(value);
    newNode.setNext(null);
    if(front==null)
    {
      front=rear=newNode;
    }
    else
    {
      rear.setNext(newNode);
      rear=newNode;
    }
  }
  public int dequeue()
  {
    int temp=-1;
    if(front!=null)
    {
      temp = front.getValue();
      front=front.getNext();
      if(front==null)
      {
        rear=front;
      }
    }
    return temp;
  } 
  public void traverse()
  {
    Node current = front; // temp node 
    while(current!=null)
    {
      System.out.print(" "+current.getValue()); // displays numbers
      current=current.getNext(); // traverses
    }
    System.out.println();  
  }
}
