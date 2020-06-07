import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Mitran Kwatra on 7/8/2018.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class CCAuthToken {

    private String access_token;
    private String token_type;
    private int expires_in;
    private String scope;

    public String getAccessToken() {
        return access_token;
    }

    public String getTokenType() {
        return token_type;
    }

    public int getExpiresIn() {
        return expires_in;
    }

    public String getScope() {
        return scope;
    }

    @Override
    public String toString() {
        return "CCAuthToken{" +
                "access_token='" + access_token + '\'' +
                ", token_type='" + token_type + '\'' +
                ", expires_in=" + expires_in +
                ", scope='" + scope + '\'' +
                '}';
    }

}
