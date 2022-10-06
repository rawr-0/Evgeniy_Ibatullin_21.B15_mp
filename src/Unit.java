import java.util.Optional;
import java.util.Random;

public abstract class Unit {

    protected String name;
    protected int health_points;
    protected int armor;
    protected int armor_now;
    protected int attack;
    protected int timer = 0;
//    protected int enemy_id;
//    protected int my_id;
    protected int position;
    protected int damage_min;

    protected int damage_min_now;
    protected int damage_max;
    protected int damage_max_now;
    protected int speed;
    protected boolean range;
    protected boolean alive = true;

    Unit(String name,int health_points,int armor,int attack,int damage_min,int damage_max,
         int speed,boolean range){
        this.name = name; this.health_points = health_points; this.armor=armor;
        this.attack = attack; this.speed =speed; this.damage_min=damage_min;
        this.damage_max=damage_max; this.range=range;
        damage_max_now = damage_max;
        damage_min_now = damage_min;
        armor_now = 0;
    }
    protected String say_name(){
        return name;
    }
    protected void  setPosition(int pos){
        position = pos;
    }
    protected abstract void ability(Unit cast);
    protected void take_damage(int damage_min_now,int damage_max_now){
        Random random = new Random();
        int q = random.nextInt((damage_max_now+1)-damage_min_now)+damage_min_now;
        if(q - armor_now > 0) {
            health_points -= (q - armor_now);
        }
        else System.out.print(name + " absorb damage\n");
        death();
    }
    protected void attack(Unit attacked){
        new_move(timer);
        if(attacked.is_alive()) {
            if (range) {
                System.out.print(name + " range attacked " + attacked.say_name()+"\n");
                attacked.take_damage(damage_min, damage_max_now);
            } else {
                if (speed >= Math.abs(position - attacked.position)) {
                    System.out.print(name + " attacked " + attacked.say_name()+"\n");
                    if(Math.abs(position - (attacked.position - 1)) <  Math.abs(position - (attacked.position + 1)))
                        position = attacked.position -1;
                    else
                        position = attacked.position +1;
                    attacked.take_damage(damage_min, damage_max_now);
                }
                else move(attacked.position);
            }
        }
    }
    protected void new_move(int timer){
        armor_now = 0;
        timer++;
        if(timer == 3){
            damage_max_now = damage_max;
            damage_min_now = damage_min;
            timer = 0;
        }
    }
    protected void defend(){
        new_move(timer);
        armor_now = armor;
        System.out.print(name +" defended\n");
    }
    protected void death(){
        if (health_points <= 0){
            alive = false;
            System.out.print(name+" died\n");
        }
    }
    protected boolean is_alive(){
        return alive;
    }
    protected void move(int end_pos){
        new_move(timer);
        System.out.print(name + " moved\n");
        if(position < end_pos)
            if(end_pos-1 <= position+speed)
                position = end_pos-1;
            else
                position += speed;
        else
            if(end_pos+1 >= position-speed)
                position = end_pos+1;
            else
                position -= speed;
    }
}

