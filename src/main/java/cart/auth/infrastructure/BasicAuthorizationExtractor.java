package cart.auth.infrastructure;

import cart.auth.dto.UserInfo;
import cart.common.exceptions.AuthorizationException;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import org.apache.tomcat.util.codec.binary.Base64;

public class BasicAuthorizationExtractor {
    
    private static final String BASIC_TYPE = "Basic";
    private static final String DELIMITER = ":";
    String AUTHORIZATION = "Authorization";
    
    public UserInfo extract(final HttpServletRequest request) {
        return Optional.ofNullable(request.getHeader(this.AUTHORIZATION))
                .filter(header -> header.toLowerCase().startsWith(BASIC_TYPE.toLowerCase()))
                .map(header -> header.substring(BASIC_TYPE.length()).trim())
                .map(Base64::decodeBase64)
                .map(String::new)
                .map(decodedString -> decodedString.split(DELIMITER))
                .map(credentials -> UserInfo.of(credentials[0], credentials[1]))
                .orElseThrow(() -> new AuthorizationException("유저 인증 정보가 잘못되었습니다."));
    }
}