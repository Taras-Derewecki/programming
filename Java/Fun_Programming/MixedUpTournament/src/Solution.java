/**
 * Created by Taras on 3/8/2017.
 */

import java.util.*;

/**************************************************************************************************************************

Charles is in charge of running a single elimination tournament. In such a tournament, teams play until they lose a game.
Charles had a stack of paper, each sheet containing the results of a game in this tournament.
During the tournament, after every team had played at least one game, he was walking down the hallway,
when he tripped and chucked the stack of results all over the place.
Since the papers were completely scattered, he needs your help figuring out which teams are still in the tournament.

Input Format:
    The input to the program is a list of game results in the following format:
        Team1 Score1 Team2 Score2

        Where:

           - Team1 is the away team's name

           - Score1 is the away team's score

           - Team2 is the home team's name

           - Score2 is the home team's score

Constraints:

   - The scores will be integers greater than 0 and less than 200.

   - The team names will be alphabetic strings containing no spaces.

   - No games resulted in a tie.

Output Format:
    The output of the program is a list of the undefeated teams in alphabetical order, with one team per line.

Sample Input 0:
    Chargers 87 Doves 70
    Giants 3 Heat 1
    Bucks 98 Lions 67
    Avalanche 10 Bucks 20
    Chargers 27 Oilers 14
    Islanders 60 Jaguars 15
    Kings 17 Lakers 27
    Giants 3 Lakers 1
    Islanders 15 Flyers 27
    Panthers 2 Flyers 4
    Lions 104 Magic 98
    Nationals 8 Oilers 15


Sample Output 0:
    Bucks
    Chargers
    Flyers
    Giants

**************************************************************************************************************************/

public class Solution
{
    public static void main(String[] args)
    {
        Set<String> winners = new TreeSet<>();
        Set<String> losers = new HashSet<>();
        Scanner scan = new Scanner(System.in);

        while (scan.hasNext())
        {
            String team1 = scan.next();
            if(team1.equals("stop")) break; // This is because the IDE doesn't break on its own... normally don't do this...
            Integer score1 = scan.nextInt();
            String team2 = scan.next();
            Integer score2 = scan.nextInt();

            if (score1 > score2)
            {
                winners.add(team1);
                losers.add(team2);
            }

            if (score2 > score1)
            {
                winners.add(team2);
                losers.add(team1);
            }

            if(losers.contains(team1) && winners.contains(team1)) {winners.remove(team1);}
            if(losers.contains(team2) && winners.contains(team2)) {winners.remove(team2);}
        }

        for(String winner : winners) {System.out.println(winner);}
    }
}