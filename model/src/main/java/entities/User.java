package entities;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
public class User {
    private UUID id;
    private String username;
    private LocalDate dateOfBirth;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
}
