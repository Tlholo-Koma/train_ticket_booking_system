import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
@Service
public class TokenValidationService {
    public boolean validateToken(String token){
        try{
            DecodedJWT jwt = JWT.decode(token);
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            if(formatter.format(jwt.getExpiresAt()).compareTo(formatter.format(new Date())) > 0){
                String issuer = jwt.getIssuer(); //Have to make this configurable
                String validIssuer = "https://login.microsoftonline.com/9188040d-6c67-4c5b-b112-36a304b66dad/v2.0";
                return validateIssuer(issuer, validIssuer);
            }
            else{
                return false;
            }
        }
        catch(Exception e){
            return false;
        }
    }
    private boolean validateIssuer(String issuer, String validIssuer){
        return issuer.equals(validIssuer);
    }
}