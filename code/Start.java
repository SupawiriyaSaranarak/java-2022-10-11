import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.SpringVersion;
@Love(city = "Bangkok")
class Start {
    @ShowLog
    public static void main (String[] data) {
        System.out.println(SpringVersion.getVersion());
        System.out.println("Welcome to Java!");
        ApplicationContext context;
        context = new AnnotationConfigApplicationContext(SetUp.class, SetUp2.class );
        UserX uX = new UserX();
        UserY uY = new UserY();
        String nUy = uY.name;
        String[] all = context.getBeanDefinitionNames();
        for (int i = 0; i < all.length; i++) {
            System.out.println( all[i]);
        }
        Player p  = context.getBean("goal-keeper", Player.class);
        System.out.println(p.name);
        
    }
}

@Deprecated
class UserX {
    int id;
    String name;
}
class UserY {
    int id;
    @Deprecated
    String name;
    String email;
}
@interface Love {
    String city();
}
@interface ShowLog {
}

@Configuration
class SetUp { // configuration class // can be name in other word
    @Bean 
    Cashier  createCashier() { // name of method will be automatically the name of bean
        Cashier c = new Cashier();
        c.tax = 15.0;
        c.name = "Susan W";
        return c;
    }
    
    @Bean("captain") // specify the name of bean
    Player create1() {
        Player p = new Player();
        p.name = "Harry Kane";
        p.number = 10;
        p.salary = 75000.0;
        return p;
    }
    @Bean("goal-keeper")
    Player create2() {
        Player p = new Player();
        p.name = "Jordan Pickford";
        p.number = 5;
        p.salary = 40000.0;
        return p;
    }
    
}

//@Configuration //now, weither use or not it will be crated automatically
class SetUp2 { // configuration class // can be name in other word
    @Bean 
    Cashier  createCashier() { // name of method will be automatically the name of bean
        Cashier c = new Cashier();
        c.tax = 15.0;
        c.name = "Susan W";
        return c;
    }
}
class Cashier {
    double tax;
    String name;
}
class Player {
    String name;
    int number;
    double salary;
}