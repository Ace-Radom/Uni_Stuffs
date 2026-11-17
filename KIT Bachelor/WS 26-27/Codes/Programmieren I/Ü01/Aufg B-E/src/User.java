public class User {
    private final String username;
    private final String displayName;
    private final AccountType accountType;

    public User(String username, String displayName, AccountType accountType) {
        this.username = username;
        this.displayName = (displayName != null) ? displayName : username;
        this.accountType = accountType;
        return;
    }

    public User(String username, AccountType accountType) {
        this(username, null, accountType);
        return;
    }

    public String getUsername() {
        return this.username;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public AccountType getAccountType() {
        return this.accountType;
    }

    public String toString() {
        return "%s (%s), %s".formatted(this.username, this.displayName, this.accountType);
    }

    public String showProfile() {
        return "Username: %s\nDisplay name: %s\nAccount type: %s".formatted(this.username, this.displayName, this.accountType);
    }

    public boolean equals(Object o) {
        if (o instanceof User user) {
            return user.username.equalsIgnoreCase(this.username);
        }
        return false;
    }

    public int hashCode() {
        return this.username.toLowerCase().hashCode();
    }
}
