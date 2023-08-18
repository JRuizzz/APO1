package model;
import java.util.Calendar;
public class Premium extends User {
    
    private Category category;
    
    public Premium(String id, String name, String nickname, Category category, Calendar signUpDate) {
        super(id, name, nickname,signUpDate);
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


    
}
