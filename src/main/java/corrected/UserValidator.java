package corrected;

import java.util.regex.Pattern;

public class UserValidator extends User  {

    public UserValidator(String name, String email, String userType, double totalPurchases) {
        super(name, email, userType, totalPurchases);
    }

    public boolean validateUser() {
        if (name == null || name.trim().isEmpty()) {
            return false;
        }
        if (email == null || !isValidEmail(email)) {
            return false;
        }
        return userType != null && (userType.equals("PREMIUM")
                || userType.equals("REGULAR") || userType.equals("VIP"));
    }

    private boolean isValidEmail(String email) {
        return Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$").matcher(email).matches();
    }
}
