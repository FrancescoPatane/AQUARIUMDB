
package it.fp.aquariumdb.security;

import it.fp.aquariumdb.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}