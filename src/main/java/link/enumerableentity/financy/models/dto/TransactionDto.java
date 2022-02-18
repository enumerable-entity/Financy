package link.enumerableentity.financy.models.dto;

import link.enumerableentity.financy.enums.Type;
import link.enumerableentity.financy.models.Category;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class TransactionDto {


    @Size(min = 3, max = 30, message = "Should be from 3 to 30 symbols long")
    private String title;

    @NotNull(message = "Type can not be empty")
    private Type type;

    @NotNull(message = "Category can not be empty")
    private Category category;

    @PositiveOrZero(message = "Can not be negative number")
    @Max(value = Long.MAX_VALUE)
    private double amount;

    @PastOrPresent(message = "Date can't be from future")
    private LocalDate date;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
