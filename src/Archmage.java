public class Archmage extends Unit {

    Archmage() {
        super("Archmage", 25, 8, 11,7,9,7);
    }

    @Override
    protected void set_enemy(int enemy_id) {
        super.set_enemy(enemy_id);
    }

    @Override
    protected void set_position(int position) {
        super.set_position(position);
    }

    @Override
    protected void ability() {

    }

    @Override
    protected boolean death() {
        return false;
    }

    @Override
    protected void move() {

    }
}
