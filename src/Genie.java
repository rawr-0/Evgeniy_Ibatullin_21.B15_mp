public class Genie extends Unit{

    Genie() {
        super("Genie",40,12,12,13,16,7);
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
    protected void attack(){

    }
    @Override
    protected void defend(){

    }

    @Override
    protected boolean death() {
        return false;
    }

    @Override
    protected void move() {

    }
}
