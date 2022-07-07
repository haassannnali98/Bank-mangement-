package finalProject;
public class Account{


    protected String name;
    protected String add;
    protected String aid;
    protected double abal;
    static int taxx;

    public String getName() {

        return name;
    }
    public void setName(String name) {

        this.name = name;
    }

    public String getAdd() {

        return add;
    }
    public void setAdd(String add) {

        this.add = add;
    }

    public String getAid() {
        return aid;
    }
    public void setAid(String aid) {

        this.aid = aid;
    }

    public double getAbal() {

        return abal;
    }
    public void setAbal(double abal) {

        this.abal = abal;
    }
    public static void setTaxx(int tax) {

        taxx = tax;
    }
    public static int getTaxx() {

        return taxx;
    }

    @Override
    public String toString() {
        return "Username = " + name + "\nAddress = " + add + "\nAccount ID = " + aid + "\nBalance = " + abal + "\ntax ="+ taxx;
    }
}
