package test.human;

public class Person {

    protected String firstName;
    protected String lastNAme;
    protected int age;
    public boolean married;
    protected Person partner = null;

    public Person(String firstName, String lastNAme, int age, boolean married) {
        this.firstName = firstName;
        this.lastNAme = lastNAme;
        this.age = age;
        this.married = married;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFullName() {
        return this.firstName + " " + this.lastNAme;
    }

    public String getLastNAme(){
    return this.lastNAme;
    }

    public String getSpouseName() {
        if (this.partner == null) {
            return "This person does not have a spouse";
        } else {
            return this.partner.firstName + " " + this.partner.lastNAme;
        }
    }

    public void printFavoriteThings() {
        System.out.println("As a Human I like to eat and sleep");
    }

    public boolean isRetired() {
        return this.age >= 60;
    }

    public boolean canGetMarried(Person spouse) {
        return (!this.married && !spouse.married);
    }

    public void registerPartner(Person spouse) {
        this.partner = spouse;
        spouse.partner = this;
        spouse.married = true;
        this.married = true;
    }

    public void registerPartnership(Person spouse) {
        if (this.canGetMarried(spouse)) {
            registerPartner(spouse);
            ((Woman) spouse).setOriginalLastName(spouse.lastNAme);
            spouse.lastNAme = this.lastNAme;
        } else {
            System.out.println("You or the other person is already married");
        }
    }

    public void deregisterPartnership() {
        if (this.married) {
            this.married = false;
            this.partner.married = false;
            if (this.partner instanceof Woman) {
                this.partner.lastNAme = ((Woman) this.partner).resetLastName();
            }
            this.partner.partner = null;
            this.partner = null;
        } else {
            System.out.println("Can not deregister marriage, because you are not married");
        }
    }

    public void printHumanProperties() {
        System.out.println("Full name: " + this.getFullName());
        System.out.println("Age: " + this.getAge());
        System.out.println("Married: " + this.married);
        System.out.println("Spouse name: " + this.getSpouseName());
        System.out.println("Retired: " + this.isRetired());
    }
}
