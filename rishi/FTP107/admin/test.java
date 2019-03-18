class Sample
{
Static int a=100;
public static void show()
{
int b=1001;
System.out.println("Value of a is"+a+b);
}
}
class Test
{
public static void main(String[] args)
Sample s=new Sample();
s.show();
}