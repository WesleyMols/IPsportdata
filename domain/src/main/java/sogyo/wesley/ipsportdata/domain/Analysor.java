package sogyo.wesley.ipsportdata.domain;

public class Analysor implements IAnalysor {
    String name = "";
    public Analysor(String name) {
        this.name = name;
    }

    @Override
    public String getUsername() {
        return name;
    }
}
