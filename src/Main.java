import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
public class Main {
    public static void main(String[] args) {
            List<User> users = new ArrayList<>();
            users.add(new User("Alice", 30));
            users.add(new User("Bruce", 35));
            users.add(new User("Alice", 30));

            User oldestUser = getOldestUser(users);
            if (oldestUser != null) {
                System.out.println("Самый старый пользователь: " + oldestUser.getName() + ", Возраст: " + oldestUser.getAge());
            } else {
                System.out.println("Список пользователей пуст.");
            }
        }

        public static User getOldestUser(Collection<User> users) {
            return users.stream()
                    .distinct() // Удаление дубликатов на основе методов equals и hashCode.
                    .sorted(Comparator.comparing(User::getAge).thenComparing(User::getName))
                    .max(Comparator.comparing(User::getAge))
                    .orElse(null);
        }
    }
