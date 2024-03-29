package com.kbtg.apidesign01.wallet;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record WalletRequestDto(

        @NotNull
                @Size(min=3, max =20, message = "wallet name should contain characters between 3 to 20")
        String name,
        @NotNull
                @Email(message = "email should be valid")
        String email) {
}
