## StringRedisTemplate
~~~~
- redisTemplate.opsForValue();//操作字符串
- redisTemplate.opsForHash();//操作hash
- redisTemplate.opsForList();//操作list
- redisTemplate.opsForSet();//操作set
- redisTemplate.opsForZSet();//操作有序set
~~~~
## 拦截器
~~~~
//        if (Objects.equals(request.getServletPath(), url) || Objects.equals(request.getServletPath(), "/user/adduser")) {
//            return true;
//        }
//        try {
//            Cookie[] cookies = request.getCookies();
//            if (cookies != null && cookies.length > 0) {
//                String token = null;
//                String hfCookie = null;
//                for (Cookie cookie : cookies) {
//                    if (Objects.equals(cookie.getName(), "Token") && cookie.getValue() != "") {
//                        token = cookie.getValue();
//                    }
//                    if (Objects.equals(cookie.getName(), "hf_cookie") && cookie.getValue() != "") {
//                        hfCookie = cookie.getValue();
//                    }
//                }
//                if (token != null && hfCookie != null) {
//                    if (findLoginsService.detection(token, hfCookie)) {
//                        return true;
//                    }
//                }
//            }
//        } catch (Exception ignored) {
//        }
//        JSONObject result = new JSONObject();
//        result.put("error", "未登录或者该账号没有访问权限");
//        result.put("start", "nono");
//        response.setCharacterEncoding("UTF-8");
//        response.setContentType("application/json;charset=utf-8");
//        response.getWriter().println(result.toJSONString());
~~~~