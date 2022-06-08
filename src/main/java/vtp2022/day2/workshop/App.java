package vtp2022.day2.workshop;
import vtp2022.day2.workshop.BankAccount;

/*
PS C:\Users\vans_\sdf-workshop1> git add . (add ALL content of cart to github)
git commit -m "While Loop"                  (add comment while committing)
git push origin main                        (push to main branch)
/* 
https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html
->
mvn archetype:generate -DgroupId=vtp2022.day2.workshop -DartifactId=workshop2 -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false
->
C:\Users\vans_\sdf-workshop1>cd sdf-workshop2
C:\Users\vans_\sdf-workshop1\sdf-workshop2>mvn compile
mvn compile exec:java -Dexec.mainClass="vtp2022.day2.workshop.App"
*/

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "~~~Hello World!~~~" );
        System.out.println( "Testing BankAccount.java" );
        BankAccount accOne = new BankAccount("John", 5000);
        accOne.deposit("1000");
        accOne.withdraw("2000");
        System.out.println("My name is " + accOne.getName());
        System.out.println("Account ID is " + accOne.getAcctId());

        BankAccount accTwo = new FixedDepositAccount("Wayne", 5000);
        System.out.println("My name is " + accTwo.getName());
        System.out.println(accTwo.getBalance());
        System.out.println(accTwo.isClosed());
        System.out.println(accTwo.getTransaction());
    }
}