import java.util.*;

class CustomisedDBMS
{
    public static void main(String Arg[])
    {
        DBMS dobj = new DBMS();

        dobj.StartDBMS();
    }
}

class Student
{
    public String Sname;
    public int Marks;
    public int Rollno;

    public static int Generator;

    static
    {
        Generator = 0;
    }

    public Student(String str, int no)
    {
        this.Sname = str;
        this.Marks = no;
        Generator++;
        this.Rollno = Generator;
    }

    public void Display()
    {
        System.out.println("Roll No : "+Rollno+" Name : "+Sname+" Marks : "+Marks);
    } 
}

class DBMS
{
    public LinkedList <Student> lobj;

    public DBMS()
    {
        lobj = new LinkedList();
    }

    public void StartDBMS()
    {
        System.out.println("Marvellous Customised DBMS started succesfully...");

        Scanner sobj = new Scanner(System.in);
        String Query = " ";
        int QuerySize = 0;
        
        while(true)
        {
            System.out.print("Marvellous DBMS : > ");
            Query = sobj.nextLine();

            String Tokens[] = Query.split(" ");
            QuerySize = Tokens.length;

            if(QuerySize == 1)
            {
                if("help".equals(Tokens[0]))
                {
                    System.out.println("This application is used to demonstrate the fetures of customiesed dbms.");
                    System.out.println("Display all data : select * from student");
                    System.out.println("Insert new recored : insert into student values Name marks");
                    System.out.println("Display specific using RollNo : select * from student where Rollno = value");
                    System.out.println("Display specific between Marks : select * from student where Marks between value1 and value2");
                    System.out.println("Display specific using Name : select * from student where Name = value");
                    System.out.println("Display specific two Name's : select * from student where Name between value1 and value2");
                    System.out.println("Summation of all the marks : select sum from student marks");
                    System.out.println("Average of all the marks : select avg from student marks");
                    System.out.println("Maximum marks : select max from student marks");
                    System.out.println("Minimum marks : select min from student marks");
                    System.out.println("Terminate the project : exit");
                    // Add more 
                }
                else if("exit".equals(Tokens[0]))
                {
                    System.out.println("Thank you for using our customised DBMS.");
                    break;
                }
            }
            else if(QuerySize == 2)
            {

            }
            else if(QuerySize == 3)
            {

            }
            else if(QuerySize == 4)
            {
                if("select".equals(Tokens[0]))
                {
                    if("*".equals(Tokens[1]))
                    {
                       DisplayAll(); 
                    }
                }
            }
            else if(QuerySize == 5)
            {
                if("select".equals(Tokens[0]))
                {
                    if("sum".equals(Tokens[1]))
                    {
                        Sum();
                    }
                    else if("avg".equals(Tokens[1]))
                    {
                        Avg();
                    }
                    else if("max".equals(Tokens[1]))
                    {
                        Max();
                    }
                    else if("min".equals(Tokens[1]))
                    {
                        Min();
                    }
                }
            }
            else if(QuerySize == 6)
            {
                if("insert".equals(Tokens[0]))
                {
                    if("student".equals(Tokens[2]))
                    {
                       Insert(Tokens[4],Integer.parseInt(Tokens[5])); 
                    }
                }
            }
            else if(QuerySize == 7)
            {
                if("delete".equals(Tokens[0]))
                {
                    if("Name".equals(Tokens[4]))
                    {
                        Delete(Tokens[6]);
                    }
                }
                if("delete".equals(Tokens[0]))
                {
                    if("Rollno".equals(Tokens[4]))
                    {
                        Delete(Integer.parseInt(Tokens[6]));
                    } 
                }
            }
            /*else if(QuerySize == 7)
            {
                if("delete".equals(Tokens[0]))
                {
                    if("Rollno".equals(Tokens[4]))
                    {
                        Delete(Tokens[6]);
                    }
                }
            }*/
            else if(QuerySize == 8)
            {
                if("select".equals(Tokens[0]))
                {
                    if("Marks".equals(Tokens[5]))
                        {
                            CountSpecific(Integer.parseInt(Tokens[7]));;
                        }
                    else if("Rollno".equals(Tokens[5]))
                    {
                        DisplaySpecific(Integer.parseInt(Tokens[7]));
                    }
                    else if("count".equals(Tokens[1]))
                    {
                        if("Name".equals(Tokens[5]))
                        {
                            CountSpecific(Tokens[7]);
                        }
                    }
                    else if("Name".equals(Tokens[5]))
                    {
                        DisplaySpecific(Tokens[7]);
                    }
                }
            }
            else if(QuerySize == 10)
            {
                if("select".equals(Tokens[0]))
                {
                    if("Marks".equals(Tokens[5]))
                    {
                        DisplaySpecific(Integer.parseInt(Tokens[7]), Integer.parseInt(Tokens[9]));
                    }
                    else  if("Name".equals(Tokens[5]))
                    {
                        DisplaySpecific(Tokens[7], Tokens[9]);
                    }
                }
            }
        }// end of wjhile
    }// End of start DBMS

    // All SQL queries should be implemented here

    // insert into student values(_____, _____);
    public void Insert(String str, int no)
    {
        Student sobj = new Student(str,no);
        lobj.add(sobj);
    }

    // select * from student;
    public void DisplayAll()
    {
        for(Student sref : lobj)
        {
            sref.Display();
        }
    } 

    // Select * from stundet where Rollno = 3
    public void DisplaySpecific(int Value)
    {
        for(Student sref : lobj)
        {
            if(sref.Rollno == Value)
            {
                sref.Display();
                break;
            }
        }
    }

    // select * from student where Marks between 70 and 100
    public void DisplaySpecific(int Value1, int Value2)
    {
        for(Student sref : lobj)
        {
            if((sref.Marks >= Value1) && (sref.Marks <= Value2))
            {
                sref.Display();
            }
        }
    }

    // Select * from student where Name = 'Rutuja';
    public void DisplaySpecific(String str)
    {
        for(Student sref : lobj)
        {
            if(str.equals(sref.Sname))
            {
                sref.Display();
                break;
            }
        }
    }

    // select * from student where Name = Arya and Manu
    public void DisplaySpecific(String str1, String str2)
    {
        for(Student sref : lobj)
        {
            if((str1.equals(sref.Sname)) || (str2.equals(sref.Sname)))
            {
                sref.Display();
            }
        }
    }

    // delete from student where Rollno = 3;
    public void Delete(int no)
    {
        int index = 0;

        for(Student sref : lobj)
        {
            if(sref.Rollno == no)
            {
                lobj.remove(index);
                break;
            }
            index++;
        }
    }

    // delete from student where Sname = 'Ram';
    public void Delete(String str)
    {
        int index = 0;

        for(Student sref : lobj)
        {
            if(str.equals(sref.Sname))
            {
                lobj.remove(index);
                break;
            }
            index++;
        }
    }
    
    //select sum from student marks
    public void Sum()
    {
        int iSum = 0;

        for(Student sref : lobj)
        {
            iSum = iSum + (sref.Marks);
        }

        System.out.println("Summation of marks : "+iSum);
    }

    //select avg from student marks
    public void Avg()
    {
        int iSum = 0;

        for(Student sref : lobj)
        {
            iSum = iSum + (sref.Marks);
        }

        System.out.println("Average of marks : "+(iSum / lobj.size()));
    }

    //select max from student marks
    public void Max()
    {
        int iMax = 0;

        for(Student sref : lobj)
        {
            if(iMax < sref.Marks)
            {
                iMax = sref.Marks;
            }
        }

        System.out.println("Maximum marks are : "+iMax);
    }
    // select min from student marks
    public void Min()
    {
        Student s = lobj.get(0);

        int iMin = s.Marks;

        for(Student sref : lobj)
        {
            if(iMin > sref.Marks)
            {
                iMin = sref.Marks;
            }
        }

        System.out.println("Minimum marks are : "+iMin);
    }

    public void CountSpecific(int no)
    {
        int iCnt = 0;

        for(Student sref : lobj)
        {
            if(sref.Marks == no)
            {
                iCnt++;
            }
        }
        System.out.println("No of students with same Marks are : "+iCnt);
    }

    public void CountSpecific(String str)
    {
        int iCnt = 0;

        for(Student sref : lobj)
        {
            if(str.equals(sref.Sname))
            {
                iCnt++;
            }
        }
        System.out.println("No of students with same name are : "+iCnt);
    }

    
}

