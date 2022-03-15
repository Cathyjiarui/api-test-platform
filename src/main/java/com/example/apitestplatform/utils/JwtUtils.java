package com.example.apitestplatform.utils;

import com.example.apitestplatform.model.entity.UserDO;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * @ClassName JwtUtils
 * @Description JWT工具类
 * @Author ZhangJia
 * @Date 2020/10/22
 * @Version 1.0
 **/
public class JwtUtils {

    /**
     * 过期时间，一周
     */
    private static final long EXPIRE = 60000 * 60 * 24 * 7;

    /**
     * 加密密钥
     */
    private static final String SECRET = "CathyJia";

    /**
     * 令牌前缀
     */
    private static final String TOKEN_PREFIX = "Cathy";

    /**
     * subject(主题)
     */
    private static final String SUBJECT = "Cathy";

    /**
     * 根据用户信息，生成令牌
     * @param userDO 用户信息
     * @return java.lang.String
     * @Exception
     **/
    public static String geneJsonWebToken(UserDO userDO) {
        String token = Jwts.builder().setSubject(SUBJECT)
                .claim("head_img", userDO.getHeadImg())
                .claim("id", userDO.getId())
                .claim("name", userDO.getName())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
                .signWith(SignatureAlgorithm.HS256, SECRET).compact();
        token = TOKEN_PREFIX + token;
        return token;
    }

    /**
     * 校验token的方法
     * @param token token
     * @return io.jsonwebtoken.Claims
     * @Exception
     **/
    public static Claims checkJwt(String token) {
        try {
            final Claims claims = Jwts.parser().setSigningKey(SECRET)
                    .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                    .getBody();
            return claims;
        } catch (Exception e) {
            return null;
        }
    }
}
