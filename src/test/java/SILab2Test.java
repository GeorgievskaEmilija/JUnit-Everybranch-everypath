import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {
    SILab2 lab = new SILab2();
    User user1 = null;
    User user2 = new User("user2", null, "user2@gmail.com");
    User user3 = new User ("emilija", "emi123klef3ijf", "emi@gmail.com");
    User user4 = new User("user4", "five", "user4@gmail.com");
    User user5 = new User("user5", "nr9358jf038jskao", "user5@gmail.com");
    User user6 = new User("user6", "sjer4w$^3?Sfe", "user6@gmail.com");


    List<String> users = new ArrayList();


    public void initList() {
        users.add("Sanja");
        users.add("Martina");
        users.add("Vlad");
        users.add("Emi");
    }


    @Test
    void everyBranchTest() {
        initList();
        RuntimeException ex;

        //user e null
        ex=assertThrows(RuntimeException.class, () -> lab.function(user1, users));
        assertTrue(ex.getMessage().contains("The user is not instantiated"));

        //lozinkata e null
        ex=assertThrows(RuntimeException.class, () -> lab.function(user2, users));
        assertTrue(ex.getMessage().contains("The user is missing some mandatory information"));

        //imeto go ima vo lozinkata
        assertEquals(false, lab.function(user3, users));

        //dolzinata na lozinkata e pomala od 8 karakteri
        assertEquals(false, lab.function(user4, users));

        //nema specialsign vo lozinkata
        assertEquals(false, lab.function(user5, users));

        //lozinkata  e vo red
        assertEquals(true, lab.function(user6, users));

    }
    @Test
    void everyPathTest(){
        RuntimeException ex;
        //1,2 - 3 - 4 - 26 , slucaj koga user e null
        ex=assertThrows(RuntimeException.class, () -> lab.function(user1, users));
        assertTrue(ex.getMessage().contains("The user is not instantiated"));

        //1,2 - 3 - 5 - 6 - 26 , slucaj koga lozinkata ili imeto se prazni
        ex=assertThrows(RuntimeException.class, () -> lab.function(user2, users));
        assertTrue(ex.getMessage().contains("The user is missing some mandatory information"));

        //1,2 - 3 - 5 - 7,8 - 9 -26, koga lozinkata go sodrzi korisnickoto ime
        assertFalse( lab.function(user3, users));

        //1,2 - 3  - 5- 7,8 - 10 -11 -26, koga lozinkata e pokratka od 8 karaktera
        assertFalse(lab.function(user4, users));

        //1,2 - 3- 5- 7,8 - 10 - 12,13 - 14.1 - 14.2 - 15 - 17 - 19 - 20 - 14.3 -14.2 - 21- 22 - 23 - 26 , ne sodrzi special sign
        assertFalse(lab.function(user5, users));

        //1,2 - 3- 5- 7,8 - 10 - 12,13 - 14.1 - 14.2 - 15 - 17 - 19 - 20 - 14.3 -14.2 - 21- 22 - 24 - 25- 26
                assertFalse(lab.function(user5, users));

        //1,2 - 3- 5- 7,8 - 10 - 12,13 - 14.1 - 14.2 - 15 - 16 - 17 - 18 - 19 - 14.3 -14.2 - 21- 22 - 23 - 26
        assertFalse(lab.function(user5, users));

        //1,2 - 3- 5- 7,8 - 10 - 12,13 - 14.1 - 14.2 - 15 - 16 - 17 - 18 - 19 - 14.3 -14.2 - 21- 22 - 24 - 25 - 26
        assertFalse(lab.function(user5, users));

        //1,2 - 3- 5- 7,8 - 10 - 12,13 - 14.1 - 14.2 - 15 -16- 17 -18- 19 - 20 -14.3 -21 -22 -23 -26
        //FALSE
        assertFalse(lab.function(user5, users));






    }


}