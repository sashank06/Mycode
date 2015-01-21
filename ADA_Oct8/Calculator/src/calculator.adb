with Text_IO;
with Gnat.IO;
use Gnat.IO;
procedure Calculator is
   Operand: Character;
   Val: Integer := 0;
   InputVal: Integer;
begin
   loop
      Put(Val);
      New_Line;
      Put("Enter Operation(e for exit) ");
      loop
         Get(Operand);
         exit when Operand /= ' ';
      end loop;
      exit when Operand = 'e' or Operand = 'E';
      Get(InputVal);
      Text_IO.Skip_Line;
      case Operand is
         when '=' => Val:=InputVal;
         when '+' => Val:=Val + InputVal;
         when '-' => Val:=Val - InputVal;
         when '*' => Val:=Val * InputVal;
         when '/' => Val:=Val / InputVal;
         when '0'..'9' => Put_Line("What operation do you wanna perform ?");
         when others => Put_Line("Invalid Operand: " & Operand & " ");
      end case;
   end loop;
end Calculator;
