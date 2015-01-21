with Text_IO;
use Text_IO;
with Ada.Strings.Unbounded;
use Ada.Strings.Unbounded;
with Ada.Text_IO;
use Ada.Text_IO;
procedure LinkedList is

   Ch : Character;
   type Instuctors;
   type Poi_Instuctors is access Instuctors;
   type Instuctors is record
      Name : Unbounded_String;
      Next : Poi_Instuctors;
   end record;

   type Students;
   type Poi_Students  is access Students;
   type Students is record
      Name : Unbounded_String;
      Next : Poi_Students;
      Instuctors :  Poi_Instuctors;
   end record;

   type Courses;
   type Poi_Courses is access Courses;
   type Courses is record
      Name : Unbounded_String;
      Next : Poi_Courses;
      Students :  Poi_Students;
   end record;

   I : Poi_Instuctors;
   S : Poi_Students;
   C : Poi_Courses;

   Intstructor_Name : Unbounded_String;
   Student_Name : Unbounded_String;
   Courses_Name :Unbounded_String;
begin

   Put_Line("The following data has been inserted into a Linked list");
   New_Line;
   Intstructor_Name := To_Unbounded_String("Ramky");
   I :=new Instuctors'(Intstructor_Name, I);
   Intstructor_Name := To_Unbounded_String("Singam");
   I :=new Instuctors'(Intstructor_Name, I);
   Intstructor_Name := To_Unbounded_String("Raghu");
   I :=new Instuctors'(Intstructor_Name, I);

   Student_Name := To_Unbounded_String("Samba");
   S :=new Students'(Student_Name, S,I);
  --------------------------------------------------------

   Intstructor_Name := To_Unbounded_String("Venkat");
   I :=new Instuctors'(Intstructor_Name, I);
   Intstructor_Name := To_Unbounded_String("Bhanu");
   I :=new Instuctors'(Intstructor_Name, I);
   Intstructor_Name := To_Unbounded_String("Anil");
   I :=new Instuctors'(Intstructor_Name, I);

   Student_Name := To_Unbounded_String("Prashanth");
   S :=new Students'(Student_Name, S,I);

   Courses_Name := To_Unbounded_String("SOPL");
   C:= new Courses'(Courses_Name, C ,S);
   --------------------------------------------------------
   Put_Line("Start");
   Put_Line(To_String(C.Name));
   New_Line;
   Put_Line(To_String(C.Students.Name));
   New_Line;
   Put_Line(To_String(C.Students.Instuctors.Name));
   New_Line;
   Put_Line(To_String(C.Students.Instuctors.Next.Name));
   New_Line;
   Put_Line(To_String(C.Students.Instuctors.Next.Next.Name));
   New_Line;
   Put_Line(To_String(C.Students.Next.Name));
   New_Line;
   Put_Line(To_String(C.Students.Next.Instuctors.Name));
   New_Line;
   Put_Line(To_String(C.Students.Next.Instuctors.Next.Name));
   New_Line;
   Put_Line(To_String(C.Students.Next.Instuctors.Next.Next.Name));
   Get(Ch);
end LinkedList;
