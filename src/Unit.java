public abstract class Unit {

    protected String name;
    protected int health_points;
    protected int armor;
    protected int attack;
    protected int enemy_id;
    protected int position;
    protected int damage_min;
    protected int damage_max;
    protected int speed;

    Unit(String name,int health_points,int armor,int attack,int damage_min,int damage_max,int speed){
        this.name = name; this.health_points = health_points; this.armor=armor;
        this.attack = attack; this.speed =speed; this.damage_min=damage_min; this.damage_max=damage_max;
    }
    protected void set_enemy(int enemy_id){
        this.enemy_id = enemy_id;
    }
    protected void set_position(int position){
        this.position = position;
    }
    protected abstract void ability();
    protected abstract void attack();
    protected abstract void defend();
    protected abstract boolean death();
    protected abstract void move();
}

