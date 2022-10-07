public class Genie extends Unit{
    Genie(int position) {
        super("Genie",40,12,12,13,16,7,false);
        setPosition(position);
    }
    @Override
    protected void ability(Unit cast) {
        cast.damage_max_now -= 5;
        if(cast.damage_max_now < 1)
            cast.damage_max_now = 1;
        cast.damage_min_now -= 5;
        if(cast.damage_min_now < 1)
            cast.damage_min_now = 1;
        System.out.print("Genie cast weakness\n");
    }
}
