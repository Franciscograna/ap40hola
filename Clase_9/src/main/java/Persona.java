package main;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class Persona {
private String name;
private String surname;
private LocalDate born;
}
