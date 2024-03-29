package com.kbtg.apidesign01.wallet;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record WalletUpdateRequestDto(
        @NotNull
        @Size(min=3, max =20, message = "wallet name should contain characters between 3 to 20")
        String name
        ) {
}
