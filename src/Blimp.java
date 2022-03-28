public class Blimp extends Flyer
{
    Blimp()
    {
        super();
        this.y-=this.height*3;
        this.height = this.height*4;
        this.width=50;
    }

}
