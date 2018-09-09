public class CharStack
{
  private final static int MAX_CAP = 100;//added static here ~MS
  private int top; //location of top item on the stack
  private char [] s; //The stack
//CONSTRUCTORS
  public CharStack(){
    //PRE: There isn't a stack
    //POS: stack is created
    //TAS: Create an empty stack with a default capacity
    s = new char[MAX_CAP];
    top = -1;
  }
//MUTATORS
  public void push(char element){
    //PRE: The stack isn't full
    //POS: stack grows by one
    //TAS: Add a new item to the stack
    top ++;
    s[top] = element;
  }

  public char pop (){//Edited
    //PRE: The stack isn't full
    //POS: The stack decreases by one
    //TAS: remove and return the item on the top of the stack
    char temp = s[top--];
    return temp;
  }

  public void rm (){
    //PRE: Stack isn't empty
    //POS: Stack decreases by one
    //TAS: remove the top item
    top--;
  }

//ACCESORS
  public boolean isEmpty(){//Edited
    //PRE: Stack exest
    //POS:
    //TAS: Return whether or not the stack is empty. HINT: look
    //     at the constructor.
    //return top == -1;
    if(top == -1)
	  {
		  return true;
	  }
    else
	  {
		  return false;
	  }
  }
  public boolean isFull(){
    //PRE:
    //POS:
    //TAS: return whether or not the stack is full
    return top == MAX_CAP-1;
  }
  public char peek(){
    //PRE: the stack isn't empty
    //POS: Nothing happens to the stack
    //TAS: return the top of the stack
    return s[top];
  }
  public String toString(){
    //PRE: STACK IS NOT EMPTY
    //POS: STACK IS UNCHANGED
    //TAS: return the elements of the stack from left to right starting with the top of the stack
	String x = "";
	 for(int i = top; i>-1; i--)
	{
		x =x+ (s[i] + " ");
	}
	return x;
  }//toString
  public static boolean isOperand(char c){
    if((c>='a' && c<='z') || (c>='A' && c<='Z') || (c>='0' && c<='9'))
	{
        	return true;
	}
     else
	{
        	return false;
	}
  }//isOperand

public static boolean isOperator(char c)
  {
    return c=='+' || c=='-' || c=='*' || c=='/';
  }

public static int precedenceOrder(char c)
  {
    if(c == '*' || c == '/' )
	{
		return 2;
	}
    else
	{
		return 1;
	}
  }//precedenceOrder


}