import java.util.List;

class User {
    String username;
    String password;
    String email;

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}

public class SILab2 {

    public boolean function (User user, List<String> allUsers) { //1
        String specialCharacters="!#$%&'()*+,-./:;<=>?@[]^_`{|}";  //2
        if (user==null) { //3
            throw new RuntimeException("The user is not instantiated"); //4
        }
        if (user.getUsername()==null || user.getPassword()==null) //5
            throw new RuntimeException("The user is missing some mandatory information"); //6
        String password = user.getPassword(); //7
        String passwordLower = password.toLowerCase(); //7
        if (passwordLower.contains(user.getUsername().toLowerCase())) { //8
            return false;//9
        }
        else if (passwordLower.length()<8) //10
            return false; //11
        else { //12
            boolean digit = false, upper = false, special = false; //13

            for (int i=0;i<password.length();i++) { //14.1, 14.2, 14.3
                if (Character.isDigit(password.charAt(i))) //15
                    digit = true; //16
                if (Character.isUpperCase(password.charAt(i))) //17
                    upper = true;//18
                if (specialCharacters.contains(String.valueOf(password.charAt(i)))) //19
                    special = true; //20
            }//21
            if (!digit || !upper || !special)//22
                return false;//23
        }//24
        return true; //25
    }//26
}