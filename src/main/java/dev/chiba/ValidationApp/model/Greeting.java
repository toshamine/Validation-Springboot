package dev.chiba.ValidationApp.model;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Greeting {

    @NotNull(message = "From Must Not Be Null")
    @NotEmpty(message = "From Must Not Be Empty")
    private String from;

    @NotNull(message = "Message Must Not Be Null")
    @NotEmpty(message = "Message Must Not Be Empty")
    private String msg;

    @NotNull(message = "To Must Not Be Null")
    @NotEmpty(message = "To Must Not Be Empty")
    private String to;
}
