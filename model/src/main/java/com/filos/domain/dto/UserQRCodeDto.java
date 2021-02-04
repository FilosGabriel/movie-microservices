package com.filos.domain.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserQRCodeDto extends UserDto {
    private String qrCode;
    private String secretKey;
}
