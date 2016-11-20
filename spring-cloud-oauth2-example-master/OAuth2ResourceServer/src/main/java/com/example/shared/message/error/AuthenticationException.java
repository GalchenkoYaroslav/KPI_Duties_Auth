package com.example.shared.message.error;


import com.example.shared.message.utils.MainServerWebException;

/**
 * Unchecked exception thrown when given authorization data is not valid.
 *
 * @author Olexandr Shevchenko
 * @version 1.0
 * @since 11.09.2016
 */
public class AuthenticationException extends MainServerWebException {

    public AuthenticationException() {
        super(401, "Authentication Error", "Authentication Error. The username or password were incorrect");
    }


}
