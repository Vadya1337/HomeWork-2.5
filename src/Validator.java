import exceptoins.WrongLoginException;
import exceptoins.WrongPasswordException;

import java.util.regex.Pattern;

public class Validator {
    private static final Pattern LOGIN_PATTERN = Pattern.compile("[a-zA-z0-z9_]{1,20}");
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("[a-zA-z0-z9]{1,20}");

public static void  validate(String login, String password, String confirmPassword){
    try {
        validateLogin(login);
        validatePassword(password,confirmPassword);
    }catch (WrongLoginException e){

    }catch (WrongPasswordException e){
        System.out.println(e.getMessage());
    }finally{
        System.out.println("Валидация пройдена");
    }

}
private static void validateLogin(String login) throws WrongLoginException{
    if (!LOGIN_PATTERN.matcher(login).matches()){
        throw new WrongLoginException("Логин неверный, проверьте корректность введённых данных");
    }
}
    private static void validatePassword(String password,String confirmPassword) throws WrongPasswordException {
        if (!PASSWORD_PATTERN.matcher(password).matches()){
            throw new WrongPasswordException("пароль неверный, проверьте корректность введённых данных");
        }
        if (!password.equals(confirmPassword)){
            throw new WrongPasswordException("Пароли не совпадают, проверьте корректность введённых данных");
        }
    }
}
