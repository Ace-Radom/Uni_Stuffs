public class KITogram {
    private User user1 = null;
    private User user2 = null;
    private User user3 = null;

    private boolean checkUserExists(String username) {
        if (this.user1 != null && this.user1.getUsername().equalsIgnoreCase(username)) {
            return true;
        } else if (this.user2 != null && this.user2.getUsername().equalsIgnoreCase(username)) {
            return true;
        } else if (this.user3 != null && this.user3.getUsername().equalsIgnoreCase(username)) {
            return true;
        } else {
            return false;
        }
    }

    private void addUser(String username, String displayName, AccountType accountType) {
        if (this.checkUserExists(username)) {
            IO.println("Error, user already exists");
            return;
        }

        if (this.user1 == null) {
            this.user1 = new User(username, displayName, accountType);
        } else if (this.user2 == null) {
            this.user2 = new User(username, displayName, accountType);
        } else if (this.user3 == null) {
            this.user3 = new User(username, displayName, accountType);
        } else {
            IO.println("Error, too many users");
            return;
        }

        IO.println("OK");
        return;
    }

    private void showUser(String username) {
        if (this.user1 != null && this.user1.getUsername().equalsIgnoreCase(username)) {
            IO.println(this.user1.showProfile());
        } else if (this.user2 != null && this.user2.getUsername().equalsIgnoreCase(username)) {
            IO.println(this.user2.showProfile());
        } else if (this.user3 != null && this.user3.getUsername().equalsIgnoreCase(username)) {
            IO.println(this.user3.showProfile());
        } else {
            IO.println("Error, user unknown");
        }
        return;
    }

    public static void main(String[] args) {
        KITogram data = new KITogram();

        while (true) {
            String input = IO.readln();

            if (input == null || input.isBlank()) {
                continue;
            }
            input = input.strip();

            int firstWsPos = input.indexOf(' ');
            String cmd = (firstWsPos >= 0) ? input.substring(0, firstWsPos) : input;

            switch (cmd) {
                case "add-user":
                    if (firstWsPos < 0) {
                        IO.println("Error, missing username");
                        continue;
                    }

                    int startIndex = cmd.length() + 1;
                    int endIndex = input.indexOf(' ', startIndex);
                    if (endIndex < 0) {
                        String username = input.substring(startIndex);
                        data.addUser(username, username, AccountType.PUBLIC);
                        // no display name
                    } else {
                        String username = input.substring(startIndex, endIndex);
                        startIndex = endIndex + 1;
                        String displayName = input.substring(startIndex);
                        data.addUser(username, displayName, AccountType.PUBLIC);
                        // with display name
                    }                    
                    break;

                case "show-user":
                    if (firstWsPos < 0) {
                        IO.println("Error, missing username");
                        continue;
                    }
                    
                    data.showUser(input.substring(cmd.length() + 1));
                    break;

                case "quit":
                    return;
            
                default:
                    IO.println("Error, unknown command");
                    break;
            }
        }
    }
}
