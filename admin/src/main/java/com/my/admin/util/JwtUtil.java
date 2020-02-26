package com.my.admin.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.my.admin.common.StaticVar;
import lombok.extern.slf4j.Slf4j;

import java.io.UnsupportedEncodingException;
import java.util.Date;

/**
 * @Author lianjie Zhu
 * @Date 2020/2/26 17:42
 * @Version 1.0
 *  jwt token 工具类
 */
@Slf4j(topic = "JwtUtil工具类--->")
public class JwtUtil {

    /**
     *      jwt 生成token
     * @param userId  用户id （管理员id）
     * @param name  用户真实姓名
     * @return token
     */
    public final static String cteateToken( final String userId, final String name) {
        String token = null;
        try {
            Date expiresAt = new Date(System.currentTimeMillis() + 24L * 60L * 3600L * 1000L);
            token = JWT.create()
                    .withIssuer(StaticVar.JwtName)
                    .withClaim("userId", userId)
                    .withClaim("name", name)
                    .withExpiresAt(expiresAt)
                    .sign(Algorithm.HMAC256(StaticVar.JwtSalt));
        } catch (JWTCreationException exception){
            log.error("JWTCreationException：{}",exception.getMessage());
        } catch (IllegalArgumentException e) {
            log.error("IllegalArgumentException：{}",e.getMessage());
        } catch (UnsupportedEncodingException e) {
            log.error("UnsupportedEncodingException：{}",e.getMessage());
        }
        log.info("用户{}生成token成功",name);
        return token;
    }


    /**
     *      验证token 是否合法
     * @param token token
     * @return boolean true 合法
     *                 false 不合法
     */
    public final static boolean checkToken(final String token) {
        DecodedJWT jwt = null;
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(StaticVar.JwtSalt))
                    .withIssuer(StaticVar.JwtName)
                    .build(); //Reusable verifier instance
            jwt = verifier.verify(token);
        } catch (JWTVerificationException exception){
            log.error("JWTVerificationException：{}",exception.getMessage());
        } catch (IllegalArgumentException e) {
            log.error("IllegalArgumentException：{}",e.getMessage());
        } catch (UnsupportedEncodingException e) {
            log.error("UnsupportedEncodingException：{}",e.getMessage());
        }
        log.info("解析成功的的token：{}",jwt.toString());
        return jwt == null ? false:true;
    }
}
