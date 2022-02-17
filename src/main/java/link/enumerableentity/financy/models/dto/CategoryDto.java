package link.enumerableentity.financy.models.dto;

import link.enumerableentity.financy.enums.Type;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CategoryDto {

    @Size(min = 1, max = 20, message = "Should be from 1 to 20 symbols long")
    private String title;

    @NotNull(message = "Type can not be empty")
    private Type type;

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
}
