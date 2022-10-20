
public class adultClass extends User {
    
    public adultClass(String userName, int ID, String userAddress, int userAge, String userPhoneNumber)
    {
        this.setName(userName);
        this.setID(ID);
        this.setAddress(userAddress);
        this.setAge(userAge);
        numberRentals = 0;
        fineAmount = 0;
        phoneNumber = userPhoneNumber;
    }
    
}
