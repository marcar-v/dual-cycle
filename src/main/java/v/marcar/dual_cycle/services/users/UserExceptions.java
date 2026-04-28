package v.marcar.dual_cycle.services.users;

public final class UserExceptions {
    public static class UserNotFoundException extends RuntimeException{

        public UserNotFoundException (String userID){
            super("User '"+userID+"' not found.");
        }
    }
    public static class UserAlreadyExistsException extends RuntimeException{

        public UserAlreadyExistsException (String userID){
            super("User '"+userID+"' already exists.");
        }
    }
}

