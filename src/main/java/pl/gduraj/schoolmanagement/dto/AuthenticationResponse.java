package pl.gduraj.schoolmanagement.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author grzeg
 */

public class AuthenticationResponse {

    private String jwtToken;

    public AuthenticationResponse(final String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }
}
