/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projekt_1;
import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author arvid.oscarsson
 */
public class Projekt_1 {

    static int[][] fotsoldat = {{100, 15, 25, 15, 1, 2, 0}, 
                                {0,   0,  0,  0,  0, 0, 1}};
    
    static int[][] riddare = {{150, 20, 15, 30, 1, 3, 0}, 
                              {0,   0,  0,  0,  0, 0, 1}};
    
    static int[][] trolkar = {{75, 20, 35, 10, 1, 4, 0}, 
                              {0,   0,  0,  0,  0, 0, 1}};
    
    static int[][] vit_trolkar = {{60, 30, 15, 10, 1, 5, 6}, 
                                  {0,  0,  0,  0,  0, 0, 1}};
    
    static int[][] tom = {{0,0,0,0,0,0,0},{0,0,0,0,0,0,0}};
    
    
    static int[][] sol1 = new int[7][2];
    static int[][] sol2 = new int[7][2];
    static int[][] sol3 = new int[7][2];
    static int[][] sol4 = new int[7][2];
    static int[][] fien1 = new int[7][2];
    static int[][] fien2 = new int[7][2];
    static int[][] fien3 = new int[7][2];
    static int[][] fien4 = new int[7][2];
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner look = new Scanner(System.in);
        Random rand = new Random();
        
        int antal;
        
        do{
            System.out.println();
            try{
                System.out.print("Hur stor strid vill du ha?\n"
                               + "1: 1v1\n"
                               + "2: 2v2\n"
                               + "3: 3v3\n"
                               + "4: 4v4\n"
                               + "dit val: ");
                antal = look.nextInt();
            
            }catch(Exception e){
                System.out.println("Du måste skriva en sifra");
                look.nextLine();
                continue;
            }
            
            if(antal<=4&&antal>=1){
                break;
            }
            
            System.out.println("Inte ett giltigt val");
        }while(true);
        
        spelarVal(1,true);
        
        sol2 = tom;
        sol3 = tom;
        sol4 = tom;
        
        if(antal>=2){
            spelarVal(2,true);
            if(antal>=3){
                spelarVal(3,true);
                if(antal==4){
                    spelarVal(4,true);
                }
            }
        }
        
        look.nextLine();
        String val1;
        
        do{
            System.out.print("\nVill du välga dinna motståndare y/n : ");
            val1 = look.nextLine();
            
            if(!(val1.equals("y")||val1.equals("n"))){
                System.out.print("ogiltigt svar");
                continue;
            }
            
            break;
            
        }while(true);
        
        if(val1.equals("Y")){
            
            spelarVal(1,false);
            
            fien2 = tom;
            fien3 = tom;
            fien4 = tom;
            
            if(antal>=2){
                spelarVal(2,false);
                if(antal>=3){
                    spelarVal(3,false);
                    if(antal==4){
                        spelarVal(4,false);
                    }
                }
            }
          
        }else{
            //datorn slumpar motståndare
            String val2;
            do{
                System.out.print("\nVill du ha förbestämda fiender y/n : ");
                val2 = look.nextLine();
                
                if(!(val2.equals("y")||val2.equals("n"))){
                    System.out.println("ogiltigt svar");
                    continue;
                }
                
                break;
                
            }while(true);
            
            if(val2.equals("y")){
                
                datorVal(1);
                
                fien2 = tom;
                fien3 = tom;
                fien4 = tom;
                
                if(antal>=2){
                    datorVal(2);
                    if(antal>=3){
                        datorVal(3);
                        if(antal==4){
                            datorVal(4);
                        }
                    }
                }
                
            }else{
               fien1 = datorSlump(); 
               
               fien2 = tom;
               fien3 = tom;
               fien4 = tom;
               
               if(antal>=2){
                    fien2 = datorSlump();
                    if(antal>=3){
                        fien3 = datorSlump();
                        if(antal==4){
                            fien3 = datorSlump();
                        }
                    }
                }
               
            }
        }
        
        for(int i = 0; i >=3 ; i++){
            sol1[i][1] = sol1[i][0];
            sol2[i][1] = sol2[i][0];
            sol3[i][1] = sol3[i][0];
            sol4[i][1] = sol4[i][0];
            
            fien1[i][1] = fien1[i][0];
            fien2[i][1] = fien2[i][0];
            fien3[i][1] = fien3[i][0];
            fien4[i][1] = fien4[i][0];
        }
        
        do{
            
        }while((sol1[0][1] > 0 && sol2[0][1] > 0 && sol3[0][1] > 0 && sol4[0][1] > 0) || (fien1[0][1] > 0 && fien2[0][1] > 0 && fien3[0][1] > 0 && fien4[0][1] > 0));
        
        if(sol1[0][1] > 0 && sol2[0][1] > 0 && sol3[0][1] > 0 && sol4[0][1] > 0){
            System.out.println("DU VANN");
        }else{
            System.out.println("Du förlorade\nBättre lycka nästa gång");
        }
    }
    
    
    
    
    
    static void spelarVal(int sol, boolean vän){
        Scanner look = new Scanner(System.in);
        int val;
        do{
            System.out.println();
            if(vän){
                System.out.print("Välj en soldat\n"
                               + "1: Fotsoldat\n"
                               + "2: Riddare\n"
                               + "3: Trolkar\n"
                               + "4: Vit trollkar\n"
                               + "dit val: ");
            }else{
                System.out.print("Välj en fiende\n"
                               + "1: Fotsoldat\n"
                               + "2: Riddare\n"
                               + "3: Trolkar\n"
                               + "4: Vit trollkar\n"
                               + "dit val: ");
            }
            try{
                val = look.nextInt();
            
            }catch(Exception e){
                System.out.println("Du måste skriva en sifra");
                look.nextLine();
                continue;
            }
            
            if(val<=4&&val>=1){
                break;
            }
            
            System.out.println("Inte ett giltigt val");
        }while(true);
            
        if(vän){
            switch(sol){
                case 1:
                    switch(val){
                        case 1:
                            sol1 = fotsoldat;
                            break;
                        case 2:
                            sol1 = riddare;
                            break;
                        case 3:
                            sol1 = trolkar;
                            break;
                        case 4:
                            sol1 = vit_trolkar;
                            break;
                    }
                    break;
                case 2:
                    switch(val){
                        case 1:
                            sol2 = fotsoldat;
                            break;
                        case 2:
                            sol2 = riddare;
                            break;
                        case 3:
                            sol2 = trolkar;
                            break;
                        case 4:
                            sol2 = vit_trolkar;
                            break;
                    }
                    break;
                case 3:
                    switch(val){
                        case 1:
                            sol3 = fotsoldat;
                            break;
                        case 2:
                            sol3 = riddare;
                            break;
                        case 3:
                            sol3 = trolkar;
                        break;
                        case 4:
                            sol3 = vit_trolkar;
                            break;
                    }
                    break;
                case 4:
                    switch(val){
                        case 1:
                            sol4 = fotsoldat;
                            break;
                        case 2:
                            sol4 = riddare;
                            break;
                        case 3:
                            sol4 = trolkar;
                            break;
                        case 4:
                            sol4 = vit_trolkar;
                            break;
                    }
                    break;
            }
        }else{
            switch(sol){
                case 1:
                    switch(val){
                       case 1:
                            fien1 = fotsoldat;
                            break;
                        case 2:
                            fien1 = riddare;
                            break;
                        case 3:
                            fien1 = trolkar;
                            break;
                        case 4:
                            fien1 = vit_trolkar;
                            break;
                    }
                    break;
                case 2:
                    switch(val){
                        case 1:
                            fien2 = fotsoldat;
                            break;
                        case 2:
                            fien2 = riddare;
                            break;
                        case 3:
                            fien2 = trolkar;
                            break;
                        case 4:
                            fien2 = vit_trolkar;
                            break;
                    }
                    break;
                case 3:
                    switch(val){
                        case 1:
                            fien3 = fotsoldat;
                            break;
                        case 2:
                            fien3 = riddare;
                            break;
                        case 3:
                            fien3 = trolkar;
                            break;
                        case 4:
                            fien4 = vit_trolkar;
                            break;
                    }
                    break;
                case 4:
                    switch(val){
                        case 1:
                            fien4 = fotsoldat;
                            break;
                        case 2:
                            fien4 = riddare;
                            break;
                        case 3:
                            fien4 = trolkar;
                            break;
                        case 4:
                            fien4 = vit_trolkar;
                            break;
                    }
                    break;
           } 
        }
    }
    
    static void datorVal(int sol){
        Random rand = new Random();
        
        int val = rand.nextInt(4)+1;
        
        switch(sol){
            case 1:
                switch(val){
                   case 1:
                        fien1 = fotsoldat;
                        break;
                    case 2:
                        fien1 = riddare;
                        break;
                    case 3:
                        fien1 = trolkar;
                        break;
                    case 4:
                        fien1 = vit_trolkar;
                        break;
                }
                break;
            case 2:
                switch(val){
                    case 1:
                        fien2 = fotsoldat;
                        break;
                    case 2:
                        fien2 = riddare;
                        break;
                    case 3:
                        fien2 = trolkar;
                        break;
                    case 4:
                        fien2 = vit_trolkar;
                        break;
                }
                break;
            case 3:
                switch(val){
                    case 1:
                        fien3 = fotsoldat;
                        break;
                    case 2:
                        fien3 = riddare;
                        break;
                    case 3:
                        fien3 = trolkar;
                        break;
                    case 4:
                        fien4 = vit_trolkar;
                        break;
                }
                break;
            case 4:
                switch(val){
                    case 1:
                        fien4 = fotsoldat;
                        break;
                    case 2:
                        fien4 = riddare;
                        break;
                    case 3:
                        fien4 = trolkar;
                        break;
                    case 4:
                        fien4 = vit_trolkar;
                        break;
                }
                break;
        }
        
    }
    
    static int[][] datorSlump(){
        Random rand = new Random();
        
        int fien[][] = new int[7][2];
        
        fien[0][0] = (rand.nextInt(20)+1)*5+50;
        
        for(int i = 1; i<4; i++){
            fien[i][0] = rand.nextInt(5)*5+10;
        }
        
        fien[4][0] = 1;
        
        fien[5][0] = rand.nextInt(6)+1;
        
        if(fien[5][0] == 0){
            fien[5][0] = 0;
            return fien;
        }
        
        do{
            fien[6][0] = rand.nextInt(6)+1;
            if(fien[6][0] == 1){
                fien[6][0] = 0;
            }
        }while(fien[5][0] == fien[6][0]);
        
        fien[6][1] = 1;
        
        return fien;
    }
}
