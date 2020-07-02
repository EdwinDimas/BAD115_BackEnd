package com.bad.planilla.backend.apirest.auth;

public class JwtConfig {

	public static final String RSA_PRIVATE = "\r\n" + 
			"-----BEGIN RSA PRIVATE KEY-----\r\n" + 
			"MIIEogIBAAKCAQEAmbCxGPb7zdQl6aoyn0E0JVzWWds14eVRtNrQ7yHuXAEMDOKA\r\n" + 
			"CuLnm5bSAY3Ir4Nvf3cn8Vz69mnUV9NqsghM5y4oukAH3jh/19eeUjfbu0osH6dI\r\n" + 
			"3u84FaQi9XypjSgmncKLCibb+x/lysXLykiCRWrrjs09amfUOREdx/wq1TVKbQlG\r\n" + 
			"m87SWtKmb3pLIKJj/jx8aeBHrkO+e0UChORWAynAmmuw7pkh7hgNXSXW8z715btl\r\n" + 
			"Kz1xSGD+BKz7gVAS5rBU+CYvgobEqsf+rTrdlVG2vi7LgCrG3CrsqMmOANCTfeik\r\n" + 
			"8VhmfCS454ES/2OLT3u+o8Pr5YAiidAUxZW5UwIDAQABAoIBAH5xTeJ6IIQgi+iH\r\n" + 
			"7An1vQ8YKAnZPaVR4zzl4Ys74Ty0Z9OZ7ToHoADzvmck3Pz5J5w4zhXXJ2nfe6Ge\r\n" + 
			"AGPkTFDOOxewYkjDNvq/HDQMXKzjwxVvrZYsPXoghdpt65iEdfDJA1cgzU732ThQ\r\n" + 
			"Lu+HZBX0d0QPOv312jXxDQ1hO2QYo04XAzU1v2Rek9nzO+cb8p1oGr5n4t7IJqOp\r\n" + 
			"BrTEmYrHjuw0efvjK5Q7R7QWR9sE3hegQSrcfUP6cEFrxoBwoCrn3dRHm+D37vgS\r\n" + 
			"JZ5ZcuVuxsV6g44kBGIZkICIOYzEcEA5LUCuLw78It6KeU60W6aq13Vn+XrttKD0\r\n" + 
			"HE3IwhECgYEAzKUqKlnzXcxGAR2zrz0XVrnuWLOItfeJzd9/4rVRsKmtfMT7EyvE\r\n" + 
			"p4m243QIQdnYUWbCBDYkk3ywfjUa3HsrVC47ZS9y0r41nPCS+7PkO+dskmdynthb\r\n" + 
			"Cfst6j5G9I6tjZxKyq3UT0GRNmIXPIhTPtAZqyX3PrQE4Z8ItYRSekcCgYEAwEIS\r\n" + 
			"oQS1ZwFwwVlNCJsUphPy3Ts0qms/gKI6k8t0dPr6GyeI6lWS/MYPTzHMGS5YcN+5\r\n" + 
			"6fMRD2ZoVrty5ibrBDuV5Lh3Hp95S26TkFPeBKkNwURQ/7B22osi2QXg7mkT6QBK\r\n" + 
			"hOCUs0dmRaYyRygngU8VqXpdXIMG0SNBxK5gApUCgYBNvXCHJiSNPUxaoC3iJBL5\r\n" + 
			"nygsCgelGKQA0SaDuN2PfuWowCug3L+X5XjUbv+0BE1onuCVOPwsCvIA/6t0llWf\r\n" + 
			"ZPCrP5se86LqO3mapHvPRdq4wxOHxCjRYdnPYlkSDiFf6j9/PwmoEgBX6GtrU15M\r\n" + 
			"PkGCAqop57jy/LcSPXIXgQKBgCTMgMRRImeU3wAjF5uOE2W2a8XsjygPXxg/9PZU\r\n" + 
			"+vVpFHYeGxa/SmMXhdaisW4gcM0qBWvCGoHYGCCBwHxM9q7YuNgOdr5lx9GoWJZH\r\n" + 
			"dzdtJDTZ3qcSH6208/aWKXd4pVbzt0+3rL6j6+9o4Da+eNFHUd4ejcAnVCazmOMM\r\n" + 
			"fVQBAoGAH6F2b10AsvnW59GHB2pRSKONXX97kXRrXCZSXmzv8tkBlrwKILraiaO+\r\n" + 
			"bUGcv1+wypQYwB+0eM3y+ZT7FXwTHHyti0Jn30y73kRcOTvW22UXvRkskT1E7Oqs\r\n" + 
			"Qv8A06QujWdB8Hsm7c8JE59kG+GED3d3dlzedQ3QlRzR5WQTXWc=\r\n" + 
			"-----END RSA PRIVATE KEY-----";
	
	public static final String RSA_PUBLICA = "-----BEGIN PUBLIC KEY-----\r\n" + 
			"MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAmbCxGPb7zdQl6aoyn0E0\r\n" + 
			"JVzWWds14eVRtNrQ7yHuXAEMDOKACuLnm5bSAY3Ir4Nvf3cn8Vz69mnUV9NqsghM\r\n" + 
			"5y4oukAH3jh/19eeUjfbu0osH6dI3u84FaQi9XypjSgmncKLCibb+x/lysXLykiC\r\n" + 
			"RWrrjs09amfUOREdx/wq1TVKbQlGm87SWtKmb3pLIKJj/jx8aeBHrkO+e0UChORW\r\n" + 
			"AynAmmuw7pkh7hgNXSXW8z715btlKz1xSGD+BKz7gVAS5rBU+CYvgobEqsf+rTrd\r\n" + 
			"lVG2vi7LgCrG3CrsqMmOANCTfeik8VhmfCS454ES/2OLT3u+o8Pr5YAiidAUxZW5\r\n" + 
			"UwIDAQAB\r\n" + 
			"-----END PUBLIC KEY-----";
}
