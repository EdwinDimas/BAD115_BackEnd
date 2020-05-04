package com.bad.planilla.backend.apirest.globals;

public class RegexGeneral {

    public boolean testEmail(String text){
        return text.matches("^(.+)@(.+)$");
    }

    public boolean testNit(String text){
        return text.matches("(?:\\d{4}-)\\d{6}-\\d{3}-\\d{1}");
    }

    public boolean testString(String text){
        return text.matches("^[ A-Za-z]+$");
    }

    public boolean testTelefono(String text){
        return text.matches("(?:\\d{4}-)\\d{4}");
    }

    public boolean testPaginaWeb(String text){
        return text.matches("^(http:\\/\\/|https:\\/\\/)?(www.)?([a-zA-Z0-9]+).[a-zA-Z0-9]*.[a-z]{3}.?([a-z]+)?$");
    }
}
