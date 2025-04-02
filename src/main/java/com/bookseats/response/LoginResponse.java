package com.bookseats.response;

import com.bookseats.dto.UserDTO;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class LoginResponse {

    @NonNull
    private UserDTO userDto;
    @NonNull
    private String token;

    @NonNull
    private int statusCode;


}
