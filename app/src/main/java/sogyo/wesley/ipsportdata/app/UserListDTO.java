package sogyo.wesley.ipsportdata.app;

import sogyo.wesley.ipsportdata.domain.IAnalysor;

public class UserListDTO {
    public String name;


    public UserListDTO(String name, IAnalysor analysor) {
        this.name = name;

    }
    public String getName() {
        return name;
    }
}
