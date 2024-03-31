public class chairManufacturing {

}

abstract class ChairBase {
    protected int legsCount;
    protected String sitType;
    protected boolean hasBack;
    protected boolean hasElbows;
    protected String material;

    public ChairBase(int legsCount, String sitType, boolean hasBack, boolean hasElbows, String material) {
        this.legsCount = legsCount;
        this.sitType = sitType;
        this.hasBack = hasBack;
        this.hasElbows = hasElbows;
        this.material = material;
    }
}

