import java.util.Random;

public class Main {
    public static void action(Archmage a,Genie g){
        Random random = new Random();
        for(int i = random.nextInt(2);g.is_alive() & a.is_alive();i++){
            //System.out.print(a.damage_min_now); System.out.print(" "); System.out.print(a.damage_max_now); System.out.print("\n");
            if(i % 2 == 0){
                int q = random.nextInt(5);
                if(q == 0)
                    a.move(g.position);
                if(q == 1)
                    a.attack(g);
                if(q == 2)
                    a.defend();
                if(q == 3)
                    a.attack(g);
                if(q == 4)
                    a.ability(a);
            }
            else{
                int q = random.nextInt(5);
                if(q == 0)
                    g.move(a.position);
                if(q == 1)
                    g.attack(a);
                if(q == 2)
                    g.defend();
                if(q == 3)
                    g.attack(a);
                if(q == 4)
                    g.ability(a);
            }
        }
    }
    public static void main(String[] args) {
        System.out.println("Game is starting");
        Genie g = new Genie(0);
        Archmage a = new Archmage(25);
       action(a,g);
    }
}
