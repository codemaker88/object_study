package hw2.movie.event;

import hw2.user.User;

public class AgeEvent implements UserDiscountEvent<User> {
    @Override
    public boolean isSatisfied(User user) {
        return false;
    }
}