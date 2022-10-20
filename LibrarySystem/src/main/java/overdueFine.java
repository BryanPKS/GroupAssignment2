
public class overdueFine {
    
    float currentOwed;
    int daysOverdue;
    String itemTitle;
    String userName;
    //item itemOverdue;
    
    public overdueFine(String title, String name)
    {
        currentOwed = 0;
        daysOverdue = 0;
        itemTitle = title;
        userName = name;
    }
    
    //setters n getters!
    
    public void setCurrentOwed(float owed)
    {
        currentOwed = owed;
    }
    
    public void setDaysOverdue(int days)
    {
        daysOverdue = days;
    }
    
    public float getCurrentOwed()
    {
        return currentOwed;
    }
    
    public int getDaysOverdue()
    {
        return daysOverdue;
    }
    
    //relevant functions!
    
    public void addDay()
    {
        currentOwed += .10;
        daysOverdue++;
    }
    
}
