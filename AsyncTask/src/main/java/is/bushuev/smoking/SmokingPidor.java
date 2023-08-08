package is.bushuev.smoking;

public class SmokingPidor implements Runnable {

    Cigarette cigarette;
    Jiga jiga;
    public String name;

    public SmokingPidor(String name, Jiga jiga) {
        cigarette = new Cigarette();
        this.name = name;
        this.jiga = jiga;
    }

    @Override
    public void run() {
        jiga.burnSigaret(cigarette);
        System.out.println(name + " started smoke");
        cigarette.smoke();
        jiga.putOut(cigarette);
        cigarette.smoke();
        System.out.println(name + " ended smoke");
    }
}
