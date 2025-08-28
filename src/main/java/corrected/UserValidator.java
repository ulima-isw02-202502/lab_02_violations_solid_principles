package corrected;

import java.util.regex.Pattern;

public class UserValidator extends User  {

    public UserValidator() {
        super();
    }

    public boolean validateUser(User user) {
        if (user.name == null || user.name.trim().isEmpty()) {
            return false;
        }
        if (user.email == null || !isValidEmail(user.email)) {
            return false;
        }
        return user.userType != null && (user.userType.equals("PREMIUM")
                || user.userType.equals("REGULAR") || user.userType.equals("VIP"));
    }

    private boolean isValidEmail(String email) {
        return Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$").matcher(email).matches();
    }
}
