import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.io.*;

class Logo 
{
	JFrame fr;
	JLabel l1,l2,l3,x1,x2,x3;
	JTextField t1,st1;
	JPasswordField t2,st2;
	JButton b1,sb1;
	ActionListener listener,listener1;
	
	Logo() 
	{
		fr= new JFrame();
		fr.setContentPane(new JLabel(new ImageIcon("layout.png")));
		Font ff1=new Font("Arial",Font.BOLD,24);
			Font ff2=new Font("Georgia",Font.BOLD,30);
			Font ff3=new Font("Arial",Font.BOLD,17);
			
			l1=new JLabel("STAFF");
			l1.setFont(ff1);
			l2=new JLabel("UserName");
			l2.setForeground(Color.BLACK);
			l2.setFont(ff3);
			t1=new JTextField();
			t1.addActionListener(listener);
			l3=new JLabel("Password");
			l3.setForeground(Color.BLACK);
			l3.setFont(ff3);
			t2=new JPasswordField();
			t2.addActionListener(listener);
			
			b1=new JButton("Login");
			b1.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent ae)
				{
					
					int c=0;
					
					try
					{
						
						String user = t1.getText();
						System.out.println(user);
						char[] password =t2.getPassword();
						String str = new String(password);
						System.out.println(password);
						Scanner fil = new Scanner(new FileInputStream("staff.txt"));
						String st;
						while(fil.hasNextLine())
						{
							st=fil.nextLine();
							String[]sA = st.split(",");
							String u=sA[0];
							String p=sA[1];
							if(u.equals(user) && p.equals(str))
							{
					
								FileWriter myWriter = new FileWriter("staffname.txt");
								myWriter.write(user);
								myWriter.close();
									System.out.println(u);
									System.out.println(p);
									JFrame h;
			h=new JFrame();
			h.setContentPane(new JLabel(new ImageIcon("layout.png")));
			JLabel l0,l1;
			JButton bh0,bh1,bh2;
			Font fh1=new Font("Georgia",Font.BOLD,35);
			Font fh2=new Font("Sitka Display",Font.ITALIC,30);
			Font fh3=new Font("Arial",Font.BOLD,20);
			
			
			l1=new JLabel("Computer Science Engineering");
			l1.setForeground(Color.WHITE);
			l1.setFont(fh1);
			l1.setBounds(460,160,750,90);
			h.add(l1);
			bh0=new JButton("Update Student Performance");
			bh0.setFont(fh3);
			bh0.setBounds(400,300,470,50);
			h.add(bh0);
			bh1=new JButton("Get  the performance of the Students");
			bh1.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent ae)
				{
						JFrame h2;
					JLabel ch,ch1,ch2,ch3,chb,ct1,ct2,cta,ctotal,op,opc1,opc2,opc3,opcb,opt1,opt2,opa,opt;
					Font fh3=new Font("Arial",Font.BOLD,20);
					try
					{
						Scanner hfile= new Scanner(new FileInputStream("staffname.txt"));
						String su ;
						while(hfile.hasNextLine())
						{
							su=hfile.next();
							String []suArray=su.split(",");
							String name=suArray[0];
							String path=suArray[0]+".csv";
							System.out.println(path);
							Scanner hfile2=new Scanner(new FileInputStream(path));
							hfile2.useDelimiter(",");
							int c=0,z=0,c1=0,c2=0,c3=0,cb=0,t1=0,t2=0,a=0,t=0;
						
							while(hfile2.hasNext())
							{
						
								String []students=hfile2.nextLine().split(",");
								if(c!=0)
								{
									c1=Integer.parseInt(students[1])+c1;
									
									c2=Integer.parseInt(students[2])+c2;
									c3=Integer.parseInt(students[3])+c3;
									cb=Integer.parseInt(students[4])+cb;
								t1=Integer.parseInt(students[5])+t1;
							t2=Integer.parseInt(students[6])+t2;
									a=Integer.parseInt(students[7])+a;
									t=Integer.parseInt(students[8])+t;
									System.out.println(t);
									if (z==2)
									{
										
										double averagec1=((c1/z)*100)/(z*30);
									
										double averagec2=((c2/z)*100)/(z*30);
										double averagec3=((c3/z)*100)/(z*30);
										double averagecb=((cb/z)*100)/(z*30);
										double averaget1=((t1/z)*100)/(z*5);
										double averaget2=((t2/z)*100)/(z*5);
										double averagea=((a/z)*100)/(z*10);
										double averaget=((t/z)*100)/(z*50);
									
										h2=new JFrame();
						
						h2.setContentPane(new JLabel(new ImageIcon("layout.png")));
						ch1=new JLabel("Students performance on CA-1 : "+averagec1+"%");
						ch1.setFont(fh3);
						ch1.setBounds(300,280,750,60);
						ch2=new JLabel("Students performance on CA-2 : "+averagec2+"%");
						ch2.setFont(fh3);
						ch2.setBounds(300,310,750,60);
						ch3=new JLabel("Students performance on CA-3 : "+averagec3+"%");
						ch3.setFont(fh3);
						ch3.setBounds(300,340,750,60);
						chb=new JLabel("Students performance on CA-best : "+averagecb+"%");
						chb.setFont(fh3);
						chb.setBounds(300,370,750,60);
						ct1=new JLabel("Students performance on Tutorial-1 : "+averaget1+"%");
						ct1.setFont(fh3);
						ct1.setBounds(300,400,750,60);
						ct2=new JLabel("Students performance on Tutorial-2 : "+averaget2+"%");
						ct2.setFont(fh3);
						ct2.setBounds(300,430,750,60);
						cta=new JLabel("Students performance on Assingment : "+averagea+"%");
						cta.setFont(fh3);
						cta.setBounds(300,460,750,60);
						ctotal=new JLabel("Students performance on Total : "+averaget+"%");
						ctotal.setFont(fh3);
						ctotal.setBounds(300,490,750,60);
						
						h2.add(ch1);
						h2.add(ch2);
						h2.add(ch3);
						h2.add(chb);
						h2.add(ct1);
						h2.add(ct2);
						h2.add(cta);
						h2.add(ctotal);
						h2.setVisible(true);
						h.dispose();
						h2.setSize(720,1080);
					
									}
								z++;
								
								
									
								}
								
								c++;
						
					
							}
							
						
							
						}
					
					
						
						
						
						hfile.close();
				
					}catch (Exception e){System.out.println(e);}
						
				}
			});
			bh1.setFont(fh3);					
				
			bh1.setBounds(400,400,470,50);
			h.add(bh1);
			bh2=new JButton("Get the individual performance of the student");
			bh2.setBounds(400,500,470,50);
			bh2.setFont(fh3);
			h.add(bh2);
			
			
	
			
			
			h.setVisible(true);
			h.setSize(720,1080);
		
		
			
		h.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						
									fr.dispose();
									c=1;
									break;
								
							}
							else
							{
								c=0;
							}
						}
						fil.close();
					}catch(Exception e){System.out.println(e);}
				if(c==0){
					t1.setText("");
					t2.setText("");
					Option o = new Option();
					}
				}
				
			});
			x1=new JLabel("STUDENT");
			x1.setFont(ff1);
			x2=new JLabel("UserName");
			x2.setForeground(Color.BLACK);
			x2.setFont(ff3);
			st1=new JTextField();
			st1.addActionListener(listener1);
			x3=new JLabel("Password");
			x3.setForeground(Color.BLACK);
			x3.setFont(ff3);
			st2=new JPasswordField();
			st2.addActionListener(listener1);
			sb1=new JButton("Login");
			sb1.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent ae)
				{
					
					int c=0;
					
					try
					{
						
						String user1 = st1.getText();
						System.out.println(user1);
						char[] password1 =st2.getPassword();
						String str1 = new String(password1);
						System.out.println(password1);
						Scanner file = new Scanner(new FileInputStream("student.txt"));
						String sx1;
						while(file.hasNextLine())
						{
							sx1=file.nextLine();
							String[]s1Array = sx1.split(",");
							String us=s1Array[0];
							String pw=s1Array[1];
							if(us.equals(user1) && pw.equals(str1))
							{
					
									FileWriter myWriter = new FileWriter("studentname.txt");
								myWriter.write(user1);
								myWriter.close();
									System.out.println(us);
									System.out.println(pw);
									JFrame f;
		f=new JFrame();
			f.setContentPane(new JLabel(new ImageIcon("layout.png")));
			JLabel l0,l1;
			JButton b0,b1,b2;
			Font f1=new Font("Georgia",Font.BOLD,35);
			Font f2=new Font("Sitka Display",Font.ITALIC,30);
			Font f3=new Font("Arial",Font.BOLD,20);
			
			
			l1=new JLabel("Computer Science Engineering");
			l1.setForeground(Color.WHITE);
			l1.setFont(f1);
			l1.setBounds(300,300,750,90);
			f.add(l1);
			b0=new JButton("View your Performance");
			b0.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent ae)
				{
				JFrame f1;
		JLabel la,ds,da,ca,oop,eco,col,dal,oopl,lca1,lca2,lca3,lcat,lt1,lt2,lna,ltotal,caca1,caca2,caca3,cacat,cat1,cat2,caa,catotal,dsca1,dsca2,dsca3,dscat,dst1,dst2,dsa,dstotal;
		JLabel daca1,daca2,daca3,dacat,dat1,dat2,daa,datotal,oopca1,oopca2,oopca3,oopcat,oopt1,oopt2,oopa,ooptotal,ecoca1,ecoca2,ecoca3,ecocat,ecot1,ecot2,ecoa,ecototal;
		JLabel dalr1,dalr2,dalt1,dalt2,daltotal,ooplr1,ooplr2,ooplt1,ooplt2,oopltotal;
		f1=new JFrame();
		f1.setContentPane(new JLabel(new ImageIcon("student.png")));
		la=new JLabel("LINEAR ALGEBRA");
	la.setForeground(Color.red);
	la.setBounds(270,170,200,100);
	ca=new JLabel("COMPUTER ARCHITECTURE");
	ca.setForeground(Color.red);
	ca.setBounds(270,220,200,100);
	ds=new JLabel("DISCRETE STRUCTURES");
	ds.setForeground(Color.red);
	ds.setBounds(270,280,200,100);
	da=new JLabel("DATA STRUCTURES");
	da.setForeground(Color.red);
	da.setBounds(270,340,200,100);
	oop=new JLabel("<html>OBJECT ORIENTED <br> PROGRAMMING</html>");
	try
	{
	Scanner in = new Scanner(new FileInputStream("studentname.txt"));
						String s1;
					Scanner in1 = new Scanner(new FileInputStream("linear.csv"));
					in1.useDelimiter(",");
						String s2;	
					Scanner in2 = new Scanner(new FileInputStream("computer.csv"));
					in2.useDelimiter(",");
					String s3;
					Scanner in3 = new Scanner(new FileInputStream("discrete.csv"));
					in3.useDelimiter(",");
					String s4;
					Scanner in4 = new Scanner(new FileInputStream("data.csv"));
					in4.useDelimiter(",");
					String s5;
					Scanner in5 = new Scanner(new FileInputStream("oop.csv"));
					in5.useDelimiter(",");
					String s6;
					Scanner in6 = new Scanner(new FileInputStream("economics.csv"));
					in6.useDelimiter(",");
					String s7;
					Scanner in7 = new Scanner(new FileInputStream("datalab.csv"));
					in7.useDelimiter(",");
					String s8;
					Scanner in8 = new Scanner(new FileInputStream("ooplab.csv"));
					in8.useDelimiter(",");
					String s9;
						while(in.hasNextLine())
						{
							s1=in.nextLine();
							String[]sArray = s1.split(",");
							String u1=sArray[0];
							while(in1.hasNext())
							{
							s2=in1.nextLine();
							String[]s1Array = s2.split(",");
							String u2=s1Array[0];
							System.out.println(u1+" "+u2);
							if (u1.equals(u2))
						
								{
									lca1=new JLabel(s1Array[1]);
									
									lca1.setForeground(Color.red);
									lca1.setBounds(470,210,40,20);
									lca2=new JLabel(s1Array[2]);
									
									lca2.setForeground(Color.red);
									lca2.setBounds(550,210,40,20);
									lca3=new JLabel(s1Array[3]);
									
									lca3.setForeground(Color.red);
									lca3.setBounds(650,210,40,20);
									lcat=new JLabel(s1Array[4]);
									
									lcat.setForeground(Color.red);
									lcat.setBounds(760,210,40,20);
									lt1=new JLabel(s1Array[5]);
									
									lt1.setForeground(Color.red);
									lt1.setBounds(860,210,40,20);
									lt2=new JLabel(s1Array[6]);
									
									lt2.setForeground(Color.red);
									lt2.setBounds(960,210,40,20);
									lna=new JLabel(s1Array[7]);
									
									lna.setForeground(Color.red);
									lna.setBounds(1080,210,40,20);
									ltotal=new JLabel(s1Array[8]);
									
									ltotal.setForeground(Color.red);
									ltotal.setBounds(1220,210,40,20);
									f1.add(lca1);
									f1.add(lca2);
									f1.add(lca3);
									f1.add(lcat);
									f1.add(lt1);
									f1.add(lt2);
									f1.add(lna);
									f1.add(ltotal);
									
									
								}
								while(in2.hasNext())
							{
							s3=in2.nextLine();
							String[]s2Array = s3.split(",");
							String u3=s2Array[0];
							
							if (u1.equals(u3))
						
								{
									caca1=new JLabel(s2Array[1]);
									
									caca1.setForeground(Color.red);
									caca1.setBounds(470,260,40,20);
									caca2=new JLabel(s2Array[2]);
									
									caca2.setForeground(Color.red);
									caca2.setBounds(550,260,40,20);
									caca3=new JLabel(s2Array[3]);
									
									caca3.setForeground(Color.red);
									caca3.setBounds(650,260,40,20);
									cacat=new JLabel(s2Array[4]);
									
									cacat.setForeground(Color.red);
									cacat.setBounds(760,260,40,20);
									cat1=new JLabel(s2Array[5]);
									
									cat1.setForeground(Color.red);
									cat1.setBounds(860,260,40,20);
									cat2=new JLabel(s2Array[6]);
									
									cat2.setForeground(Color.red);
									cat2.setBounds(960,260,40,20);
									caa=new JLabel(s2Array[7]);
									
									caa.setForeground(Color.red);
									caa.setBounds(1080,260,40,20);
									catotal=new JLabel(s2Array[8]);
									
									catotal.setForeground(Color.red);
									catotal.setBounds(1220,260,40,20);
									f1.add(caca1);
									f1.add(caca2);
									f1.add(caca3);
									f1.add(cacat);
									f1.add(cat1);
									f1.add(cat2);
									f1.add(caa);
									f1.add(catotal);
									
									
								}
							}
						}
						while(in3.hasNext())
							{
							s4=in3.nextLine();
							String[]s3Array = s4.split(",");
							String u4=s3Array[0];
							
							if (u1.equals(u4))
						
								{
									dsca1=new JLabel(s3Array[1]);
									
									dsca1.setForeground(Color.red);
									dsca1.setBounds(470,320,40,20);
									dsca2=new JLabel(s3Array[2]);
									
									dsca2.setForeground(Color.red);
									dsca2.setBounds(550,320,40,20);
									dsca3=new JLabel(s3Array[3]);
									
									dsca3.setForeground(Color.red);
									dsca3.setBounds(650,320,40,20);
									
									dscat=new JLabel(s3Array[4]);
									
									dscat.setForeground(Color.red);
									dscat.setBounds(760,320,40,20);
									dst1=new JLabel(s3Array[5]);
									
									dst1.setForeground(Color.red);
									dst1.setBounds(860,320,40,20);
									dst2=new JLabel(s3Array[6]);
									
									dst2.setForeground(Color.red);
									dst2.setBounds(960,320,40,20);
									dsa=new JLabel(s3Array[7]);
									
									dsa.setForeground(Color.red);
									dsa.setBounds(1080,320,40,20);
									dstotal=new JLabel(s3Array[8]);
									
									dstotal.setForeground(Color.red);
									dstotal.setBounds(1220,320,40,20);
									f1.add(dsca1);
									f1.add(dsca2);
									f1.add(dsca3);
									f1.add(dscat);
									f1.add(dst1);
									f1.add(dst2);
									f1.add(dsa);
									f1.add(dstotal);
									
									
								}
								while(in4.hasNext())
							{
							s5=in4.nextLine();
							String[]s4Array = s5.split(",");
							String u5=s4Array[0];
							
							if (u1.equals(u5))
						
								{
									daca1=new JLabel(s4Array[1]);
									
									daca1.setForeground(Color.red);
									daca1.setBounds(470,380,40,20);
									daca2=new JLabel(s4Array[2]);
									
									daca2.setForeground(Color.red);
									daca2.setBounds(550,380,40,20);
									daca3=new JLabel(s4Array[3]);
									
									daca3.setForeground(Color.red);
									daca3.setBounds(650,380,40,20);
									dacat=new JLabel(s4Array[4]);
									
									dacat.setForeground(Color.red);
									dacat.setBounds(760,380,40,20);
									dat1=new JLabel(s4Array[5]);
									
									dat1.setForeground(Color.red);
									dat1.setBounds(860,380,40,20);
									dat2=new JLabel(s4Array[6]);
									
									dat2.setForeground(Color.red);
									dat2.setBounds(960,380,40,20);
									daa=new JLabel(s4Array[7]);
									
									daa.setForeground(Color.red);
									daa.setBounds(1080,380,40,20);
									datotal=new JLabel(s4Array[8]);
									
									datotal.setForeground(Color.red);
									datotal.setBounds(1220,380,40,20);
									f1.add(daca1);
									f1.add(daca2);
									f1.add(daca3);
									f1.add(dacat);
									f1.add(dat1);
									f1.add(dat2);
									f1.add(daa);
									f1.add(datotal);
									
									
								}
							}
						}
						while(in5.hasNext())
							{
							s6=in5.nextLine();
							String[]s5Array = s6.split(",");
							String u6=s5Array[0];
							
							if (u1.equals(u6))
						
								{
									oopca1=new JLabel(s5Array[1]);
									
									oopca1.setForeground(Color.red);
									oopca1.setBounds(470,420,40,20);
									oopca2=new JLabel(s5Array[2]);
									
									oopca2.setForeground(Color.red);
									oopca2.setBounds(550,420,40,20);
									oopca3=new JLabel(s5Array[3]);
									
									oopca3.setForeground(Color.red);
									oopca3.setBounds(650,420,40,20);
									oopcat=new JLabel(s5Array[4]);
									
									oopcat.setForeground(Color.red);
									oopcat.setBounds(760,420,40,20);
									oopt1=new JLabel(s5Array[5]);
									
									oopt1.setForeground(Color.red);
									oopt1.setBounds(860,420,40,20);
									oopt2=new JLabel(s5Array[6]);
									
									oopt2.setForeground(Color.red);
									oopt2.setBounds(960,420,40,20);
									oopa=new JLabel(s5Array[7]);
									
									oopa.setForeground(Color.red);
									oopa.setBounds(1080,420,40,20);
									ooptotal=new JLabel(s5Array[8]);
									
									ooptotal.setForeground(Color.red);
									ooptotal.setBounds(1220,420,40,20);
									f1.add(oopca1);
									f1.add(oopca2);
									f1.add(oopca3);
									f1.add(oopcat);
									f1.add(oopt1);
									f1.add(oopt2);
									f1.add(oopa);
									f1.add(ooptotal);
									
									
								}
							}
								while(in6.hasNext())
							{
							s7=in6.nextLine();
							String[]s6Array = s7.split(",");
							String u7=s6Array[0];
							
							if (u1.equals(u7))
						
								{
									ecoca1=new JLabel(s6Array[1]);
									
									ecoca1.setForeground(Color.red);
									ecoca1.setBounds(470,470,40,20);
									ecoca2=new JLabel(s6Array[2]);
									
									ecoca2.setForeground(Color.red);
									ecoca2.setBounds(550,470,40,20);
									ecoca3=new JLabel(s6Array[3]);
									
									ecoca3.setForeground(Color.red);
									ecoca3.setBounds(650,470,40,20);
									ecocat=new JLabel(s6Array[4]);
									
									ecocat.setForeground(Color.red);
									ecocat.setBounds(760,470,40,20);
									ecot1=new JLabel(s6Array[5]);
									
									ecot1.setForeground(Color.red);
									ecot1.setBounds(860,470,40,20);
									ecot2=new JLabel(s6Array[6]);
									
									ecot2.setForeground(Color.red);
									ecot2.setBounds(960,470,40,20);
									ecoa=new JLabel(s6Array[7]);
									
									ecoa.setForeground(Color.red);
									ecoa.setBounds(1080,470,40,20);
									ecototal=new JLabel(s6Array[8]);
									
									ecototal.setForeground(Color.red);
									ecototal.setBounds(1220,470,40,20);
									f1.add(ecoca1);
									f1.add(ecoca2);
									f1.add(ecoca3);
									f1.add(ecocat);
									f1.add(ecot1);
									f1.add(ecot2);
									f1.add(ecoa);
									f1.add(ecototal);
									
									
								}
							}
						
						while(in7.hasNext())
							{
							s8=in7.nextLine();
							String[]s7Array = s8.split(",");
							String u8=s7Array[0];
							
							if (u1.equals(u8))
						
								{
									dalr1=new JLabel(s7Array[1]);
									dalr1.setForeground(Color.red);
									dalr1.setBounds(520,620,40,20);
									dalr2=new JLabel(s7Array[2]);
									dalr2.setForeground(Color.red);
									dalr2.setBounds(680,620,40,20);
									dalt1=new JLabel(s7Array[3]);
									dalt1.setForeground(Color.red);
									dalt1.setBounds(880,620,40,20);
									dalt2=new JLabel(s7Array[4]);
									dalt2.setForeground(Color.red);
									dalt2.setBounds(1020,620,40,20);
									daltotal=new JLabel(s7Array[5]);
									daltotal.setForeground(Color.red);
									daltotal.setBounds(1180,620,40,20);
									f1.add(dalr1);
									f1.add(dalr2);
									f1.add(dalt1);
									f1.add(dalt2);
									f1.add(daltotal);
								}
							}
							while(in8.hasNext())
							{
							s9=in8.nextLine();
							String[]s8Array = s9.split(",");
							String u9=s8Array[0];
							
							if (u1.equals(u9))
						
								{
									ooplr1=new JLabel(s8Array[1]);
									ooplr1.setForeground(Color.red);
									ooplr1.setBounds(520,670,40,20);
									ooplr2=new JLabel(s8Array[2]);
									ooplr2.setForeground(Color.red);
									ooplr2.setBounds(680,670,40,20);
									ooplt1=new JLabel(s8Array[3]);
									ooplt1.setForeground(Color.red);
									ooplt1.setBounds(880,670,40,20);
									ooplt2=new JLabel(s8Array[4]);
									ooplt2.setForeground(Color.red);
									ooplt2.setBounds(1020,670,40,20);
									oopltotal=new JLabel(s8Array[5]);
									oopltotal.setForeground(Color.red);
									oopltotal.setBounds(1180,670,40,20);
									f1.add(ooplr1);
									f1.add(ooplr2);
									f1.add(ooplt1);
									f1.add(ooplt2);
									f1.add(oopltotal);
								}
							}
							u1=null;
						}
						in.close();
						in1.close();
						in2.close();
						in3.close();
						in4.close();
						in5.close();
						in6.close();
						in7.close();
						in8.close();
	
	
		
						
		
	}catch (Exception e) {System.out.println(e);}
	oop.setForeground(Color.red);
	oop.setBounds(270,380,220,100);
	eco=new JLabel("ECONOMICS");
	eco.setForeground(Color.red);
	eco.setBounds(270,430,200,100);
	dal=new JLabel("DATA STRUCTURES LABORATORY");
	dal.setForeground(Color.red);
	dal.setBounds(270,580,220,100);
	oopl=new JLabel("<html>OBJECT ORIENTED <br> PROGRAMMING LABORATORY</html>");
	oopl.setForeground(Color.red);
	oopl.setBounds(270,620,220,110);
	
	
	f1.add(la);
	f1.add(ca);
	f1.add(ds);
	f1.add(da);
	f1.add(oop);
	f1.add(eco);
	f1.add(dal);
	f1.add(oopl);

		f1.setVisible(true);
		f1.setSize(720,1080);
								
									f.dispose();
		

				
				}
			});
			b0.setFont(f3);
			b0.setBounds(400,400,470,50);
			b0.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 5));
			b0.setBackground( Color.PINK);
			f.add(b0);
			
			
			
			f.setLayout(null);
			
			
			f.setVisible(true);
			f.setSize(720,1080);
			f.setLocationRelativeTo(null);
			b0.setBackground( Color.WHITE);
			
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			fr.dispose();
									c=1;
									break;
								
							}
							else
							{
								c=0;
							}
						}
						file.close();
					}catch(Exception e){System.out.println(e);}
				if(c==0){
					st1.setText("");
					st2.setText("");
					Option o = new Option();
					}
				}
			});
			l1.setBounds(300,300,200,40);
			l2.setBounds(280,350,100,20);
			t1.setBounds(280,380,200,30);
			l3.setBounds(280,430,100,20);
			t2.setBounds(280,460,200,30); 
			b1.setBounds(280,525,200,30); 
			x1.setBounds(800,300,200,40);
			x2.setBounds(780,350,100,20);
			st1.setBounds(780,380,200,30);
			x3.setBounds(780,430,100,20);
			st2.setBounds(780,460,200,30); 
			sb1.setBounds(780,525,200,30); 
			
			fr.add(l1);
			fr.add(l2);
			fr.add(t1);
			fr.add(l3);
			fr.add(t2);
			fr.add(b1);
		fr.add(x1);
			fr.add(x2);
			fr.add(st1);
			fr.add(x3);
			fr.add(st2);
			fr.add(sb1);
			
		
		
	
		
		fr.setVisible(true);
		fr.setSize(720,1080);
		
	}
	
	
	
	public static void main(String[]args)
	{
		Logo f = new Logo();
	}
}