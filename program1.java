import java.util.Scanner;
public class program1
{
	public static void main (String[] args)
	{
		CharStack opstack = new CharStack();
		Scanner scan = new Scanner(System.in);
		String line = "";
		char current;

		System.out.print("Please input your infix ezpression: ");
		line = scan.nextLine();

		for (int i=0; i<line.length(); i++)
		{
			current = line.charAt(i);

			if(CharStack.isOperand(current))
			{
				System.out.print(current);
			}
			else if(CharStack.isOperator(current))
			{
				if(!opstack.isEmpty())
				{
					char top = opstack.peek();

					while(CharStack.precedenceOrder(top)>= CharStack.precedenceOrder(current) && top != '(' && !opstack.isEmpty())
					{
						top = opstack.peek();
						System.out.print(opstack.pop());
					}
				}
				opstack.push(current);
			}
			else if(current == '(')
			{
				opstack.push(current);
			}
			else if(current == ')')
			{
				if(!opstack.isEmpty())
				{
					if(opstack.peek() == '(')
					{
						opstack.pop();
					}
					else
					{
						System.out.print(opstack.pop());
					}
				}
			}
		}
		while(!opstack.isEmpty())
		{
			{
				if(opstack.peek() != '(')
					System.out.print(opstack.pop());
			}
		}
		System.out.println("");
	}
}
