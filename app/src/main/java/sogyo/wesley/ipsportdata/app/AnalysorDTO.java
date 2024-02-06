package sogyo.wesley.ipsportdata.app;

import sogyo.wesley.ipsportdata.domain.IAnalysor;

public class AnalysorDTO {
    String username;
    private UserListDTO[] userList; 

    public AnalysorDTO(IAnalysor analysor) {
        userList = new UserListDTO[3];
        userList[0] = new UserListDTO(analysor.getUsername(), analysor);
    }
    
    public UserListDTO[] getUsers() {
        return userList;
    }

    public void setUsers(UserListDTO[] userList) {
        this.userList = userList;
    }

    
}
