public class airplaneSeating {
   public static void main(String[] args) {
   char[][] airplane = new char[7][4];
   MenuSystem.displayMenu(" ");

   char choice=MenuSystem.presentMenuResponse();
   
   int scChoicemenu=MenuSystem.presentMenuResponse2("scChoicemenu", 0);
	if (scChoicemenu == 1) {
	MenuSystem.displayTicketTypeMenu();
		MenuSystem.presentMenuResponse();

}
  
int rwChoicemenu=MenuSystem.presentMenuResponse3("rwChoicemenu",0);
  
if (rwChoicemenu == 1)
MenuSystem.presentMenuResponse();
  
  
  
String cwChoicemenu=MenuSystem.presentMenuResponse4("cwChoicemenu","1"); 
{
	if (cwChoicemenu.equals("1"))
	{
		MenuSystem.displayTicketTypeMenu();
		MenuSystem.presentMenuResponse();
	}

  }
 }
}

