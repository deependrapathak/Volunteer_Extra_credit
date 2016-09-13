package mum.edu.cs544.DAO;

import java.util.List;

import mum.edu.cs544.domain.Address;
import mum.edu.cs544.domain.User;

public interface IUserDAO {
void create(User user);
void saveNewAddress(Address address);
boolean authenticateUser(User user);
List<User> getAllUser();
}
