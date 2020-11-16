package assignment8;

import java.util.Random;
import java.util.Scanner;

public class Email {

    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 10;
    private String companySuffix = "aeycompany.com";
    private String firstName;
    private String lastName;
    private String department;
    private String alternateEmail;
    private String password;
    private String email;

    // Constructor to receive the first name and last name
    public Email(String firstName, String lastName) {
        this.firstName=firstName;
        this.lastName=lastName;
        System.out.println("New Worker: "+ this.firstName+" "+this.lastName);

        this.department=setDepartment();
        this.password=randomPassword(defaultPasswordLength);
        email=firstName.toLowerCase()+"."+lastName.toLowerCase()+"@"+department+"."+companySuffix;

    }

    // Ask for the department-return the department
    private String setDepartment() {
        System.out.println("Department Codes: \n" + "1 for Sales\n" +
                "2 for Development\n" + "3 for Accounting\n" +
                "0 for none\n"+ "Enter department code:");
        Scanner scan=new Scanner(System.in);
        int dpt=scan.nextInt();
        if (dpt==1){ return "sales";
        } else if(dpt==2){ return "dev";
        }else if(dpt==3){ return "acct";
        }else { return ""; }
    }

    // Generate a random password
    private String randomPassword(int length) {
        String passwordSet="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
        char[] password=new char[length];
        for (int i = 0; i < length; i++) {
            int rand=(int)(Math.random()*passwordSet.length());
            password[i]=passwordSet.charAt(rand);
        }
        return new String(password);
//        Random rand=new Random();    此方法在random生成的密码前会有一个null出现 i值不对，不要用
//        char[]text=new char[defaultPasswordLength];
//        for (int i = 0; i < defaultPasswordLength; i++) {
//            text[i]=passwordSet.charAt(rand.nextInt(passwordSet.length()));
//        }
//        for (int i = 0; i < text.length; i++) {
//            this.password+=text[i];
//        }
//        return "Password is "+ this.password;

    }

    public void setMailboxCapacity(int mailboxCapacity) {
        this.mailboxCapacity = mailboxCapacity;
    }

    public void setAlternateEmail(String alternateEmail) {
        this.alternateEmail = alternateEmail;
    }

    public void changePassword(String password){
        this.password=password;
    }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    public String getPassword() {
        return password;
    }
    public String showInfo(){
        return "DISPLAY NAME: "+firstName+" "+lastName+"\n"+
                "DEPARTMENT: "+ department+"\n"+
                "COMPANY EMAIL: "+email+"\n"+
                "PASSWORD: "+password+"\n"+
                "MAILBOX CAPACITY: "+mailboxCapacity+"mb";
    }
}
