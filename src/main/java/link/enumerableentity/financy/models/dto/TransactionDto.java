package link.enumerableentity.financy.models.dto;

import link.enumerableentity.financy.enums.Type;
import link.enumerableentity.financy.models.Category;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class TransactionDto {

    @NotBlank(message = "Title can't be empty")
    @Size(min = 3, max = 30, message = "Length must be between 3 an 30")
    private String title;

    @NotNull(message = "Transaction type can't be null")
    private Type type;

    @NotNull(message = "Transaction category can't be null")
    private Category category;

    @PositiveOrZero(message = "Amount can't be negative number")
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
