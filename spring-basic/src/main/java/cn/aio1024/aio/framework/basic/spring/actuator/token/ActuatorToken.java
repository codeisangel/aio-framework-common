package cn.aio1024.aio.framework.basic.spring.actuator.token;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTPayload;
import cn.hutool.jwt.signers.JWTSigner;
import cn.hutool.jwt.signers.JWTSignerUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

/**
 * @author lzm
 * @desc actuatorToken
 * @date 2024/07/02
 */
@Slf4j
public class ActuatorToken {
    private static final String ISSUER_KEY = "iss";
    private static String PUBLIC_KEY = null;
    private static JWTSigner JWT_PUBLIC_SIGNER = null;

    private static String ISSUER = null;

    private static String PRIVATE_KEY = null;
    private static JWTSigner JWT_PRIVATE_SIGNER = null;

    public static void setPublicKey(String publicKeyBase64,String issuer){
        PUBLIC_KEY = publicKeyBase64;
        JWT_PUBLIC_SIGNER = JWTSignerUtil.rs256(SecureUtil.rsa(null, PUBLIC_KEY).getPublicKey());
        ISSUER = issuer;
    }
    public static void setPrivateKey(String privateKeyBase64,String issuer){
        PRIVATE_KEY = privateKeyBase64;
        JWT_PRIVATE_SIGNER = JWTSignerUtil.rs256(SecureUtil.rsa(PRIVATE_KEY, null).getPrivateKey());
        ISSUER = issuer;
    }
    public static String createToken(String issuer, Map<String,Object> payloadMap){
        String sign = JWT.create()
                .setIssuer(issuer)
                .addPayloads(payloadMap)
                .sign(JWT_PRIVATE_SIGNER);
        return sign;
    }
    public static String createToken( Map<String,Object> payloadMap){
        String sign = JWT.create()
                .setIssuer(ISSUER)
                .addPayloads(payloadMap)
                .sign(JWT_PRIVATE_SIGNER);
        return sign;
    }
    public static boolean verify(String token){
        if (StringUtils.isBlank(token)){
            return false;
        }
        if (ObjectUtil.isNull(JWT_PUBLIC_SIGNER)){
            return false;
        }
        try {
            JWT jwt = JWT.create().setSigner(JWT_PUBLIC_SIGNER).parse(token);
            boolean verify = jwt.verify();
            if (!verify){
                log.warn("ActuatorToken 秘钥不匹配。");
                return false;
            }

            JWTPayload payload = jwt.getPayload();
            if (ObjectUtil.isEmpty(payload)){
                log.warn("ActuatorToken payload信息为空");
                return false;
            }
            Object issuer = payload.getClaim(ISSUER_KEY);
            if (ObjectUtil.isNull(issuer)){
                log.warn("ActuatorToken 未获取到合法的令牌颁发者");
                return false;
            }
            if (!StringUtils.equals(ISSUER,issuer.toString())) {
                log.warn("ActuatorToken 颁发者不合法");
                return false;
            }
            return true;

        }catch (Exception e){
            log.warn("ActuatorToken 解析失败。异常类[ {} ] 异常信息 ： {} ",e.getClass(),e.getMessage());
           return false;
        }
    }

}
