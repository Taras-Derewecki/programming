import java.io.*;
import java.util.*;
import java.math.BigDecimal;

public class Solution {

    public static int getIndex(int Y){

        switch(Y){
            case 4: return 0;
            case 6: return 1;
            case 8: return 2;
            case 10: return 3;
            case 20: return 5;
            default: break;
        }

        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();


        float[][][] probability = new float[21][6][401];
        for (int i = 0; i < probability.length; i++)
        {
            for (int j = 0; j < probability[i].length; j++)
            {
                Arrays.fill(probability[i][j], 0);
            }
        }

        int V[] = new int[]{4, 6, 8, 10, 12, 20};
        for(int X = 1; X <= 20; X++ ){
            for(int y = 0; y < 6; y++ ){
                int Y = V[y];
                BigDecimal[] oldArray = new BigDecimal[X*Y+1];
                BigDecimal[] newArray = new BigDecimal[X*Y+1];

                Arrays.fill(oldArray, BigDecimal.ZERO);
                Arrays.fill(newArray, BigDecimal.ZERO);

                for(int i=1;i<=Y;i++){
                    oldArray[i] = BigDecimal.ONE;
                }
                for(int runs=2;runs<=X;runs++){
                    for(int i=1;i<=X*Y;i++){
                        for(int j=1;j<=Y;j++){
                            if(i-j>0){
                                newArray[i] = newArray[i].add(oldArray[i-j]);
                            }
                        }
                    }
                    Arrays.fill(oldArray, BigDecimal.ZERO);
                    for(int i=1;i<=X*Y;i++){
                        oldArray[i] = oldArray[i].add(newArray[i]);
                    }
                    Arrays.fill(newArray, BigDecimal.ZERO);
                }
                int index = 2;
                if(index<=0){
                    int maxProb = 1;
                }
                else{
                    float total = 0;
                    float chances = 0;
                    BigDecimal bg1 = new BigDecimal("0");
                    BigDecimal bg2 = new BigDecimal("0");
                    BigDecimal bg3 = new BigDecimal("0");
                    for(int i=1;i<=X*Y;i++){
                        bg2 = bg2.add(oldArray[i]);
                        if(i>=index){
                            bg1 = bg1.add(oldArray[i]);
                        }
                    }

                    for(int i = X*Y-1; i>=1; i--){
                        oldArray[i] = oldArray[i].add(oldArray[i+1]);
                    }

                    BigDecimal denom = oldArray[1];
                    for(int i=1; i<=X*Y; i++){
                        oldArray[i] = oldArray[i].divide(denom, 6, BigDecimal.ROUND_HALF_UP);
                        float f = oldArray[i].floatValue();
                        probability[X][y][i] = f;
                    }

                    for(int i=1;i<=X*Y;i++){
                        bg3 = bg1.divide(bg2, 6, BigDecimal.ROUND_HALF_UP);
                    }

                }
            }
        }


        while(t-->0){
            int H = sc.nextInt() ,S = sc.nextInt();
            float maxProb = 0;
            while(S-->0){
                String Sp = sc.next();
                int X,Y,Z;
                if(Sp.contains("+") || Sp.contains("-")){
                    String[] parts = Sp.split("[+-]");
                    Z = Integer.parseInt(parts[1]);
                    String[] spell = parts[0].split("d");
                    X = Integer.parseInt(spell[0]);
                    Y = Integer.parseInt(spell[1]);
                    if(Sp.contains("-")){
                        Z = -1*Z;
                    }
                }
                else{
                    Z = 0;
                    String[] spell = Sp.split("d");
                    X = Integer.parseInt(spell[0]);
                    Y = Integer.parseInt(spell[1]);
                }
                if(H-Z<=0){
                    maxProb = 1;
                }
                else if(H-Z>400){
                    maxProb = Math.max(maxProb,0);
                }
                else{
                    maxProb = Math.max(maxProb,probability[X][getIndex(Y)][H-Z]);
                }

            }
            System.out.println(String.format("%.6f", maxProb));
        }
    }
}