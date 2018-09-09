import java.util.Scanner;

public class program1
{
public static void main(String[] args)
{
	//init variables
	CharStack opstack = new CharStack();
	Scanner scan = new Scanner(System.in);
	String expression = "";
	char current;

	//receive input
	System.out.println("Please input your infix expression: ");
	expression = scan.next();
	System.out.print("Postfix Conversion: ");

	//compute
	for (int x = 0; x < expression.length(); x++)
		{
			//set pointer
			current = expression.charAt(x);

			//pointer is operand
			if(CharStack.isOperand(current))
				{
					System.out.print(current);
				}//if
			else if(CharStack.isOperator(current))
				{
					if(!opstack.isEmpty())
						{
							char top = opstack.peek();
							while(CharStack.precedenceOrder(top)>= CharStack.precedenceOrder(current) && top != '(' && !opstack.isEmpty())
								{
									top = opstack.peek();
									System.out.print(opstack.pop());
								}//while
						}//if
							opstack.push(current);
				}//else if
			else if(current == '(')
				{
					opstack.push(current);
				}//else if
			else if(current == ')')
				{
					while(!opstack.isEmpty())//while
						{
							if(opstack.peek() == '(')
								{
									opstack.rm();
								}//if
							else
								{
									System.out.print(opstack.pop());
								}//else
						}//while
				}//else if
		}//for
	while(!opstack.isEmpty())
				{
					if(opstack.peek() != '(');
						System.out.print(opstack.pop());
				}
System.out.println("");
}//main
}//class