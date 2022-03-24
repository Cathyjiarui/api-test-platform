package com.example.apitestplatform.controller;

import com.example.apitestplatform.utils.JsonData;
import org.apache.ibatis.annotations.Param;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/api/vi/pro/encryptionAndDecryption")
public class encryptionAndDecryptionController {

    @GetMapping("encryption")
    public JsonData encryption(@Param("str") String str){
        String encodeStr;
        try{
            BASE64Encoder base64Encoder = new BASE64Encoder();
            encodeStr = base64Encoder.encode(str.getBytes());
            return JsonData.buildSuccess(encodeStr);
        }catch (Exception e){
            return JsonData.buildError(e.getMessage());
        }
    }

    @GetMapping("decryption")
    public JsonData decryption(@Param("str") String str){
        String decoderStr;
        try {
            BASE64Decoder base64Decoder = new BASE64Decoder();
            byte[] b = base64Decoder.decodeBuffer(str);
            decoderStr = new String(b);
            return JsonData.buildSuccess(decoderStr);
        } catch (Exception e) {
            return JsonData.buildError(e.getMessage());
        }
    }
}
