import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


class AssemblyLine		
{
	static JFrame frame;
	static Container content;
	public int stations = 2;
	static public JLabel[][] jLs;
	
	@SuppressWarnings("resource") void setUp() throws IOException // Swing Library.
	{
		String buffer;
		int i,j;
	
		jLs = new JLabel[stations][5];
		frame = new JFrame("Assembly Line Optimization");
	
		content = frame.getContentPane();  
		content.setLayout(new GridLayout(stations+1, 4));  	
		content.setBackground(Color.white);
		for(i =0;i<stations;i++){
			for(j =0;j<5;j++){
				jLs[i][j] = new JLabel();
				content.add(jLs[i][j]);
			}
		}
		ImageIcon icon = new ImageIcon("image.jpg");	
		for(i =0;i<stations;i++)
		{
			jLs[i][0].setIcon(icon);
			jLs[i][4].setIcon(icon);
		}
		
		JButton first = new JButton("Simulate the car");  				
		
		content.add(first);
		JButton second = new JButton("Apply Car");  				
	
		content.add(second);
		frame.pack();				
		frame.setVisible(true); 	
	}
	
	
public static void main(String args[])

{
int []array1={9,8,7,6,4,3};
int []array2={8,5,6,4,5,7};
int []time1={2,3,1,3,4};
int []time2={2,1,2,2,1};

int x=2;
int y=4;
int x1=3;
int y1=3;
int f,l,k;
int[] x2,y2,x3,y3;

x2=new int[6];
y2=new int[6]; 
x3=new int[6];
y3=new int[6];

x2[0]=x+array1[0];
y2[0]=y+array2[0];

System.out.println("\nTime Optimization for stations on Line no: 1");

for (int i=0;i<6;i++)
System.out.print(" "+(i+1));
System.out.print("\nAssembly Time Optimization\n:");
for(int i=0;i<6;i++)
System.out.print(" "+array1[i]);
System.out.println("\nTime Optimization for stations on Line no: 2");

System.out.print("Station is\n:");
for (int i=0;i<6;i++)
System.out.print(" "+(i+1));
System.out.print("\nAssembly Time Optimization is\n:");
for(int i=0;i<6;i++)
System.out.print(" "+array1[i]);
System.out.println();

for(int j=1;j<6;j++)
{
if((x2[j-1]+array1[j]) <=(y2[j-1]+time2[j-1]+array1[j]))
{
x2[j]=x2[j-1]+array1[j];x3[j]=1;
}
else
{
x2[j]=y2[j-1]+time2[j-1]+array1[j]; x3[j]=2;
}
if((y2[j-1]+array2[j])<=(x2[j-1]+time1[j-1]+array2[j]))
{
y2[j]=y2[j-1]+array2[j]; y3[j]=2;
}
else
{
y2[j]=x2[j-1]+time1[j-1]+array2[j];y3[j]=1;
}
}

if(x2[5]+x1 < y2[5]+y1)
{ 
f=x2[5]+x1;l=1;
}
else
{
f=y2[5]+y1;l=2;
}

System.out.print("Line1 Optimal time path:");
for(int i=1;i<6;i++)
System.out.print(x3[i]+ " ");
System.out.println();
System.out.print("Line2 Optimal time path:");
for(int i=1;i<6;i++)
System.out.print(y3[i]+ " ");

System.out.println();
System.out.println();
System.out.println("Optimal Time is: "+f);
System.out.println("Optimal line is: "+l);

System.out.println("\n\nOptimal Path For a car is:\n");
System.out.println("Line No:"+l+" and Station no is:"+6);
k=l;
for(int j=5;j>=1;j--)
{

if (k==1)
{
k=x3[j]; 
System.out.println("Line No: "+k+" and Station no is "+(j)+" ");
}
else
{
k=y3[j];
System.out.println("Line No: "+k+" and Station no is "+(j)+" ");
}
}
System.out.println();

}
}
