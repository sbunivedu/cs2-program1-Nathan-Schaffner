public class CharStack
{
  private final int MAX_CAP = 100;
  private int top; //location of top item on the stack
  private char [] s; //The stack

  public CharStack()
  {
    //PRE: a stack dosn't exist
    //POS: a stack will exist
    //TAS: Create an empty stack with a default capacity
    s = new char[MAX_CAP];
    top = -1;
  }
  public void remove()
  {
    top--;
  }
  public void push (char element)
  {
    //PRE: the stack is not full
    //POS: there is one more element
    //TAS: Add a new item to the stack
    top ++;
    s[top] = element;
  }

  public char pop ()
  {
    //PRE: elements are in the stack
    //POS: an element is removed from the stack
    //TAS: remove and return the item on the top of the stack
    char temp = s[top--];

    return temp;
  }

  public boolean isEmpty()
  {
    //PRE: elements are or are not in the stack
    //POS: returns either true or false if the stack is empty or not
    //TAS: Return whether or not the stack is empty. HINT: look
    //     at the constructor.
    if (top == -1)
    {
      return true;
    }
    else
    {
      return false;
    }
  }

  public boolean isFull()
  {
    //PRE: A stack has to exist
    //POS: the stack is either going to be full or not
    //TAS: return whether or not the stack is full
    return top == MAX_CAP-1;
  }

  public char peek()
  {
   return s[top];
  }

  public String toString()
  {
    String stack = "";
    for (int i=top; i < -1; i--)
    {
      stack += (s[i] + " ");
    }
    return stack;
  }
  public static boolean isOperand(char c)
  {
    if(
      (c>='a' && c<='z') ||
      (c>='A' && c<='Z') ||
      (c>='0' && c<='9'))
      {
        return true;
      }else
      {
        return false;
      }
  }

  public static boolean isOperator(char c)
  {
    return c=='+' || c=='-' || c=='*' || c=='/';
  }

  public static int precedenceOrder(char c)
  {
    if(c == '*' || c == '/' ){
      return 2;
    }
      else
    {
      return 1;
    }
  }

}