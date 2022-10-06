public class Archmage extends Unit {
    Archmage(int position) {
        super("Archmage", 25, 8, 11,7,9,7,true);
        setPosition(position);
    }
    @Override
    protected void ability(Unit cast) {
        damage_max_now += 2;
        damage_min_now += 2;
        System.out.print("Archmage cast strengthening\n");
    }
}
